package net.narutoxboruto.entities.throwables;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.narutoxboruto.entities.ModEntities;
import net.narutoxboruto.items.ModItems;

public class Kunai extends AbstractThrowableWeapon {
    public Kunai(EntityType<? extends AbstractThrowableWeapon> type, Level world) {
        super(type, world);
    }

    public Kunai(Level world, LivingEntity shooter) {
        super(ModEntities.KUNAI.get(), world, shooter);
    }

    protected ItemStack getDefaultPickupItem() {
        return getPickupItem();
    }

    @Override
    public double getBaseDamage() {
        return 3;
    }

    @Override
    public ItemStack getItem() {
        return ModItems.KUNAI.get().getDefaultInstance();
    }
}
