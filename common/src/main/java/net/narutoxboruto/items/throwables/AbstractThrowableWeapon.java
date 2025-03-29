package net.narutoxboruto.items.throwables;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AbstractThrowableWeapon extends ThrowableProjectile {

    private int age;
    float rotation;

    public AbstractThrowableWeapon(EntityType<? extends AbstractThrowableWeapon> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public AbstractThrowableWeapon(EntityType<? extends AbstractThrowableWeapon> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType, pShooter, pLevel);
    }

    public AbstractThrowableWeapon(EntityType<? extends AbstractThrowableWeapon> pEntityType, Level pLevel, double pX, double pY, double pZ) {
        super(pEntityType, pX, pY, pZ, pLevel);
    }

    public ItemStack getItem() {
        return null;
    }

    protected ItemStack getPickupItem() {
        return getItem();
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
}
