package net.narutoxboruto.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.narutoxboruto.entities.throwables.AbstractThrowableWeapon;
import net.narutoxboruto.items.ModItems;
import org.joml.Quaternionf;

public class PoisonSenbonRenderer <T extends AbstractThrowableWeapon> extends ThrowableWeaponRenderer<T> {
    public PoisonSenbonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    protected ItemStack getRenderItem(T pEntity) {
        return ModItems.POISON_SENBON.get().getDefaultInstance();
    }

    @Override
    protected void setupRotations(T pEntity, float pPartialTicks, PoseStack pMatrixStack) {
        float yRot = Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F;
        float xRot = Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot());

        Quaternionf rotationY = new Quaternionf().rotateY((float) Math.toRadians(yRot));
        Quaternionf rotationZ = new Quaternionf().rotateZ((float) Math.toRadians(xRot));
        Quaternionf correction = new Quaternionf().rotateY((float) Math.toRadians(90.0F));

        pMatrixStack.mulPose(rotationY);
        pMatrixStack.mulPose(rotationZ);
        pMatrixStack.mulPose(correction);
    }
}
