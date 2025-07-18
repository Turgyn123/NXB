package net.narutoxboruto.fabric;

import net.fabricmc.api.ModInitializer;

import net.narutoxboruto.Main;
import net.narutoxboruto.networking.ModPacketHandler;

public final class FabricMain implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Main.init();

        // Register the packet types for networking.
        ModPacketHandler.registerPayloadTypes();
    }
}
