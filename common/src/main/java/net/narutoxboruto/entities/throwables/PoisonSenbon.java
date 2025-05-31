package net.narutoxboruto.entities.throwables;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.narutoxboruto.entities.ModEntities;
import net.narutoxboruto.items.ModItems;

public class PoisonSenbon extends AbstractThrowableWeapon {
    public PoisonSenbon(EntityType<? extends AbstractThrowableWeapon> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public PoisonSenbon(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.POISON_SENBON.get(), pLevel, pShooter);
    }

    @Override
    public double getBaseDamage() {
        return 1.5;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity target) {
            if (!target.isInvulnerableTo(this.level().damageSources().mobProjectile((Entity) this, (LivingEntity) this.getOwner()))) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, 432), this);
            }
        }
        super.onHitEntity(pResult);
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            if (!this.inGround) {

            }
        }
    }

    @Override
    public ItemStack getItem() {
        return ModItems.POISON_SENBON.get().getDefaultInstance();
    }
}
