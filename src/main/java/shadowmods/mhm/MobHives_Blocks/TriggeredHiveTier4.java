package shadowmods.mhm.MobHives_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import shadowmods.mhm.MobHives;
import shadowmods.mhm.MobHives_ImportantClasses.Tier4HiveForces;
import shadowmods.mhm.MobHives_TileEntities.HiveTier4TE;

public class TriggeredHiveTier4 extends Block implements ITileEntityProvider {
  public static ForgeChunkManager.Ticket ticket;
  
  public IIcon[] icons = new IIcon[6];
  
  public TriggeredHiveTier4(Material material) {
    super(material);
    setBlockName("TriggeredHiveTier4");
    setBlockTextureName("mhm:ht4");
  }
  
  public void registerBlockIcons(IIconRegister reg) {
    for (int i = 0; i < 6; i++)
      this.icons[i] = reg.registerIcon(this.textureName + "_" + i); 
  }
  
  public IIcon getIcon(int side, int meta) {
    return this.icons[side];
  }
  
  public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
    if (!world.isRemote) {
      if (ticket != null)
        ForgeChunkManager.unforceChunk(ticket, new ChunkCoordIntPair(x / 16, z / 16)); 
    } 
  }
  
  public void onBlockAdded(World world, int x, int y, int z) {
    if (!world.isRemote) {
      world.spawnEntityInWorld(new EntityFireworkRocket(world, x, (y + 2), z, null));
      ForgeChunkManager.Ticket ticket = ForgeChunkManager.requestTicket(MobHives.instance, world, ForgeChunkManager.Type.NORMAL);
      if (ticket != null)
        ForgeChunkManager.forceChunk(ticket, new ChunkCoordIntPair(x / 16, z / 16)); 
      Tier4HiveForces.spawnHiveForces(world, x, y + 1, z);
    } 
  }
  
  public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
    return new HiveTier4TE();
  }
  
  public boolean hasTileEntity(int metadata) {
    return true;
  }
}
