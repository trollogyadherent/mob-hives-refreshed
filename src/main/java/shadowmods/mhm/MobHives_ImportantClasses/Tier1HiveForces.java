package shadowmods.mhm.MobHives_ImportantClasses;

import net.minecraft.world.World;
import shadowmods.mhm.Config;
import shadowmods.mhm.MobHives_Entities.EntityHiveSkeleton;
import shadowmods.mhm.MobHives_Entities.EntityHiveSpider;
import shadowmods.mhm.MobHives_Entities.EntityHiveZombie;

public class Tier1HiveForces {
  public static void spawnHiveForces(World world, int x, int y, int z) {
    System.out.println("Tier 1 Hive Forces Spawned at " + x + ", " + y + " , " + z);
    if (!world.isRemote) {
      if (Config.tier1Sk > 1) {
        for (int c = 0; c < Config.tier1Sk; c++)
          world.spawnEntityInWorld(new EntityHiveSkeleton(world, x, y, z));
      } else {
        world.spawnEntityInWorld(new EntityHiveSkeleton(world, x, y, z));
      } 
      for (int w = 0; w < Config.tier1Sp; w++)
        world.spawnEntityInWorld(new EntityHiveSpider(world, x, y, z));
      for (int a = 0; a < Config.tier1Z; a++)
        world.spawnEntityInWorld(new EntityHiveZombie(world, x, y, z));
    } 
  }
}
