package net.narutoxboruto.entities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.narutoxboruto.Main;
import net.narutoxboruto.entities.throwables.Kunai;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> MOD_ENTITIES = DeferredRegister.create(Main.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<Kunai>> KUNAI = registerEntity("kunai", Kunai::new, MobCategory.MISC,
            0.5F, 0.5F);

    public static final RegistrySupplier<EntityType<Kunai>> EXPLOSIVE_KUNAI = registerEntity("explosive_kunai", Kunai::new, MobCategory.MISC,
            0.5F, 0.5F);




    public static <T extends Entity> RegistrySupplier<EntityType<T>> registerEntity(String name, EntityType.EntityFactory<T> pFactory, MobCategory pCategory, float width, float height) {
        return MOD_ENTITIES.register(name, () -> EntityType.Builder.of(pFactory, pCategory).sized(width, height)
                .build(name));
    }

    public static void register() {
        MOD_ENTITIES.register();
    }
}
