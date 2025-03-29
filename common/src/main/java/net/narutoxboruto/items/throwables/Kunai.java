package net.narutoxboruto.items.throwables;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.narutoxboruto.entities.ModEntities;
import net.narutoxboruto.items.ModItems;

public class Kunai extends AbstractThrowableWeapon {

    public Kunai(EntityType<? extends AbstractThrowableWeapon> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public Kunai(Level pLevel) {
        super(ModEntities.KUNAI.get(), pLevel);
    }

    public double getBaseDamage() {
        return 3;
    }

    @Override
    public ItemStack getItem() {
        return ModItems.KUNAI.get().getDefaultInstance();
    }
}
