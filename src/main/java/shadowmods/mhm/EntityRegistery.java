package shadowmods.mhm;

import cpw.mods.fml.common.registry.EntityRegistry;
import shadowmods.mhm.MobHives_Entities.*;

public class EntityRegistery {
  static int ModEntityID;
  
  public static void RegisterEntities() {
    System.out.println("Entities Registered");
    ModEntityID = EntityRegistry.findGlobalUniqueEntityId();
    EntityRegistry.registerModEntity(EntityHiveSkeleton.class, "EntityHiveSkeleton", ModEntityID++, MobHives.instance, 80, 1, false);
    EntityRegistry.registerModEntity(EntityHiveSpider.class, "EntityHiveSpider", ModEntityID++, MobHives.instance, 80, 1, false);
    EntityRegistry.registerModEntity(EntityHiveZombie.class, "EntityHiveZombie", ModEntityID++, MobHives.instance, 80, 1, false);
    EntityRegistry.registerModEntity(EntityHiveCreeper.class, "EntityHiveCreeper", ModEntityID++, MobHives.instance, 80, 1, false);
    EntityRegistry.registerModEntity(EntityHiveSkeletonRegular.class, "EntityHiveSkeletonRegular", ModEntityID++, MobHives.instance, 80, 1, false);
    EntityRegistry.registerModEntity(EntityHiveSpiderRegular.class, "EntityHiveSpiderRegular", ModEntityID++, MobHives.instance, 80, 1, false);
    EntityRegistry.registerModEntity(EntityHiveZombieRegular.class, "EntityHiveZombieRegular", ModEntityID++, MobHives.instance, 80, 1, false);
  }
}
