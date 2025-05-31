package net.narutoxboruto.entities.throwables;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.narutoxboruto.entities.ModEntities;
import net.narutoxboruto.items.ModItems;

public class Senbon extends AbstractThrowableWeapon {
    public Senbon(EntityType<? extends AbstractThrowableWeapon> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public Senbon(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.SENBON.get(), pLevel, pShooter);
    }

    @Override
    public double getBaseDamage() {
        return 1.5;
    }

    @Override
    public ItemStack getItem() {
        return ModItems.SENBON.get().getDefaultInstance();
    }
}
