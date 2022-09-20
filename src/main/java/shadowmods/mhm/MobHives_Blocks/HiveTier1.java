package shadowmods.mhm.MobHives_Blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import shadowmods.mhm.MobHives_ImportantClasses.mhm_Blocks;

public class HiveTier1 extends Block {
  public IIcon[] icons = new IIcon[6];
  
  public HiveTier1(Material material) {
    super(material);
    setBlockName("HiveTier1");
    setBlockTextureName("mhm:ht1");
  }
  
  public void registerBlockIcons(IIconRegister reg) {
    for (int i = 0; i < 6; i++)
      this.icons[i] = reg.registerIcon(this.textureName + "_" + i); 
  }
  
  public IIcon getIcon(int side, int meta) {
    return this.icons[side];
  }
  
  public void onBlockAdded(World world, int x, int y, int z) {
    world.scheduleBlockUpdate(x, y, z, this, 40);
  }
  
  public void updateTick(World world, int x, int y, int z, Random rndm) {
    super.updateTick(world, x, y, z, rndm);
    world.scheduleBlockUpdate(x, y, z, this, 20);
    if (world.getClosestVulnerablePlayer(x, y, z, 25.0D) != null)
      world.setBlock(x, y, z, mhm_Blocks.Tht1);
  }
}
