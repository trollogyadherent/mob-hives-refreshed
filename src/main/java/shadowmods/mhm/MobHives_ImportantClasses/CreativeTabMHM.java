package shadowmods.mhm.MobHives_ImportantClasses;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMHM extends CreativeTabs {
  public CreativeTabMHM(String lable) {
    super(lable);
  }
  
  public Item getTabIconItem() {
    return null;
  }
  
  public String getTranslatedTabLabel() {
    return getTabLabel();
  }
}
