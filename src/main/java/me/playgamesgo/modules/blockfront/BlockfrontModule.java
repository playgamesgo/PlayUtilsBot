package me.playgamesgo.modules.blockfront;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.serdes.commons.SerdesCommons;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.Getter;
import me.playgamesgo.Main;
import me.playgamesgo.utils.serdes.CustomSerdes;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sourceforge.tess4j.Word;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

public final class BlockfrontModule extends ListenerAdapter {
    @Getter private static BlockfrontConfig config;
    private static final Pattern TRACKER_PATTER = Pattern.compile("\\((\\d{1,2})/(\\d{1,2})\\)");
    private final Map<Character, BufferedImage> atlas;
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public BlockfrontModule() {
        config = ConfigManager.create(BlockfrontConfig.class, it -> {
            it.configure(opt -> {
                opt.configurer(new YamlSnakeYamlConfigurer(), new SerdesCommons(), new CustomSerdes());
                opt.bindFile(new File("configs/blockfront.yml"));
                opt.removeOrphans(true);
                opt.resolvePlaceholders();
            });
            it.saveDefaults();
            it.load(true);
        });


        BufferedImage atlasImage;
        try {
            atlasImage = ImageIO.read(new File(config.getAtlasPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<Character, BufferedImage> atlas = TextImageUtils.getCharacterImageFromAtlas(atlasImage);
        Map<Character, BufferedImage> boldAtlas = TextImageUtils.getShiftedCharacterImageMap(atlas);
        this.atlas = TextImageUtils.getTrimmedCharacterImages(boldAtlas);

        Main.getJda().addEventListener(this);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        final MessageChannelUnion channel = event.getChannel();
        final Message message = event.getMessage();

        if (channel.getId().equals(config.getChannelId())) {
            final List<Message.Attachment> attachments = message.getAttachments();
            if (attachments.isEmpty()) return;

            final Message.Attachment attachment = attachments.getFirst();
            if (!attachment.isImage()) return;

            CompletableFuture.runAsync(() -> {
                String url = attachment.getUrl();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(java.net.URI.create(url))
                        .build();

                try {
                    HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(response.body()));
                    BufferedImage scaledImage = TextImageUtils.scaleImage(image);
                    List<Word> words = MissionReader.readUncompletedLines(scaledImage);
                    List<String> missions = MissionReader.readMission(image, words, 4, atlas);

                    List<MessageEmbed> embeds = new ArrayList<>();
                    missions.forEach(mission -> {
                        EmbedBuilder builder = new EmbedBuilder();
                        mission = TRACKER_PATTER.matcher(mission).replaceAll("").trim();

                        if (!mission.contains("with a(n)")) {
                            builder.setTitle(mission);
                            builder.setDescription("Any weapon");
                            embeds.add(builder.build());
                            return;
                        }

                        builder.setTitle(mission);
                        String[] parts = mission.split("with a\\(n\\)?");
                        String weapon = parts[1].trim();

                        Optional<BlockfrontConfig.WeaponInfo> weaponInfo = config.getWeapons().stream()
                                .filter(weaponData -> weaponData.getName().equals(weapon)).findFirst();
                        if (weaponInfo.isEmpty()) {
                            builder.setDescription(weapon + " (Unknown weapon)");
                            embeds.add(builder.build());
                            return;
                        }

                        if (weaponInfo.get().getSupplyCrateLocation() != null) {
                            builder.addField("Supply Crates",
                                    "<:jda:" + config.getSupplyCreateEmojiId() + "> " + weaponInfo.get().getSupplyCrateLocation(),
                                    false);
                        }

                        if (weaponInfo.get().getFactionClasses() != null) {
                            weaponInfo.get().getFactionClasses().forEach((faction, classes) -> {
                                StringBuilder classList = new StringBuilder();
                                classes.forEach(classInfo -> classList
                                        .append(getClassEmoji(classInfo.getKey()))

                                        .append(classInfo.getKey()).append(" ").append(toRomanNumeral(classInfo.getValue()))
                                        .append("\n"));

                                builder.addField(getFactionEmoji(faction) + " " + faction, classList.toString(), false);
                            });
                        }

                        embeds.add(builder.build());
                    });

                    message.replyEmbeds(embeds).queue();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            });
        }
    }

    private static String toRomanNumeral(int number) {
        if (number < 1 || number > 10) throw new IllegalArgumentException("Number must be between 1 and 10");
        String[] numerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return numerals[number - 1];
    }

    private static String getClassEmoji(String className) {
        return "<:jda:" + config.getClassEmojis().getOrDefault(className, config.getUnknownEmojiId()) + ">";
    }

    private static String getFactionEmoji(String faction) {
       return "<:jda:" + config.getFactionEmojis().getOrDefault(faction, config.getUnknownEmojiId()) + ">";
    }
}
