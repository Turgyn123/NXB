package net.narutoxboruto.neoforge;

import net.minecraft.world.entity.EntityType;
import net.narutoxboruto.capabilities.info.Chakra;
import net.narutoxboruto.capabilities.info.MaxChakra;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

import net.narutoxboruto.Main;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

import static net.narutoxboruto.neoforge.capabilities.providers.NeoForgeInfoProvider.CHAKRA;
import static net.narutoxboruto.neoforge.capabilities.providers.NeoForgeInfoProvider.MAX_CHAKRA;

@Mod(Main.MOD_ID)
public final class NeoForgeMain {
    public NeoForgeMain(IEventBus modBus, ModContainer container) {
        // Run our common setup.
        Main.init();
        modBus.addListener(this::onRegisterCapabilities);
    }

    private void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(CHAKRA, EntityType.PLAYER, (player, ctx) -> new Chakra());
        event.registerEntity(MAX_CHAKRA, EntityType.PLAYER, (player, ctx) -> new MaxChakra());
    }
}
