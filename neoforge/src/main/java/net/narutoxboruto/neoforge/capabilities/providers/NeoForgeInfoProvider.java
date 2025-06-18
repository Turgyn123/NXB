package net.narutoxboruto.neoforge.capabilities.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.narutoxboruto.capabilities.info.Chakra;
import net.narutoxboruto.capabilities.info.MaxChakra;

import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import static net.narutoxboruto.Main.MOD_ID;

public class NeoForgeInfoProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static final EntityCapability<Chakra, @Nullable Void> CHAKRA =
            EntityCapability.createVoid( ResourceLocation.fromNamespaceAndPath(MOD_ID, "chakra"), Chakra.class);

    public static final EntityCapability<MaxChakra, @Nullable Void> MAX_CHAKRA =
            EntityCapability.createVoid(ResourceLocation.fromNamespaceAndPath(MOD_ID, "max_chakra"), MaxChakra.class);

    private Chakra chakra = null;
    private MaxChakra max_chakra = null;

    private Chakra createChakra() {
        if (this.chakra == null) {
            this.chakra = new Chakra();
        }
        return this.chakra;
    }

    private MaxChakra createMaxChakra() {
        if (this.max_chakra == null) {
            this.max_chakra = new MaxChakra();
        }
        return this.max_chakra;
    }

    @Override
    public @Nullable Object getCapability(Object object, Object object2) {
        return null;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag nbt = new CompoundTag();
        createChakra().saveNBTData(nbt);
        createMaxChakra().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        createChakra().loadNBTData(nbt);
        createMaxChakra().loadNBTData(nbt);
    }
}