package shadowmods.mhm.MobHives_Blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import shadowmods.mhm.Config;
import shadowmods.mhm.MobHives_Entities.EntityHiveSkeletonRegular;
import shadowmods.mhm.MobHives_ImportantClasses.mhm_Blocks;

public class SkeletonHive extends Block {
  public IIcon[] icons = new IIcon[6];
  
  public SkeletonHive(Material material) {
    super(material);
    setBlockName("SkeletonHive");
    setBlockTextureName("mhm:sh");
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
    if (world.getClosestVulnerablePlayer(x, y, z, 25.0D) != null) {
      world.spawnEntityInWorld(new EntityFireworkRocket(world, x, (y + 2), z, null));
      world.setBlock(x, y, z, mhm_Blocks.dh);
      for (int v = 0; v < Config.ssp; v++)
        world.spawnEntityInWorld(new EntityHiveSkeletonRegular(world, x, (y + 1), z));
    } 
  }
}
