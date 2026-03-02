package me.playgamesgo.utils.serdes;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import lombok.NonNull;
import me.playgamesgo.modules.blockfront.BlockfrontConfig;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public final class BlockFrontWeaponSerializer implements ObjectSerializer<BlockfrontConfig.WeaponInfo> {
    @Override
    public boolean supports(@NonNull Class<?> type) {
        return BlockfrontConfig.WeaponInfo.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NotNull BlockfrontConfig.WeaponInfo object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics) {
        data.set("name", object.getName());
        if (object.getFactionClasses() != null) {
            List<Map<String, Object>> factionsList = new ArrayList<>();

            object.getFactionClasses().forEach((fraction, classes) -> {
                Map<String, Object> objectMap = new LinkedHashMap<>();
                objectMap.put("fraction", fraction);

                List<Map<String, String>> classesList = new ArrayList<>();
                classes.forEach(entry -> {
                    Map<String, String> classMap = new LinkedHashMap<>();
                    classMap.put("class", entry.getKey());
                    classMap.put("level", entry.getValue() + "");
                    classesList.add(classMap);
                });

                objectMap.put("classes", classesList);
                factionsList.add(objectMap);
            });

            data.set("factions", factionsList);
        }

        if (object.getSupplyCrateLocation() != null) {
            data.set("supplyCrateLocation", object.getSupplyCrateLocation());
        }
    }

    @Override
    public BlockfrontConfig.WeaponInfo deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics) {
        String name = data.get("name", String.class);
        String supplyCrateLocation = data.getOr("supplyCrateLocation", String.class, null);

        Map<String, List<Map.Entry<String, Integer>>> factionClasses = null;
        if (data.containsKey("factions")) {
            Object factions = data.getRaw("factions");

            if (factions instanceof List) {
                factionClasses = new LinkedHashMap<>();

                for (Object factionObj : (List<?>) factions) {
                    if (factionObj instanceof Map<?, ?> factionMap) {
                        String fraction = (String) factionMap.get("fraction");
                        List<Map.Entry<String, Integer>> classes = new ArrayList<>();

                        Object classesObj = factionMap.get("classes");
                        if (classesObj instanceof List) {
                            for (Object classObj : (List<?>) classesObj) {

                                if (classObj instanceof Map<?, ?> classMap) {
                                    String className = (String) classMap.get("class");
                                    int level = Integer.parseInt((String) classMap.get("level"));
                                    classes.add(Map.entry(className, level));
                                }
                            }
                        }

                        factionClasses.put(fraction, classes);
                    }
                }
            } else {
                throw new IllegalArgumentException("Expected 'factions' to be a list of maps.");
            }
        }

        return new BlockfrontConfig.WeaponInfo(name, factionClasses, supplyCrateLocation);
    }
}
