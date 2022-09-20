package shadowmods.mhm.gui;

import com.google.common.collect.ImmutableList;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import shadowmods.mhm.Config;
import shadowmods.mhm.MobHives;
import shadowmods.mhm.Tags;

public class ConfigGui extends GuiConfig {

    private static IConfigElement general = new ConfigElement(Config.config.getCategory(Config.Categories.general));
    private static IConfigElement spawnRates = new ConfigElement(Config.config.getCategory(Config.Categories.spawnRates));

    public ConfigGui(GuiScreen parent) {
        //this.parentScreen = parent;
        super(parent, ImmutableList.of(general, spawnRates), Tags.MODID, Tags.MODID, false, false, I18n.format("mhm.configgui.title"), MobHives.confFile.getAbsolutePath());
        MobHives.debug("Instantiating config gui");
    }

    @Override
    public void initGui()
    {
        // You can add buttons and initialize fields here
        super.initGui();
        MobHives.debug("Initializing config gui");
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // You can do things like create animations, draw additional elements, etc. here
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton b) {
        MobHives.debug("Config button id " + b.id + " pressed");
        super.actionPerformed(b);
        /* "Done" button */
        if (b.id == 2000) {
            /* Syncing config */
            Config.syncronizeConfiguration(MobHives.confFile, true, false);
        }
    }
}