package me.playgamesgo.modules.blockfront;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Getter
@Setter
public final class BlockfrontConfig extends OkaeriConfig {
    private String atlasPath = "/home/play/IdeaProjects/PlayUtilsBot/data/ascii.png";
    private String tesseractPath = "/home/play/IdeaProjects/PlayUtilsBot/data";
    private String tesseractLanguage = "mc";
    private String channelId = "1478044181380337686";
    private String unknownEmojiId = "1478072236186275983";
    private String supplyCreateEmojiId = "1478045026951888977";

    @Comment
    private Map<String, String> factionEmojis = Map.of(
            "Britain", "1478045395140477121",
            "France", "1478045393563422841",
            "Germany", "1478045396130463917",
            "Italy", "1478045398021967952",
            "Japan", "1478045400236822549",
            "Poland", "1478045403050938489",
            "United States", "1478045405144027188",
            "USSR", "1478045406729474290"
    );

    private Map<String, String> classEmojis = Map.of(
            "Anti-Tank", "1478045701836374177",
            "Assault", "1478045703031886045",
            "Commander", "1478045704420196353",
            "Gunner", "1478045706689314836",
            "Lt Rifle", "1478045709243646173",
            "Medic", "1478045711248396474",
            "Rifleman", "1478045712313745570",
            "Sniper", "1478045713769173237",
            "Support", "1478045716529287298"
    );

    @Comment
    private List<WeaponInfo> weapons = new ArrayList<>() {{
        // region Assault Rifles & SMGs

        add(new WeaponInfo("Blyskawica",
                Map.of("Poland", List.of(
                        Map.entry("Assault", 1),
                        Map.entry("Commander", 1)
                ))
        ));

        add(new WeaponInfo("Greasegun",
                Map.of("United States", List.of(
                        Map.entry("Commander", 1),
                        Map.entry("Assault", 3)
                ))
        ));

        add(new WeaponInfo("KIS",
                Map.of("Poland", List.of(
                        Map.entry("Assault", 3),
                        Map.entry("Commander", 5)
                ))
        ));

        add(new WeaponInfo("KOP-PAL",
                Map.of("Poland", List.of(
                        Map.entry("Assault", 5),
                        Map.entry("Support", 3),
                        Map.entry("Anti-Tank", 1),
                        Map.entry("Commander", 2)
                ))
        ));

        add(new WeaponInfo("M1928A1 Thompson",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Assault", 5),
                                Map.entry("Commander", 2)
                        ),
                        "France", List.of(
                                Map.entry("Gunner", 2),
                                Map.entry("Commander", 2)
                        ),
                        "Italy", List.of(
                                Map.entry("Gunner", 2),
                                Map.entry("Commander", 2)
                        ),
                        "Japan", List.of(
                                Map.entry("Gunner", 2)
                        ),
                        "United States", List.of(
                                Map.entry("Gunner", 2)
                        )
                )
        ));

        add(new WeaponInfo("M1A1 Thompson",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Commander", 2)
                        ),
                        "United States", List.of(
                                Map.entry("Assault", 1),
                                Map.entry("Support", 3),
                                Map.entry("Commander", 5)
                        ),
                        "USSR", List.of(
                                Map.entry("Commander", 5)
                        )
                )
        ));

        add(new WeaponInfo("MAB Mod. 38",
                Map.of("Italy", List.of(
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 3),
                        Map.entry("Assault", 5),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 5)
                ))
        ));

        add(new WeaponInfo("MAS-38",
                Map.of("France", List.of(
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 5),
                        Map.entry("Support", 3),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 5)
                ))
        ));

        add(new WeaponInfo("MP-3008",
                Map.of("Germany", List.of(
                        Map.entry("Assault", 3)
                ))
        ));

        add(new WeaponInfo("MP-40",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Assault", 1),
                                Map.entry("Gunner", 2),
                                Map.entry("Commander", 5)
                        ),
                        "Poland", List.of(
                                Map.entry("Gunner", 2)
                        ),
                        "USSR", List.of(
                                Map.entry("Support", 2)
                        )
                )
        ));

        add(new WeaponInfo("MP-41",
                Map.of("Germany", List.of(
                        Map.entry("Assault", 5),
                        Map.entry("Commander", 1)
                ))
        ));

        add(new WeaponInfo("PPS-43",
                Map.of("USSR", List.of(
                        Map.entry("Assault", 5),
                        Map.entry("Support", 3),
                        Map.entry("Commander", 1)
                ))
        ));

        add(new WeaponInfo("PPSH",
                Map.of("USSR", List.of(
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 3),
                        Map.entry("Gunner", 2),
                        Map.entry("Commander", 2)
                ))
        ));

        add(new WeaponInfo("Sten Mk II",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Assault", 1),
                                Map.entry("Assault", 3),
                                Map.entry("Support", 3),
                                Map.entry("Gunner", 4),
                                Map.entry("Commander", 1),
                                Map.entry("Commander", 5)
                        ),
                        "France", List.of(
                                Map.entry("Assault", 3)
                        )
                )
        ));

        add(new WeaponInfo("STG-44",
                Map.of("Germany", List.of(
                        Map.entry("Support", 1),
                        Map.entry("Commander", 2)
                ))
        ));

        add(new WeaponInfo("Type 100",
                Map.of("Japan", List.of(
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 3),
                        Map.entry("Assault", 5),
                        Map.entry("Support", 3),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 5)
                ))
        ));

        // endregion

        // region Machine Guns

        add(new WeaponInfo("BAR",
                Map.of(
                        "France", List.of(
                                Map.entry("Support", 1)
                        ),
                        "Poland", List.of(
                                Map.entry("Support", 2)
                        ),
                        "United States", List.of(
                                Map.entry("Support", 1),
                                Map.entry("Gunner", 4)
                        )
                )
        ));

        add(new WeaponInfo("Breda M1930",
                Map.of(
                        "Italy", List.of(
                                Map.entry("Support", 1),
                                Map.entry("Support", 2),
                                Map.entry("Support", 3),
                                Map.entry("Gunner", 4)
                        )
                )
        ));

        add(new WeaponInfo("Breda SAFAT",
                Map.of(
                        "Italy", List.of(
                                Map.entry("Gunner", 3)
                        )
                ),
                "Italy Maps"
        ));

        add(new WeaponInfo("Bren Mk II",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Support", 1),
                                Map.entry("Support", 2),
                                Map.entry("Gunner", 2)
                        ),
                        "France", List.of(
                                Map.entry("Support", 2),
                                Map.entry("Gunner", 4)
                        ),
                        "United States", List.of(
                                Map.entry("Support", 2)
                        )
                )
        ));

        add(new WeaponInfo("Browning .30cal",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Gunner", 3)
                        ),
                        "France", List.of(
                                Map.entry("Gunner", 3)
                        ),
                        "United States", List.of(
                                Map.entry("Gunner", 1),
                                Map.entry("Gunner", 3)
                        )
                )
        ));

        add(new WeaponInfo("DP-28",
                Map.of(
                        "USSR", List.of(
                                Map.entry("Gunner", 1)
                        )
                )
        ));

        add(new WeaponInfo("Fiat-Revelli 35",
                Map.of(
                        "Italy", List.of(
                                Map.entry("Gunner", 1)
                        )
                )
        ));

        add(new WeaponInfo("Lewis Gun",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Gunner", 5)
                        ),
                        "France", List.of(
                                Map.entry("Gunner", 5)
                        ),
                        "Italy", List.of(
                                Map.entry("Gunner", 5)
                        ),
                        "Japan", List.of(
                                Map.entry("Gunner", 5)
                        ),
                        "Poland", List.of(
                                Map.entry("Gunner", 5)
                        ),
                        "United States", List.of(
                                Map.entry("Gunner", 5)
                        ),
                        "USSR", List.of(
                                Map.entry("Gunner", 5)
                        )
                ),
                "Most Maps"
        ));

        add(new WeaponInfo("MAC mle 1931",
                Map.of(
                        "France", List.of(
                                Map.entry("Gunner", 1)
                        )
                )
        ));

        add(new WeaponInfo("MG-34",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Gunner", 3),
                                Map.entry("Gunner", 5)
                        ),
                        "Poland", List.of(
                                Map.entry("Gunner", 1)
                        ),
                        "USSR", List.of(
                                Map.entry("Gunner", 3)
                        )
                ),
                "Most Maps"
        ));

        add(new WeaponInfo("MG-42",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Gunner", 1)
                        ),
                        "Poland", List.of(
                                Map.entry("Gunner", 3)
                        )
                )
        ));

        add(new WeaponInfo("Type 11",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Support", 1),
                                Map.entry("Gunner", 4)
                        )
                )
        ));

        add(new WeaponInfo("Type 96",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Support", 2),
                                Map.entry("Sniper", 3)
                        )
                ),
                "Japan Maps (Kwai, Castle)"
        ));

        add(new WeaponInfo("Type 98",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Gunner", 1),
                                Map.entry("Gunner", 3)
                        )
                )
        ));

        add(new WeaponInfo("Vickers K",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Gunner", 1)
                        )
                )
        ));

        add(new WeaponInfo("ZB vz.26",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Support", 2),
                                Map.entry("Gunner", 4)
                        ),
                        "Poland", List.of(
                                Map.entry("Support", 1),
                                Map.entry("Gunner", 4)
                        )
                )
        ));

        // endregion

        // region Rifles

        add(new WeaponInfo("Arisaka Type 38",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 3),
                                Map.entry("Rifleman", 5),
                                Map.entry("Medic", 1),
                                Map.entry("Medic", 2),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 4),
                                Map.entry("Sniper", 5),
                                Map.entry("Commander", 3)
                        )
                )
        ));

        add(new WeaponInfo("Arisaka Type 99",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Rifleman", 2),
                                Map.entry("Rifleman", 4),
                                Map.entry("Medic", 2)
                        )
                )
        ));

        add(new WeaponInfo("AVT-40",
                Map.of(
                        "Poland", List.of(
                                Map.entry("Sniper", 3)
                        ),
                        "USSR", List.of(
                                Map.entry("Support", 1),
                                Map.entry("Sniper", 3),
                                Map.entry("Gunner", 4)
                        )
                )
        ));

        add(new WeaponInfo("Boys Anti-Tank Rifle",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Anti-Tank", 2),
                                Map.entry("Anti-Tank", 4),
                                Map.entry("Anti-Tank", 6)
                        ),
                        "France", List.of(
                                Map.entry("Anti-Tank", 2),
                                Map.entry("Anti-Tank", 4),
                                Map.entry("Anti-Tank", 6)
                        ),
                        "Italy", List.of(
                                Map.entry("Anti-Tank", 2),
                                Map.entry("Anti-Tank", 4),
                                Map.entry("Anti-Tank", 6)
                        ),
                        "Poland", List.of(
                                Map.entry("Anti-Tank", 6)
                        ),
                        "United States", List.of(
                                Map.entry("Anti-Tank", 2),
                                Map.entry("Anti-Tank", 4),
                                Map.entry("Anti-Tank", 6)
                        )
                )
        ));

        add(new WeaponInfo("Breda M1935 PG",
                Map.of(
                        "Italy", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 5),
                                Map.entry("Anti-Tank", 1),
                                Map.entry("Anti-Tank", 2)
                        )
                )
        ));

        add(new WeaponInfo("Carcano M38",
                Map.of(
                        "Italy", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 5),
                                Map.entry("Medic", 1),
                                Map.entry("Medic", 2),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 4),
                                Map.entry("Sniper", 5)
                        )
                )
        ));

        add(new WeaponInfo("Carcano M91 TS Carbine",
                Map.of(
                        "Italy", List.of(
                                Map.entry("Rifleman", 2),
                                Map.entry("Rifleman", 4),
                                Map.entry("Anti-Tank", 3),
                                Map.entry("Commander", 3)
                        )
                )
        ));

        add(new WeaponInfo("De Lisle Carbine",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Rifleman", 5),
                                Map.entry("Sniper", 4),
                                Map.entry("Commander", 3)
                        )
                )
        ));

        add(new WeaponInfo("FG-42",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Support", 3),
                                Map.entry("Sniper", 3)
                        ),
                        "Italy", List.of(
                                Map.entry("Sniper", 3)
                        )
                )
        ));

        add(new WeaponInfo("Fusil Auto M1917",
                Map.of(
                        "France", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 3),
                                Map.entry("Lt Rifle", 4),
                                Map.entry("Anti-Tank", 1)
                        )
                )
        ));

        add(new WeaponInfo("Gewehr 43",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 3),
                                Map.entry("Lt Rifle", 4),
                                Map.entry("Lt Rifle", 5),
                                Map.entry("Sniper", 2)
                        ),
                        "Italy", List.of(
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 3),
                                Map.entry("Sniper", 3)
                        ),
                        "Poland", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 5)
                        )
                )
        ));

        add(new WeaponInfo("Howell Automatic Rifle",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 5),
                                Map.entry("Sniper", 2)
                        )
                )
        ));

        add(new WeaponInfo("Kar 98k",
                Map.of(
                        "France", List.of(
                                Map.entry("Rifleman", 3)
                        ),
                        "Germany", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 2),
                                Map.entry("Rifleman", 3),
                                Map.entry("Rifleman", 4),
                                Map.entry("Rifleman", 5),
                                Map.entry("Medic", 1),
                                Map.entry("Medic", 2),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 4),
                                Map.entry("Sniper", 5),
                                Map.entry("Commander", 3)
                        ),
                        "Italy", List.of(
                                Map.entry("Rifleman", 3)
                        ),
                        "Poland", List.of(
                                Map.entry("Rifleman", 2)
                        ),
                        "USSR", List.of(
                                Map.entry("Medic", 2)
                        )
                )
        ));

        add(new WeaponInfo("Kbk Wz. 29",
                Map.of(
                        "Poland", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 4),
                                Map.entry("Rifleman", 5),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 4),
                                Map.entry("Sniper", 5),
                                Map.entry("Commander", 3)
                        )
                )
        ));

        add(new WeaponInfo("Lebel 1886",
                Map.of(
                        "France", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 5),
                                Map.entry("Medic", 1),
                                Map.entry("Medic", 2),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 4),
                                Map.entry("Sniper", 5),
                                Map.entry("Commander", 3)
                        )
                )
        ));

        add(new WeaponInfo("Lee Enfield Mk I",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 2),
                                Map.entry("Rifleman", 4),
                                Map.entry("Medic", 1),
                                Map.entry("Medic", 2),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 5)
                        ),
                        "France", List.of(
                                Map.entry("Rifleman", 4)
                        )
                )
        ));

        add(new WeaponInfo("Lee Enfield Turner", "Some Maps"));

        add(new WeaponInfo("M1 Carbine",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Lt Rifleman", 3)
                        ),
                        "United States", List.of(
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 5),
                                Map.entry("Medic", 3),
                                Map.entry("Medic", 4),
                                Map.entry("Anti-Tank", 1),
                                Map.entry("Anti-Tank", 2)
                        )
                )
        ));

        add(new WeaponInfo("M1 Garand",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Lt Rifleman", 4)
                        ),
                        "France", List.of(
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 5),
                                Map.entry("Sniper", 2)
                        ),
                        "Italy", List.of(
                                Map.entry("Lt Rifleman", 4)
                        ),
                        "United States", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 3),
                                Map.entry("Lt Rifle", 4),
                                Map.entry("Sniper", 2),
                                Map.entry("Anti-Tank", 3)
                        )
                )
        ));

        add(new WeaponInfo("M2 Carbine",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Sniper", 3)
                        ),
                        "France", List.of(
                                Map.entry("Sniper", 3)
                        ),
                        "United States", List.of(
                                Map.entry("Assault", 5),
                                Map.entry("Sniper", 3),
                                Map.entry("Commander", 2)
                        )
                )
        ));

        add(new WeaponInfo("Mosin Nagant",
                Map.of(
                        "Poland", List.of(
                                Map.entry("Rifleman", 3),
                                Map.entry("Medic", 2)
                        ),
                        "USSR", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 2),
                                Map.entry("Rifleman", 5),
                                Map.entry("Medic", 1),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 4),
                                Map.entry("Sniper", 5)
                        )
                )
        ));

        add(new WeaponInfo("Panzerbuchse 39",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Anti-Tank", 2),
                                Map.entry("Anti-Tank", 6)
                        )
                ),
                "Most Maps"
        ));

        add(new WeaponInfo("PTRS-41",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Anti-Tank", 2),
                                Map.entry("Anti-Tank", 4),
                                Map.entry("Anti-Tank", 6)
                        ),
                        "Poland", List.of(
                                Map.entry("Anti-Tank", 4)
                        ),
                        "USSR", List.of(
                                Map.entry("Anti-Tank", 2),
                                Map.entry("Anti-Tank", 4),
                                Map.entry("Anti-Tank", 6)
                        )
                )
        ));

        add(new WeaponInfo("Springfield",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Rifleman", 3)
                        ),
                        "France", List.of(
                                Map.entry("Rifleman", 2)
                        ),
                        "United States", List.of(
                                Map.entry("Rifleman", 1),
                                Map.entry("Rifleman", 3),
                                Map.entry("Rifleman", 4),
                                Map.entry("Medic", 1),
                                Map.entry("Sniper", 1),
                                Map.entry("Sniper", 4),
                                Map.entry("Sniper", 5),
                                Map.entry("Commander", 3)
                        )
                )
        ));

        add(new WeaponInfo("Tokarev SVT-40",
                Map.of(
                        "Poland", List.of(
                                Map.entry("Lt Rifle", 3),
                                Map.entry("Lt Rifle", 4),
                                Map.entry("Sniper", 2)
                        ),
                        "USSR", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 3),
                                Map.entry("Lt Rifle", 4),
                                Map.entry("Lt Rifle", 5),
                                Map.entry("Sniper", 2)
                        )
                )
        ));

        add(new WeaponInfo("Type 4",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Lt Rifle", 1),
                                Map.entry("Lt Rifle", 2),
                                Map.entry("Lt Rifle", 3),
                                Map.entry("Lt Rifle", 4),
                                Map.entry("Lt Rifle", 5),
                                Map.entry("Sniper", 2),
                                Map.entry("Anti-Tank", 1)
                        )
                )
        ));

        add(new WeaponInfo("Winchester 1895",
                Map.of(
                        "United States", List.of(
                                Map.entry("Rifleman", 2),
                                Map.entry("Rifleman", 5),
                                Map.entry("Medic", 2)
                        ),
                        "USSR", List.of(
                                Map.entry("Rifleman", 3),
                                Map.entry("Rifleman", 4),
                                Map.entry("Commander", 3)
                        )
                )
        ));

        add(new WeaponInfo("Wz. 35",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Anti-Tank", 4)
                        ),
                        "Poland", List.of(
                                Map.entry("Anti-Tank", 2)
                        )
                )
        ));

        // endregion

        // region Rocket Launchers

        add(new WeaponInfo("Bazooka",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Anti-Tank", 3)
                        ),
                        "France", List.of(
                                Map.entry("Anti-Tank", 1)
                        ),
                        "United States", List.of(
                                Map.entry("Anti-Tank", 1),
                                Map.entry("Anti-Tank", 3),
                                Map.entry("Anti-Tank", 5)
                        ),
                        "USSR", List.of(
                                Map.entry("Anti-Tank", 3)
                        )
                )
        ));

        add(new WeaponInfo("Panzerfaust",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Anti-Tank", 3),
                                Map.entry("Anti-Tank", 5)
                        ),
                        "Italy", List.of(
                                Map.entry("Anti-Tank", 1)
                        ),
                        "Japan", List.of(
                                Map.entry("Anti-Tank", 5)
                        ),
                        "Poland", List.of(
                                Map.entry("Anti-Tank", 1),
                                Map.entry("Anti-Tank", 5)
                        ),
                        "USSR", List.of(
                                Map.entry("Anti-Tank", 1)
                        )
                )
        ));

        add(new WeaponInfo("Panzerschreck",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Anti-Tank", 1)
                        ),
                        "Italy", List.of(
                                Map.entry("Anti-Tank", 3),
                                Map.entry("Anti-Tank", 5)
                        )
                )
        ));

        add(new WeaponInfo("PIAT",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Anti-Tank", 1),
                                Map.entry("Anti-Tank", 5)
                        ),
                        "France", List.of(
                                Map.entry("Anti-Tank", 3),
                                Map.entry("Anti-Tank", 5)
                        ),
                        "Poland", List.of(
                                Map.entry("Anti-Tank", 3)
                        ),
                        "USSR", List.of(
                                Map.entry("Anti-Tank", 5)
                        )
                )
        ));

        add(new WeaponInfo("Type 4 (RL)",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Anti-Tank", 1),
                                Map.entry("Anti-Tank", 3)
                        )
                )
        ));

        // endregion

        // region Shotguns

        add(new WeaponInfo("Becker Revolving Shotgun",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Assault", 4),
                                Map.entry("Medic", 4)
                        ),
                        "Italy", List.of(
                                Map.entry("Assault", 4),
                                Map.entry("Medic", 4)
                        ),
                        "Japan", List.of(
                                Map.entry("Medic", 4)
                        )
                ),
                "Most Maps"
        ));

        add(new WeaponInfo("Browning Auto-5",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Assault", 4),
                                Map.entry("Medic", 4)
                        ),
                        "France", List.of(
                                Map.entry("Assault", 4),
                                Map.entry("Medic", 4),
                                Map.entry("Commander", 4)
                        ),
                        "Japan", List.of(
                                Map.entry("Assault", 4)
                        ),
                        "Poland", List.of(
                                Map.entry("Assault", 4),
                                Map.entry("Medic", 4),
                                Map.entry("Commander", 4)
                        ),
                        "United States", List.of(
                                Map.entry("Assault", 4),
                                Map.entry("Medic", 4),
                                Map.entry("Commander", 4)
                        ),
                        "USSR", List.of(
                                Map.entry("Assault", 4),
                                Map.entry("Medic", 4)
                        )
                )
        ));

        add(new WeaponInfo("M-30",
                Map.of(
                        "Germany", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3),
                                Map.entry("Commander", 4)
                        ),
                        "Italy", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3),
                                Map.entry("Commander", 4)
                        )
                ),
                "Most Maps"
        ));

        add(new WeaponInfo("Type 18",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3),
                                Map.entry("Commander", 4)
                        )
                )
        ));

        add(new WeaponInfo("Type 18 (Shotgun Converted)",
                Map.of(
                        "Japan", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3),
                                Map.entry("Commander", 4)
                        )
                )
        ));

        add(new WeaponInfo("Winchester 1912",
                Map.of(
                        "Britain", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3),
                                Map.entry("Commander", 4)
                        ),
                        "France", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3)
                        ),
                        "Poland", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3)
                        ),
                        "United States", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3)
                        ),
                        "USSR", List.of(
                                Map.entry("Assault", 2),
                                Map.entry("Support", 4),
                                Map.entry("Medic", 3),
                                Map.entry("Commander", 4)
                        )
                )
        ));

        // endregion

        // region Pistols & Revolvers

        add(new WeaponInfo("Beretta M1934", Map.of(
                "Italy", List.of(
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 3),
                        Map.entry("Medic", 1),
                        Map.entry("Medic", 3),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 2),
                        Map.entry("Gunner", 3)
                ),
                "United States", List.of(
                        Map.entry("Rifleman", 2),
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 2),
                        Map.entry("Support", 5),
                        Map.entry("Medic", 1),
                        Map.entry("Medic", 5),
                        Map.entry("Sniper", 2),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4)
                )
        )));

        add(new WeaponInfo("Browning Hi-Power GP35", Map.of(
                "Britain", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Rifleman", 2),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Assault", 1),
                        Map.entry("Support", 1),
                        Map.entry("Medic", 1),
                        Map.entry("Medic", 2),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 4),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 2),
                        Map.entry("Gunner", 3),
                        Map.entry("Gunner", 4),
                        Map.entry("Anti-Tank", 3),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 5)
                )
        )));

        add(new WeaponInfo("Colt M1911", Map.of(
                "Britain", List.of(
                        Map.entry("Rifleman", 3),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Support", 2),
                        Map.entry("Medic", 3),
                        Map.entry("Medic", 4),
                        Map.entry("Sniper", 3),
                        Map.entry("Commander", 2)
                ),
                "United States", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Rifleman", 3),
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 3),
                        Map.entry("Support", 1),
                        Map.entry("Support", 3),
                        Map.entry("Support", 4),
                        Map.entry("Medic", 2),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 3),
                        Map.entry("Sniper", 4),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 2),
                        Map.entry("Gunner", 3),
                        Map.entry("Gunner", 4),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 2),
                        Map.entry("Commander", 5)
                ),
                "USSR", List.of(
                        Map.entry("Rifleman", 3),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Assault", 3),
                        Map.entry("Support", 2),
                        Map.entry("Support", 3),
                        Map.entry("Medic", 3),
                        Map.entry("Sniper", 2),
                        Map.entry("Sniper", 3),
                        Map.entry("Commander", 2)
                )
        )));

        add(new WeaponInfo("FB Vis", Map.of(
                "Poland", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Assault", 1),
                        Map.entry("Support", 1),
                        Map.entry("Medic", 3),
                        Map.entry("Medic", 4),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 4),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 2),
                        Map.entry("Gunner", 3),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 2)
                )
        )));

        add(new WeaponInfo("FN 1910", Map.of(
                "Germany", List.of(
                        Map.entry("Rifleman", 3),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Support", 2),
                        Map.entry("Medic", 4)
                )
        )));

        add(new WeaponInfo("Glisenti Model 1910", Map.of(
                "Germany", List.of(
                        Map.entry("Commander", 5)
                ),
                "Italy", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Rifleman", 2),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 1),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 2),
                        Map.entry("Sniper", 3),
                        Map.entry("Sniper", 4),
                        Map.entry("Gunner", 4),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 2),
                        Map.entry("Commander", 5)
                )
        )));

        add(new WeaponInfo("Luger", Map.of(
                "France", List.of(
                        Map.entry("Rifleman", 3),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 3),
                        Map.entry("Medic", 3)
                ),
                "Germany", List.of(
                        Map.entry("Rifleman", 2),
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 3),
                        Map.entry("Support", 1),
                        Map.entry("Medic", 3),
                        Map.entry("Sniper", 3),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 3),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 1)
                ),
                "Japan", List.of(
                        Map.entry("Rifleman", 3),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Support", 3)
                )
        )));

        add(new WeaponInfo("Mauser C96", Map.of(
                "Germany", List.of(
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Support", 4),
                        Map.entry("Medic", 2),
                        Map.entry("Gunner", 4),
                        Map.entry("Anti-Tank", 2),
                        Map.entry("Anti-Tank", 3),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4)
                ),
                "Italy", List.of(
                        Map.entry("Rifleman", 3),
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Assault", 3),
                        Map.entry("Support", 2),
                        Map.entry("Support", 4),
                        Map.entry("Support", 5),
                        Map.entry("Medic", 4),
                        Map.entry("Medic", 5),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4)
                ),
                "Poland", List.of(
                        Map.entry("Rifleman", 2),
                        Map.entry("Assault", 3),
                        Map.entry("Support", 2),
                        Map.entry("Support", 5),
                        Map.entry("Medic", 1),
                        Map.entry("Medic", 5),
                        Map.entry("Anti-Tank", 2),
                        Map.entry("Anti-Tank", 3),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4)
                ),
                "USSR", List.of(
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 5),
                        Map.entry("Medic", 2),
                        Map.entry("Medic", 5),
                        Map.entry("Gunner", 4),
                        Map.entry("Anti-Tank", 2),
                        Map.entry("Anti-Tank", 3),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4)
                )
        )));

        add(new WeaponInfo("Mauser M712", Map.of(
                "Germany", List.of(
                        Map.entry("Support", 5),
                        Map.entry("Medic", 5),
                        Map.entry("Anti-Tank", 1)
                )
        )));

        add(new WeaponInfo("Modele 1892 Revolver", Map.of(
                "France", List.of(
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Support", 5),
                        Map.entry("Medic", 5),
                        Map.entry("Anti-Tank", 2),
                        Map.entry("Anti-Tank", 3),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4),
                        Map.entry("Commander", 5)
                )
        )));

        add(new WeaponInfo("Nambu Type 14", Map.of(
                "Japan", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 3),
                        Map.entry("Support", 4),
                        Map.entry("Medic", 1),
                        Map.entry("Medic", 2),
                        Map.entry("Medic", 3),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 2),
                        Map.entry("Sniper", 3),
                        Map.entry("Sniper", 4),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 2),
                        Map.entry("Gunner", 3),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 1)
                )
        )));

        add(new WeaponInfo("Nambu Type 94", Map.of(
                "Japan", List.of(
                        Map.entry("Rifleman", 2),
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 1),
                        Map.entry("Support", 2),
                        Map.entry("Medic", 4),
                        Map.entry("Gunner", 4),
                        Map.entry("Commander", 2),
                        Map.entry("Commander", 5)
                )
        )));

        add(new WeaponInfo("Pistolet Auto Modele 1935A", Map.of(
                "France", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Rifleman", 2),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 3),
                        Map.entry("Support", 1),
                        Map.entry("Support", 2),
                        Map.entry("Support", 4),
                        Map.entry("Medic", 1),
                        Map.entry("Medic", 2),
                        Map.entry("Medic", 4),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 2),
                        Map.entry("Sniper", 3),
                        Map.entry("Sniper", 4),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 2),
                        Map.entry("Gunner", 3),
                        Map.entry("Gunner", 4),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 2)
                )
        )));

        add(new WeaponInfo("Tokarev TT-33", Map.of(
                "Poland", List.of(
                        Map.entry("Rifleman", 3),
                        Map.entry("Lt Rifle", 3),
                        Map.entry("Support", 3),
                        Map.entry("Support", 4),
                        Map.entry("Medic", 2),
                        Map.entry("Sniper", 2),
                        Map.entry("Sniper", 3),
                        Map.entry("Gunner", 4),
                        Map.entry("Commander", 5)
                ),
                "USSR", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Rifleman", 2),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Assault", 1),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 1),
                        Map.entry("Support", 4),
                        Map.entry("Medic", 1),
                        Map.entry("Medic", 4),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 4),
                        Map.entry("Gunner", 1),
                        Map.entry("Gunner", 2),
                        Map.entry("Gunner", 3),
                        Map.entry("Anti-Tank", 1),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 1),
                        Map.entry("Commander", 5)
                )
        )));

        add(new WeaponInfo("Type 26 Revolver", Map.of(
                "Japan", List.of(
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Support", 5),
                        Map.entry("Medic", 5),
                        Map.entry("Anti-Tank", 2),
                        Map.entry("Anti-Tank", 3),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4)
                )
        )));

        add(new WeaponInfo("Walther P38", Map.of(
                "Germany", List.of(
                        Map.entry("Rifleman", 1),
                        Map.entry("Lt Rifle", 1),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 3),
                        Map.entry("Medic", 1),
                        Map.entry("Sniper", 1),
                        Map.entry("Sniper", 2),
                        Map.entry("Sniper", 4),
                        Map.entry("Commander", 2)
                )
        )));

        add(new WeaponInfo("Webley Mk VI", Map.of(
                "Britain", List.of(
                        Map.entry("Rifleman", 4),
                        Map.entry("Lt Rifle", 2),
                        Map.entry("Lt Rifle", 4),
                        Map.entry("Assault", 2),
                        Map.entry("Support", 4),
                        Map.entry("Anti-Tank", 2),
                        Map.entry("Anti-Tank", 4),
                        Map.entry("Commander", 3),
                        Map.entry("Commander", 4)
                )
        )));

        add(new WeaponInfo("Welrod", Map.of(
                "Britain", List.of(
                        Map.entry("Assault", 3),
                        Map.entry("Support", 3),
                        Map.entry("Medic", 5),
                        Map.entry("Sniper", 2),
                        Map.entry("Anti-Tank", 1)
                )
        )));

        // endregion
    }};

    @Getter
    @Setter
    public static final class WeaponInfo {
        private final String name;
        private final Map<String, List<Map.Entry<String, Integer>>> factionClasses;
        private final String supplyCrateLocation;

        public WeaponInfo(String name, Map<String, List<Map.Entry<String, Integer>>> factionClasses) {
            this.name = name;
            this.factionClasses = factionClasses;
            this.supplyCrateLocation = null;
        }

        public WeaponInfo(String name, String supplyCrateLocation) {
            this.name = name;
            this.factionClasses = null;
            this.supplyCrateLocation = supplyCrateLocation;
        }

        public WeaponInfo(String name, Map<String, List<Map.Entry<String, Integer>>> factionClasses, String supplyCrateLocation) {
            this.name = name;
            this.factionClasses = factionClasses;
            this.supplyCrateLocation = supplyCrateLocation;
        }
    }
}
