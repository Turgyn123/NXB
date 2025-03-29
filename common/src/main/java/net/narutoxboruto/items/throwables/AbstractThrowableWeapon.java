package net.narutoxboruto.items.throwables;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class AbstractThrowableWeapon extends AbstractArrow {

    private int age;
    float rotation;

    public AbstractThrowableWeapon(EntityType<? extends AbstractThrowableWeapon> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ItemStack getItem() {
        return null;
    }

    protected ItemStack getPickupItem() {
        return getItem();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    public void tick() {
        super.tick();
        if (this.age != -32768) {
            ++this.age;
        }
    }

    public int getAge() {
        return age;
    }

    protected boolean fumaSpin(){
        return true;
    }
    public float getFumaSpin(float pPartialTicks){
        if (!inGround && fumaSpin()) {
            this.rotation = (this.getAge() + pPartialTicks)/3;
        }
        if (fumaSpin()) {
            this.inGround = false;
        }
        return this.rotation;
    }
    // to let the shurkin spin
    protected boolean shouldSpin() {
        return true;
    }

    public float getSpin(float pPartialTicks) {
        if (!inGround && shouldSpin()) {
            this.rotation = (this.getAge() + pPartialTicks)/3;
        }
        return this.rotation;
    }


 //  @Override
 //  protected void onHitEntity(EntityHitResult pResult) {
 //      if (getOwner() != null && getOwner() instanceof ServerPlayer serverPlayer) {
 //          serverPlayer.getCapability(StatCapabilityProvider.SHURIKENJUTSU).ifPresent((shurikenjutsu -> {
 //              shurikenjutsu.incrementValue(1, serverPlayer);
 //          }));
 //      }
 //      super.onHitEntity(pResult);

 //  }
}
