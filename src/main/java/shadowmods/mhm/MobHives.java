package shadowmods.mhm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.ForgeChunkManager;
import org.apache.logging.log4j.Logger;
import shadowmods.mhm.MobHives_ImportantClasses.*;
import shadowmods.mhm.MobHives_TileEntities.*;
import shadowmods.mhm.util.XSTR;

import java.io.File;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.7.10]", guiFactory = "shadowmods.mhm.gui.GuiFactory")
public class MobHives {

    private static Logger LOG;
    private static boolean DEBUG_MODE;
    public static XSTR rand = new XSTR();

    public static final CreativeTabMHM mhmTab = new CreativeTabMHM("Mob Hives Mod") {
        public Item getTabIconItem() {
            return Item.getItemFromBlock(mhm_Blocks.ht1);
        }
    };

    @Mod.Instance
    public static MobHives instance;

    public static File confFile;

    @SidedProxy(clientSide= Tags.GROUPNAME + ".ClientProxy", serverSide=Tags.GROUPNAME + ".CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) {
        LOG = event.getModLog();
        String debugVar = System.getenv("MCMODDING_DEBUG_MODE");
        DEBUG_MODE = debugVar != null;

        mhm_Blocks.registerBlocks();
        EntityRegistery.RegisterEntities();
        GameRegistry.registerTileEntity(HiveTier1TE.class, "ht1_tile_entity");
        GameRegistry.registerTileEntity(HiveTier2TE.class, "ht2_tile_entity");
        GameRegistry.registerTileEntity(HiveTier3TE.class, "ht3_tile_entity");
        GameRegistry.registerTileEntity(HiveTier4TE.class, "ht4_tile_entity");
        GameRegistry.registerTileEntity(HiveTier5TE.class, "ht5_tile_entity");
        MHMCrafting.initCrafting();
        ForgeChunkManager.setForcedChunkLoadingCallback(instance, new ChunkLoadCallBack());
        proxy.registerRenderers();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverAboutToStart(FMLServerAboutToStartEvent event) {
        proxy.serverAboutToStart(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
        proxy.serverStarted(event);
    }

    @Mod.EventHandler
    public void serverStopping(FMLServerStoppingEvent event) {
        proxy.serverStopping(event);
    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent event) {
        proxy.serverStopped(event);
    }

    public static void debug(String message) {
        if (DEBUG_MODE || Config.debugMode) {
            LOG.info("DEBUG: " + message);
        }
    }

    public static void info(String message) {
        LOG.info(message);
    }

    public static void warn(String message) {
        LOG.warn(message);
    }

    public static void error(String message) {
        LOG.error(message);
    }
}