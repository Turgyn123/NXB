package net.narutoxboruto.fabric.client;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.narutoxboruto.client.renderer.entity.*;
import net.narutoxboruto.entities.ModEntities;
import net.narutoxboruto.networking.ModPacketHandler;

public final class FabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // This guarantees registration after client is fully ready:
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            ModPacketHandler.registerClientReceivers();
        });
        // Entity's
        EntityRendererRegistry.register(ModEntities.KUNAI, ThrowableWeaponRenderer::new);
        EntityRendererRegistry.register(ModEntities.EXPLOSIVE_KUNAI, ThrowableWeaponRenderer::new);
        EntityRendererRegistry.register(ModEntities.POISON_SENBON, PoisonSenbonRenderer::new);
        EntityRendererRegistry.register(ModEntities.SENBON, SenbonRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHURIKEN, ShurikenRenderer::new);
        EntityRendererRegistry.register(ModEntities.FUMA_SHURIKEN, FumaShurikenRenderer::new);
    }
}
