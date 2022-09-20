package shadowmods.mhm.MobHives_ImportantClasses;

import cpw.mods.fml.common.IWorldGenerator;

import java.util.Arrays;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import shadowmods.mhm.Config;

public class ModWorldGen implements IWorldGenerator {
  private WorldGenerator Hive1 = new WorldGenSingleHive(mhm_Blocks.ht1);
  
  private WorldGenerator Hive2 = new WorldGenSingleHive(mhm_Blocks.ht2);
  
  private WorldGenerator Hive3 = new WorldGenSingleHive(mhm_Blocks.ht3);
  
  private WorldGenerator Hive4 = new WorldGenSingleHive(mhm_Blocks.ht4);
  
  private WorldGenerator Hive5 = new WorldGenSingleHive(mhm_Blocks.ht5);
  
  private WorldGenerator CHive = new WorldGenSingleHive(mhm_Blocks.ch);
  
  private WorldGenerator SHive = new WorldGenSingleHive(mhm_Blocks.sh);
  
  private WorldGenerator SpHive = new WorldGenSingleHive(mhm_Blocks.sph);
  
  private WorldGenerator ZHive = new WorldGenSingleHive(mhm_Blocks.zh);
  
  private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
      throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
    }
    int heightDiff = maxHeight - minHeight + 1;
    for (int i = 0; i < chancesToSpawn; i++) {
      int x = chunk_X * 16 + rand.nextInt(16);
      int y = minHeight + rand.nextInt(heightDiff);
      int z = chunk_Z * 16 + rand.nextInt(16);
      if (!Config.nsd) {
        if (Config.underSpawn && (world.getBlock(x, y - 1, z) == Blocks.stone || world.getBlock(x, y - 1, z) == Blocks.dirt)) {
          generator.generate(world, rand, x, y, z);
        } else if (world.getBlock(x, y - 1, z) == Blocks.grass || world.getBlock(x, y - 1, z) == Blocks.sand || world.getBlock(x, y - 1, z) == Blocks.dirt) {
          generator.generate(world, rand, x, y, z);
        }
      }
    } 
  }

  boolean canSpawnInDimension(int dimensionId) {
    boolean found = false;
    int i = 0;
    while (i < Config.spawnDimensionList.length) {
      if (Config.spawnDimensionList[i] == dimensionId) {
        found = true;
        break;
      }
      i ++;
    }
    if (found) {
      return Config.spawnDimensionListIsWhitelist;
    } else {
      return !Config.spawnDimensionListIsWhitelist;
    }
  }

  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    if (canSpawnInDimension(world.provider.dimensionId)) {
      runGenerator(this.CHive, world, random, chunkX, chunkZ, Config.creeperHiveSpawnChance, Config.creeperHiveSpawnMinHeight, Config.creeperHiveSpawnMaxHeight);
      runGenerator(this.SHive, world, random, chunkX, chunkZ, Config.skeletonHiveSpawnChance, Config.creeperHiveSpawnMinHeight, Config.creeperHiveSpawnMaxHeight);
      runGenerator(this.SpHive, world, random, chunkX, chunkZ, Config.spiderHiveSpawnChance, Config.creeperHiveSpawnMinHeight, Config.creeperHiveSpawnMaxHeight);
      runGenerator(this.ZHive, world, random, chunkX, chunkZ, Config.zombieHiveSpawnChance, Config.zombieHiveSpawnMinHeight, Config.zombieHiveSpawnMaxHeight);
      runGenerator(this.Hive1, world, random, chunkX, chunkZ, Config.tier1SpawnChance, Config.tier1SpawnMinHeight, Config.tier1SpawnMaxHeight);
      runGenerator(this.Hive2, world, random, chunkX, chunkZ, Config.tier2SpawnChance, Config.tier2SpawnMinHeight, Config.tier2SpawnMaxHeight);
      runGenerator(this.Hive3, world, random, chunkX, chunkZ, Config.tier3SpawnChance, Config.tier3SpawnMinHeight, Config.tier3SpawnMaxHeight);
      runGenerator(this.Hive4, world, random, chunkX, chunkZ, Config.tier4SpawnChance, Config.tier4SpawnMinHeight, Config.tier4SpawnMaxHeight);
      runGenerator(this.Hive5, world, random, chunkX, chunkZ, Config.tier5SpawnChance, Config.tier5SpawnMinHeight, Config.tier5SpawnMaxHeight);
    }
  }
}
