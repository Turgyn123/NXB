package net.narutoxboruto.items.swords;

import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum SwordCustomTiers implements Tier {
    GENERAL(0, 1561, -4.0F, -1.0F, 0, () -> Ingredient.EMPTY),//
    //	FUMA_SHURIKEN(),//
    SAMEHADA(0, 1561, -7.5F, 15.0F, 0, () -> Ingredient.EMPTY);
    //	SHIBUKI(),//
    //	KIBA(),//
    //	KUBIKIRIBOCHO(),//
    //	NUIBARI(),//
    //	HIRAMEKAREI(),//
    //	KABUTOWARI()//
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    SwordCustomTiers(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.level = pLevel;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return null;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }
}
