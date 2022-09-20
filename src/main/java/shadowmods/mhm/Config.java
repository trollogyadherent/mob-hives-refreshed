package shadowmods.mhm;

import cpw.mods.fml.client.config.GuiConfigEntries;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import shadowmods.mhm.util.Util;

import java.io.File;

public class Config {
    public static Configuration config = new Configuration(MobHives.confFile);
    static boolean loaded = false;
    
    private static class Defaults {
        public static final boolean debugMode = false;
        public static final int tier1Z = 4;
        public static final int tier1Sp = 3;
        public static final int tier1Sk = 2;
        public static final int tier1SpawnChance = 3;
        public static final int tier1SpawnMinHeight = 40;
        public static final int tier1SpawnMaxHeight = 255;
        public static final int tier2Z = 5;
        public static final int tier2Sp = 4;
        public static final int tier2Sk = 3;
        public static final int tier2SpawnChance = 2;
        public static final int tier2SpawnMinHeight = 40;
        public static final int tier2SpawnMaxHeight = 255;
        public static final int tier3Z = 6;
        public static final int tier3Sp = 5;
        public static final int tier3Sk = 4;
        public static final int tier3SpawnChance = 1;
        public static final int tier3SpawnMinHeight = 40;
        public static final int tier3SpawnMaxHeight = 255;
        public static final int tier4Z = 7;
        public static final int tier4Sp = 6;
        public static final int tier4Sk = 5;
        public static final int tier4SpawnChance = 1;
        public static final int tier4SpawnMinHeight = 40;
        public static final int tier4SpawnMaxHeight = 255;
        public static final int tier5Z = 8;
        public static final int tier5Sp = 7;
        public static final int tier5Sk = 6;
        public static final int tier5SpawnChance = 1;
        public static final int tier5SpawnMinHeight = 40;
        public static final int tier5SpawnMaxHeight = 255;

        public static final int creeperHiveSpawnChance = 2;
        public static final int creeperHiveSpawnMinHeight = 40;
        public static final int creeperHiveSpawnMaxHeight = 255;

        public static final int skeletonHiveSpawnChance = 2;
        public static final int skeletonHiveSpawnMinHeight = 40;
        public static final int skeletonHiveSpawnMaxHeight = 255;

        public static final int spiderHiveSpawnChance = 2;
        public static final int spiderHiveSpawnMinHeight = 40;
        public static final int spiderHiveSpawnMaxHeight = 255;

        public static final int zombieHiveSpawnChance = 2;
        public static final int zombieHiveSpawnMinHeight = 40;
        public static final int zombieHiveSpawnMaxHeight = 255;

        public static final int ssp = 6;
        public static final boolean underSpawn = false;
        public static final boolean aboveSpawn = false;
        public static final boolean nsd = false;

        public static final float explosiveArrowChance = 1;

        public static final int[] spawnDimensionList = new int[] {0};
        public static final boolean spawnDimensionListIsWhitelist = true;
    }

    public static class Categories {
        public static final String general = "general";
        public static final String spawnRates = "spawn_rates";
    }
    
    public static boolean debugMode;
    public static int tier1Z;
    public static int tier1Sp;
    public static int tier1Sk;
    public static int tier1SpawnChance;
    public static int tier1SpawnMinHeight;
    public static int tier1SpawnMaxHeight;
    public static int tier2Z;
    public static int tier2Sp;
    public static int tier2Sk;
    public static int tier2SpawnChance;
    public static int tier2SpawnMinHeight;
    public static int tier2SpawnMaxHeight;
    public static int tier3Z;
    public static int tier3Sp;
    public static int tier3Sk;
    public static int tier3SpawnChance;
    public static int tier3SpawnMinHeight;
    public static int tier3SpawnMaxHeight;
    public static int tier4Z;
    public static int tier4Sp;
    public static int tier4Sk;
    public static int tier4SpawnChance;
    public static int tier4SpawnMinHeight;
    public static int tier4SpawnMaxHeight;
    public static int tier5Z;
    public static int tier5Sp;
    public static int tier5Sk;
    public static int tier5SpawnChance;
    public static int tier5SpawnMinHeight;
    public static int tier5SpawnMaxHeight;

    public static int creeperHiveSpawnChance;
    public static int creeperHiveSpawnMinHeight;
    public static int creeperHiveSpawnMaxHeight;

    public static int skeletonHiveSpawnChance;
    public static int skeletonHiveSpawnMinHeight;
    public static int skeletonHiveSpawnMaxHeight;

    public static int spiderHiveSpawnChance;
    public static int spiderHiveSpawnMinHeight;
    public static int spiderHiveSpawnMaxHeight;

    public static int zombieHiveSpawnChance;
    public static int zombieHiveSpawnMinHeight;
    public static int zombieHiveSpawnMaxHeight;

    public static int ssp;
    public static boolean underSpawn;
    public static boolean aboveSpawn;
    public static boolean nsd;

    public static float explosiveArrowChance;

    public static int[] spawnDimensionList;
    public static boolean spawnDimensionListIsWhitelist;

    public static void syncronizeConfiguration(File configFile, boolean force, boolean load) {
        if (!loaded || force) {
            if (load) {
                config.load();
            }
            loaded = true;

            /* general */
            Property debugProp = config.get(Categories.general, "debug", Defaults.debugMode, "Enable/disable debug mode and logs");
            debugMode = debugProp.getBoolean();
            Property tier1ZProp = config.get(Categories.general, "Tier 1 Zombie Amount", Defaults.tier1Z, "How many Hive Zombies are spawned from a Tier 1 Hive");
            tier1Z = tier1ZProp.getInt();
            Property tier2ZProp = config.get(Categories.general, "Tier 2 Zombie Amount", Defaults.tier2Z, "How many Hive Zombies are spawned from a Tier 2 Hive");
            tier2Z = tier2ZProp.getInt();
            Property tier3ZProp = config.get(Categories.general, "Tier 3 Zombie Amount", Defaults.tier3Z, "How many Hive Zombies are spawned from a Tier 3 Hive");
            tier3Z = tier3ZProp.getInt();
            Property tier4ZProp = config.get(Categories.general, "Tier 4 Zombie Amount", Defaults.tier4Z, "How many Hive Zombies are spawned from a Tier 4 Hive");
            tier4Z = tier4ZProp.getInt();
            Property tier5ZProp = config.get(Categories.general, "Tier 5 Zombie Amount", Defaults.tier5Z, "How many Hive Zombies are spawned from a Tier 5 Hive");
            tier5Z = tier5ZProp.getInt();
            Property tier1SpProp = config.get(Categories.general, "Tier 1 Spider Amount", Defaults.tier1Sp, "How many Hive Spiders are spawned from a Tier 1 Hive");
            tier1Sp = tier1SpProp.getInt();
            Property tier2SpProp = config.get(Categories.general, "Tier 2 Spider Amount", Defaults.tier2Sp, "How many Hive Spiders are spawned from a Tier 2 Hive");
            tier2Sp = tier2SpProp.getInt();
            Property tier3SpProp = config.get(Categories.general, "Tier 3 Spider Amount", Defaults.tier3Sp, "How many Hive Spiders are spawned from a Tier 3 Hive");
            tier3Sp = tier3SpProp.getInt();
            Property tier4SpProp = config.get(Categories.general, "Tier 4 Spider Amount", Defaults.tier4Sp, "How many Hive Spiders are spawned from a Tier 4 Hive");
            tier4Sp = tier4SpProp.getInt();
            Property tier5SpProp = config.get(Categories.general, "Tier 5 Spider Amount", Defaults.tier5Sp, "How many Hive Spiders are spawned from a Tier 5 Hive");
            tier5Sp = tier5SpProp.getInt();
            Property tier1SkProp = config.get(Categories.general, "Tier 1 Skeleton Amount", Defaults.tier1Sk, "How many Hive Skeletons are spawned from a Tier 1 Hive");
            tier1Sk = tier1SkProp.getInt();
            Property tier2SkProp = config.get(Categories.general, "Tier 2 Skeleton Amount", Defaults.tier2Sk, "How many Hive Skeletons are spawned from a Tier 2 Hive");
            tier2Sk = tier2SkProp.getInt();
            Property tier3SkProp = config.get(Categories.general, "Tier 3 Skeleton Amount", Defaults.tier3Sk, "How many Hive Skeletons are spawned from a Tier 3 Hive");
            tier3Sk = tier3SkProp.getInt();
            Property tier4SkProp = config.get(Categories.general, "Tier 4 Skeleton Amount", Defaults.tier4Sk, "How many Hive Skeletons are spawned from a Tier 4 Hive");
            tier4Sk = tier4SkProp.getInt();
            Property tier5SkProp = config.get(Categories.general, "Tier 5 Skeleton Amount", Defaults.tier5Sk, "How many Hive Skeletons are spawned from a Tier 5 Hive");
            tier5Sk = tier5SkProp.getInt();
            Property sspProp = config.get(Categories.general, "Standard Spawn Amount", Defaults.ssp, "How many mobs spawn from standard hives");
            ssp = sspProp.getInt();
            Property underSpawnProp = config.get(Categories.general, "Under ground Spawn", Defaults.underSpawn, "Set to true to enable spawning of Hives to occur only below 64");
            underSpawn = underSpawnProp.getBoolean();
            Property aboveSpawnProp = config.get(Categories.general, "Above ground Spawn", Defaults.aboveSpawn, "Set to true to enable spawning of Hives to occur only above 64");
            aboveSpawn = aboveSpawnProp.getBoolean();
            Property nsdProp = config.get(Categories.general, "Natural Spawning Disabled", Defaults.nsd, "Set to true to disable Hives from naturally spawning");
            nsd = nsdProp.getBoolean();
            Property explosiveArrowChanceProp = config.get(Categories.general, "Arrow Explosion Chance", Defaults.explosiveArrowChance, "Chance for a Hive Skeleton Arrow to explode", 0, 1);
            if (!Util.isServer()) {
                explosiveArrowChanceProp.setConfigEntryClass(GuiConfigEntries.NumberSliderEntry.class);
            }
            explosiveArrowChance = (float) explosiveArrowChanceProp.getDouble();

            /* spawnRates */
            Property tier1SpawnChanceProp = config.get(Categories.spawnRates, "Tier 1 Spawn Chance", Defaults.tier1SpawnChance, "Spawn chance of Tier 1 Hives", 0, Integer.MAX_VALUE);
            tier1SpawnChance = tier1SpawnChanceProp.getInt();
            Property tier1SpawnMinHeightProp = config.get(Categories.spawnRates, "Tier 1 Min Height", Defaults.tier1SpawnMinHeight, "Tier 1 Hives min spawn height", 0, 256);
            tier1SpawnMinHeight = tier1SpawnMinHeightProp.getInt();
            Property tier1SpawnMaxHeightProp = config.get(Categories.spawnRates, "Tier 1 Max Height", Defaults.tier1SpawnMaxHeight, "Tier 1 Hives max spawn height", 0, 256);
            tier1SpawnMaxHeight = tier1SpawnMaxHeightProp.getInt();

            Property tier2SpawnChanceProp = config.get(Categories.spawnRates, "Tier 2 Spawn Chance", Defaults.tier2SpawnChance, "Spawn chance of Tier 2 Hives", 0, Integer.MAX_VALUE);
            tier1SpawnChance = tier2SpawnChanceProp.getInt();
            Property tier2SpawnMinHeightProp = config.get(Categories.spawnRates, "Tier 2 Min Height", Defaults.tier2SpawnMinHeight, "Tier 2 Hives min spawn height", 0, 256);
            tier2SpawnMinHeight = tier2SpawnMinHeightProp.getInt();
            Property tier2SpawnMaxHeightProp = config.get(Categories.spawnRates, "Tier 2 Max Height", Defaults.tier2SpawnMaxHeight, "Tier 2 Hives max spawn height", 0, 256);
            tier2SpawnMaxHeight = tier2SpawnMaxHeightProp.getInt();

            Property tier3SpawnChanceProp = config.get(Categories.spawnRates, "Tier 3 Spawn Chance", Defaults.tier3SpawnChance, "Spawn chance of Tier 3 Hives", 0, Integer.MAX_VALUE);
            tier3SpawnChance = tier3SpawnChanceProp.getInt();
            Property tier3SpawnMinHeightProp = config.get(Categories.spawnRates, "Tier 3 Min Height", Defaults.tier3SpawnMinHeight, "Tier 3 Hives min spawn height", 0, 256);
            tier3SpawnMinHeight = tier3SpawnMinHeightProp.getInt();
            Property tier3SpawnMaxHeightProp = config.get(Categories.spawnRates, "Tier 3 Max Height", Defaults.tier3SpawnMaxHeight, "Tier 3 Hives max spawn height", 0, 256);
            tier3SpawnMaxHeight = tier3SpawnMaxHeightProp.getInt();

            Property tier4SpawnChanceProp = config.get(Categories.spawnRates, "Tier 4 Spawn Chance", Defaults.tier4SpawnChance, "Spawn chance of Tier 4 Hives", 0, Integer.MAX_VALUE);
            tier4SpawnChance = tier4SpawnChanceProp.getInt();
            Property tier4SpawnMinHeightProp = config.get(Categories.spawnRates, "Tier 4 Min Height", Defaults.tier4SpawnMinHeight, "Tier 4 Hives min spawn height", 0, 256);
            tier4SpawnMinHeight = tier4SpawnMinHeightProp.getInt();
            Property tier4SpawnMaxHeightProp = config.get(Categories.spawnRates, "Tier 4 Max Height", Defaults.tier4SpawnMaxHeight, "Tier 4 Hives max spawn height", 0, 256);
            tier4SpawnMaxHeight = tier4SpawnMaxHeightProp.getInt();

            Property tier5SpawnChanceProp = config.get(Categories.spawnRates, "Tier 5 Spawn Chance", Defaults.tier5SpawnChance, "Spawn chance of Tier 5 Hives", 0, Integer.MAX_VALUE);
            tier5SpawnChance = tier5SpawnChanceProp.getInt();
            Property tier5SpawnMinHeightProp = config.get(Categories.spawnRates, "Tier 5 Min Height", Defaults.tier5SpawnMinHeight, "Tier 5 Hives min spawn height", 0, 256);
            tier5SpawnMinHeight = tier5SpawnMinHeightProp.getInt();
            Property tier5SpawnMaxHeightProp = config.get(Categories.spawnRates, "Tier 5 Max Height", Defaults.tier5SpawnMaxHeight, "Tier 5 Hives max spawn height", 0, 256);
            tier5SpawnMaxHeight = tier5SpawnMaxHeightProp.getInt();

            Property creeperSpawnChanceProp = config.get(Categories.spawnRates, "Creeper Hive Spawn Chance", Defaults.creeperHiveSpawnChance, "Spawn chance of Creeper Hives", 0, Integer.MAX_VALUE);
            creeperHiveSpawnChance = creeperSpawnChanceProp.getInt();
            Property creeperHiveSpawnMinHeightProp = config.get(Categories.spawnRates, "Creeper Hive Min Height", Defaults.creeperHiveSpawnMinHeight, "Creeper Hives min spawn height", 0, 256);
            creeperHiveSpawnMinHeight = creeperHiveSpawnMinHeightProp.getInt();
            Property creeperHiveSpawnMaxHeightProp = config.get(Categories.spawnRates, "Creeper Hive Max Height", Defaults.creeperHiveSpawnMaxHeight, "Creeper Hives max spawn height", 0, 256);
            creeperHiveSpawnMaxHeight = creeperHiveSpawnMaxHeightProp.getInt();

            Property skeletonHiveSpawnChanceProp = config.get(Categories.spawnRates, "Skeleton Hive Spawn Chance", Defaults.skeletonHiveSpawnChance, "Spawn chance of Skeleton Hives", 0, Integer.MAX_VALUE);
            skeletonHiveSpawnChance = skeletonHiveSpawnChanceProp.getInt();
            Property skeletonHiveSpawnMinHeightProp = config.get(Categories.spawnRates, "Skeleton Hive Min Height", Defaults.skeletonHiveSpawnMinHeight, "Skeleton Hives min spawn height", 0, 256);
            skeletonHiveSpawnMinHeight = skeletonHiveSpawnMinHeightProp.getInt();
            Property skeletonHiveSpawnMaxHeightProp = config.get(Categories.spawnRates, "Skeleton Hive Max Height", Defaults.skeletonHiveSpawnMaxHeight, "Skeleton Hives max spawn height", 0, 256);
            skeletonHiveSpawnMaxHeight = skeletonHiveSpawnMaxHeightProp.getInt();

            Property spiderHiveSpawnChanceProp = config.get(Categories.spawnRates, "Spider Hive Spawn Chance", Defaults.spiderHiveSpawnChance, "Spawn chance of Spider Hives", 0, Integer.MAX_VALUE);
            spiderHiveSpawnChance = spiderHiveSpawnChanceProp.getInt();
            Property spiderHiveSpawnMinHeightProp = config.get(Categories.spawnRates, "Spider Hive Min Height", Defaults.spiderHiveSpawnMinHeight, "Spider Hives min spawn height", 0, 256);
            spiderHiveSpawnMinHeight = spiderHiveSpawnMinHeightProp.getInt();
            Property spiderHiveSpawnMaxHeightProp = config.get(Categories.spawnRates, "Spider Hive Max Height", Defaults.spiderHiveSpawnMaxHeight, "Spider Hives max spawn height", 0, 256);
            spiderHiveSpawnMaxHeight = spiderHiveSpawnMaxHeightProp.getInt();

            Property zombieHiveSpawnChanceProp = config.get(Categories.spawnRates, "Zombie Hive Spawn Chance", Defaults.zombieHiveSpawnChance, "Spawn chance of Zombie Hives", 0, Integer.MAX_VALUE);
            zombieHiveSpawnChance = zombieHiveSpawnChanceProp.getInt();
            Property zombieHiveSpawnMinHeightProp = config.get(Categories.spawnRates, "Zombie Hive Min Height", Defaults.zombieHiveSpawnMinHeight, "Zombie Hives min spawn height", 0, 256);
            zombieHiveSpawnMinHeight = zombieHiveSpawnMinHeightProp.getInt();
            Property zombieHiveSpawnMaxHeightProp = config.get(Categories.spawnRates, "Zombie Hive Max Height", Defaults.zombieHiveSpawnMaxHeight, "Zombie Hives max spawn height", 0, 256);
            zombieHiveSpawnMaxHeight = zombieHiveSpawnMaxHeightProp.getInt();

            Property spawnDimensionListProp = config.get(Categories.spawnRates, "spawnDimensionList", Defaults.spawnDimensionList, "List of dimensions");
            spawnDimensionList = spawnDimensionListProp.getIntList();
            Property spawnDimensionListIsWhitelistProp = config.get(Categories.spawnRates, "spawnDimensionListIsWhitelist", Defaults.spawnDimensionListIsWhitelist, "If true, the list of dimensions acts as a whitelist, otherwise as a blacklist");
            spawnDimensionListIsWhitelist = spawnDimensionListIsWhitelistProp.getBoolean();
        }
        if(config.hasChanged()) {
            config.save();
        }
    }
}