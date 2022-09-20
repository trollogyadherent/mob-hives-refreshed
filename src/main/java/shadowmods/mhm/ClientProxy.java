package shadowmods.mhm;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.*;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import shadowmods.mhm.MobHives_Entities.*;
import shadowmods.mhm.MobHives_Models.ModelHiveSkeleton;
import shadowmods.mhm.MobHives_Rendering.*;

public class ClientProxy extends CommonProxy {

    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, new RenderExplosiveArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntityHiveSkeleton.class, new RenderHiveSkeleton(new ModelBiped(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHiveSpider.class, new RenderHiveSpider(new ModelBiped(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHiveZombie.class, new RenderHiveZombie(new ModelZombie(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHiveCreeper.class, new RenderHiveCreeper());
        RenderingRegistry.registerEntityRenderingHandler(EntityHiveSkeletonRegular.class, new RenderHiveSkeletonRegular(new ModelHiveSkeleton(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHiveSpiderRegular.class, new RenderHiveSpiderRegular(new ModelBiped(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHiveZombieRegular.class, new RenderHiveZombieRegular(new ModelZombie(), 1.0F));
    }

    public void registerEntities() {}

    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) 	{
        super.preInit(event);
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    public void serverAboutToStart(FMLServerAboutToStartEvent event) {
        super.serverAboutToStart(event);
    }

    // register server commands in this event handler
    public void serverStarting(FMLServerStartingEvent event) {
        super.serverStarting(event);
    }

    public void serverStarted(FMLServerStartedEvent event) {
        super.serverStarted(event);
    }

    public void serverStopping(FMLServerStoppingEvent event) {
        super.serverStopping(event);
    }

    public void serverStopped(FMLServerStoppedEvent event) {
        super.serverStopped(event);
    }
}