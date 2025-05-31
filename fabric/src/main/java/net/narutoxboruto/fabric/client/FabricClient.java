package net.narutoxboruto.fabric.client;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.narutoxboruto.client.renderer.entity.PoisonSenbonRenderer;
import net.narutoxboruto.client.renderer.entity.SenbonRenderer;
import net.narutoxboruto.client.renderer.entity.ShurikenRenderer;
import net.narutoxboruto.client.renderer.entity.ThrowableWeaponRenderer;
import net.narutoxboruto.entities.ModEntities;

public final class FabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Entity's
        EntityRendererRegistry.register(ModEntities.KUNAI, ThrowableWeaponRenderer::new);
        EntityRendererRegistry.register(ModEntities.EXPLOSIVE_KUNAI, ThrowableWeaponRenderer::new);
        EntityRendererRegistry.register(ModEntities.POISON_SENBON, PoisonSenbonRenderer::new);
        EntityRendererRegistry.register(ModEntities.SENBON, SenbonRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHURIKEN, ShurikenRenderer::new);
    }
}
