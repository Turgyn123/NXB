package net.narutoxboruto.neoforge;


import net.minecraft.tags.TagNetworkSerialization;
import net.narutoxboruto.networking.ModPacketHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.narutoxboruto.Main;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@Mod(Main.MOD_ID)
public final class NeoForgeMain {
    public NeoForgeMain() {
        // Call your common registration here, once
        Main.init();
    }

    @SubscribeEvent
    public static void onRegisterPayloadHandlers(RegisterPayloadHandlersEvent event) {
        ModPacketHandler.registerPayloadTypes();
    }
}