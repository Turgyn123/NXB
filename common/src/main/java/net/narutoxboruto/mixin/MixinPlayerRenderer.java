package net.narutoxboruto.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public abstract class MixinPlayerRenderer {

    /**
     * method Doesn't work for some reason and PlayerData.isNarutoRunning still need to be made
     */
  //  @Inject(method = "setupRotations(Lnet/minecraft/client/player/AbstractClientPlayer;Lcom/mojang/blaze3d/vertex/PoseStack;FFF)V",
  //          at = @At("TAIL"))
  //  public void bla(AbstractClientPlayer pEntityLiving, PoseStack pMatrixStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks, CallbackInfo ci) {
  //      if (PlayerData.isNarutoRunning()) {
  //          pMatrixStack.translate(0, 0.2, 1);
  //          pMatrixStack.mulPose(Vector3f.XP.rotation(-0.7854F));
  //      }
  //  }
}
