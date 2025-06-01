package net.narutoxboruto.neoforge.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.narutoxboruto.Main;
import net.narutoxboruto.client.renderer.entity.*;
import net.narutoxboruto.entities.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
@EventBusSubscriber(modid = Main.MOD_ID, bus   = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NeoForgeClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Register the renderer for the Kunai entity
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.KUNAI.get(), ThrowableWeaponRenderer::new);
            EntityRenderers.register(ModEntities.EXPLOSIVE_KUNAI.get(), ThrowableWeaponRenderer::new);
            EntityRenderers.register(ModEntities.POISON_SENBON.get(), PoisonSenbonRenderer::new);
            EntityRenderers.register(ModEntities.SENBON.get(), SenbonRenderer::new);
            EntityRenderers.register(ModEntities.SHURIKEN.get(), ShurikenRenderer::new);
            EntityRenderers.register(ModEntities.FUMA_SHURIKEN.get(), FumaShurikenRenderer::new);
        });
    }
}
