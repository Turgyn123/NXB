package net.narutoxboruto.entities.throwables;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.narutoxboruto.entities.ModEntities;
import net.narutoxboruto.items.ModItems;

public class Shuriken extends AbstractThrowableWeapon {

    public Shuriken(EntityType<? extends AbstractThrowableWeapon> type, Level world) {
        super(type, world);
    }

    public Shuriken(Level world, LivingEntity shooter) {
        super(ModEntities.SHURIKEN.get(), world, shooter);
    }

    protected ItemStack getDefaultItem() {return new ItemStack(ModItems.SHURIKEN.get());}

    @Override
    public double getBaseDamage() {
        return 3;
    }

    @Override
    public ItemStack getItem() {
        return ModItems.SHURIKEN.get().getDefaultInstance();
    }

    @Override
    protected boolean shouldSpin() {
        return true;
    }
}
