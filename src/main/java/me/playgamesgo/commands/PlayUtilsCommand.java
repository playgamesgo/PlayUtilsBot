package me.playgamesgo.commands;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import me.playgamesgo.Main;
import me.playgamesgo.modules.blockfront.BlockfrontModule;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

@Command(name = "playutils")
public final class PlayUtilsCommand {
    @Execute(name = "quit")
    public void quit(@Context SlashCommandInteractionEvent event) {
        event.reply("Shutting down...").setEphemeral(false).queue();
        Main.getJda().shutdown();
        System.exit(0);
    }

    @Execute(name = "reload")
    public void reload(@Context SlashCommandInteractionEvent event) {
        Main.getConfig().load();
        BlockfrontModule.getConfig().load();
        event.reply("Reloaded config!").setEphemeral(false).queue();
    }
}
