package net.narutoxboruto.fabric.client;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.narutoxboruto.client.renderer.entity.ThrowableWeaponRenderer;
import net.narutoxboruto.entities.ModEntities;

public final class FabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Entity's
        EntityRendererRegistry.register(ModEntities.KUNAI, ThrowableWeaponRenderer::new);
        EntityRendererRegistry.register(ModEntities.EXPLOSIVE_KUNAI, ThrowableWeaponRenderer::new);
    }
}
