package shadowmods.mhm.MobHives_ImportantClasses;

import net.minecraft.world.World;
import shadowmods.mhm.Config;
import shadowmods.mhm.MobHives_Entities.EntityHiveSkeleton;
import shadowmods.mhm.MobHives_Entities.EntityHiveSpider;
import shadowmods.mhm.MobHives_Entities.EntityHiveZombie;

public class Tier4HiveForces {
  public static void spawnHiveForces(World world, int x, int y, int z) {
    System.out.println("Tier 4 Hive Forces Spawned at " + x + ", " + y + " , " + z);
    if (world.isRemote != true) {
      if (Config.tier4Sk > 1) {
        for (int c = 0; c < Config.tier4Sk; c++)
          world.spawnEntityInWorld(new EntityHiveSkeleton(world, x, y, z));
      } else {
        world.spawnEntityInWorld(new EntityHiveSkeleton(world, x, y, z));
      } 
      for (int w = 0; w < Config.tier4Sp; w++)
        world.spawnEntityInWorld(new EntityHiveSpider(world, x, y, z));
      for (int a = 0; a < Config.tier4Z; a++)
        world.spawnEntityInWorld(new EntityHiveZombie(world, x, y, z));
    } 
  }
}
