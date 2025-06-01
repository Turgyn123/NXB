package net.narutoxboruto.entities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.narutoxboruto.Main;
import net.narutoxboruto.entities.throwables.*;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> MOD_ENTITIES = DeferredRegister.create(Main.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<Kunai>> KUNAI = registerEntity("kunai", Kunai::new, MobCategory.MISC,
            0.5F, 0.5F);

    public static final RegistrySupplier<EntityType<ExplosiveKunai>> EXPLOSIVE_KUNAI = registerEntity("explosive_kunai", ExplosiveKunai::new, MobCategory.MISC,
            0.5F, 0.5F);

    public static final RegistrySupplier<EntityType<PoisonSenbon>> POISON_SENBON = registerEntity("poison_senbon", PoisonSenbon::new, MobCategory.MISC,
            0.5F, 0.5F);

    public static final RegistrySupplier<EntityType<Senbon>> SENBON = registerEntity("senbon", Senbon::new, MobCategory.MISC,
            0.5F, 0.5F);

    public static final RegistrySupplier<EntityType<Shuriken>> SHURIKEN = registerEntity("shuriken", Shuriken::new, MobCategory.MISC,
            0.5F, 0.5F);

    public static final RegistrySupplier<EntityType<ThrownFumaShuriken>> FUMA_SHURIKEN = registerEntity("fuma_shuriken", ThrownFumaShuriken::new, MobCategory.MISC,
            0.5F, 0.5F);



    public static <T extends Entity> RegistrySupplier<EntityType<T>> registerEntity(String name, EntityType.EntityFactory<T> pFactory, MobCategory pCategory, float width, float height) {
        return MOD_ENTITIES.register(name, () -> EntityType.Builder.of(pFactory, pCategory).sized(width, height)
                .build(name));
    }

    public static void register() {
        MOD_ENTITIES.register();
    }
}
