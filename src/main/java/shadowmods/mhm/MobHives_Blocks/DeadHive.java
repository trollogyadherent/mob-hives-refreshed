package shadowmods.mhm.MobHives_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class DeadHive extends Block {
  public IIcon[] icons = new IIcon[6];
  
  public DeadHive(Material material) {
    super(material);
    setBlockName("DeadHive");
    setBlockTextureName("mhm:dh");
  }
  
  public void registerBlockIcons(IIconRegister reg) {
    for (int i = 0; i < 6; i++)
      this.icons[i] = reg.registerIcon(this.textureName + "_" + i); 
  }
  
  public IIcon getIcon(int side, int meta) {
    return this.icons[side];
  }
}
