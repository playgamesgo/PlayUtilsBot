package me.playgamesgo.utils.serdes;

import eu.okaeri.configs.serdes.OkaeriSerdes;
import eu.okaeri.configs.serdes.SerdesRegistry;
import lombok.NonNull;

public final class CustomSerdes implements OkaeriSerdes {
    @Override
    public void register(@NonNull SerdesRegistry registry) {
        registry.register(new BlockFrontWeaponSerializer());
    }
}
