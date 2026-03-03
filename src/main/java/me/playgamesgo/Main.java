package me.playgamesgo;

import dev.rollczi.litecommands.jda.LiteJDAFactory;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.serdes.commons.SerdesCommons;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.Getter;
import me.playgamesgo.commands.PlayUtilsCommand;
import me.playgamesgo.modules.blockfront.BlockfrontModule;
import me.playgamesgo.utils.Config;
import me.playgamesgo.utils.serdes.CustomSerdes;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.File;

public final class Main {
    @Getter private static JDA jda;
    @Getter private static Config config;

    static void main() throws InterruptedException {
        // Load bytedeco's leptonica first so JNA finds it before the system lib
        org.bytedeco.leptonica.global.leptonica.pixCreate(1, 1, 8).close();

        config = ConfigManager.create(Config.class, it -> {
            it.configure(opt -> {
                opt.configurer(new YamlSnakeYamlConfigurer(), new SerdesCommons(), new CustomSerdes());
                opt.bindFile(new File("configs/config.yml"));
                opt.removeOrphans(true);
                opt.resolvePlaceholders();
            });
            it.saveDefaults();
            it.load(true);
        });

        jda = JDABuilder.createDefault(config.getBotToken())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS)
                .build();

        jda.awaitReady();

        LiteJDAFactory.builder(jda)
                .settings(settings -> settings.guilds(config.getCommandGuilds()))
                .commands(
                        new PlayUtilsCommand()
                )
                .build();

        new BlockfrontModule();
    }
}
