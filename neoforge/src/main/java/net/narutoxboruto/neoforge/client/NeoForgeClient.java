package net.narutoxboruto.neoforge.client;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.narutoxboruto.client.renderer.entity.ThrowableWeaponRenderer;
import net.narutoxboruto.entities.ModEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class NeoForgeClient {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        EntityRendererRegistry.register(ModEntities.KUNAI, ThrowableWeaponRenderer::new);
    }
}
