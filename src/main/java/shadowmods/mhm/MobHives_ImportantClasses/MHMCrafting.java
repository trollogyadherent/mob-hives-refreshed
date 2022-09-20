package shadowmods.mhm.MobHives_ImportantClasses;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MHMCrafting {
  public static void initCrafting() {
    GameRegistry.addShapelessRecipe(new ItemStack(Items.paper, 6), new ItemStack(mhm_Blocks.dh));
  }
}
