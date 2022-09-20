package shadowmods.mhm.MobHives_ImportantClasses;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import shadowmods.mhm.MobHives_TileEntities.*;

public class ChunkLoadCallBack implements ForgeChunkManager.OrderedLoadingCallback {
  public void ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world) {
    for (ForgeChunkManager.Ticket ticket : tickets) {
      int coreX = ticket.getModData().getInteger("coreX");
      int coreY = ticket.getModData().getInteger("coreY");
      int coreZ = ticket.getModData().getInteger("coreZ");
      if (world.getTileEntity(coreX, coreY, coreZ) instanceof HiveTier1TE) {
        HiveTier1TE entity = (HiveTier1TE)world.getTileEntity(coreX, coreY, coreZ);
        entity.forceChunkLoading(ticket);
      } 
      if (world.getTileEntity(coreX, coreY, coreZ) instanceof HiveTier2TE) {
        HiveTier2TE entity = (HiveTier2TE)world.getTileEntity(coreX, coreY, coreZ);
        entity.forceChunkLoading(ticket);
      } 
      if (world.getTileEntity(coreX, coreY, coreZ) instanceof HiveTier3TE) {
        HiveTier3TE entity = (HiveTier3TE)world.getTileEntity(coreX, coreY, coreZ);
        entity.forceChunkLoading(ticket);
      } 
      if (world.getTileEntity(coreX, coreY, coreZ) instanceof HiveTier4TE) {
        HiveTier4TE entity = (HiveTier4TE)world.getTileEntity(coreX, coreY, coreZ);
        entity.forceChunkLoading(ticket);
      } 
      if (world.getTileEntity(coreX, coreY, coreZ) instanceof HiveTier5TE) {
        HiveTier5TE entity = (HiveTier5TE)world.getTileEntity(coreX, coreY, coreZ);
        entity.forceChunkLoading(ticket);
      } 
    } 
  }
  
  public List<ForgeChunkManager.Ticket> ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world, int maxTicketCount) {
    List<ForgeChunkManager.Ticket> validTickets = new ArrayList<ForgeChunkManager.Ticket>();
    for (ForgeChunkManager.Ticket ticket : tickets) {
      int coreX = ticket.getModData().getInteger("coreX");
      int coreY = ticket.getModData().getInteger("coreY");
      int coreZ = ticket.getModData().getInteger("coreZ");
      Block block = world.getBlock(coreX, coreY, coreZ);
      if (block == mhm_Blocks.Tht1)
        validTickets.add(ticket); 
      if (block == mhm_Blocks.Tht2)
        validTickets.add(ticket); 
      if (block == mhm_Blocks.Tht3)
        validTickets.add(ticket); 
      if (block == mhm_Blocks.Tht4)
        validTickets.add(ticket); 
      if (block == mhm_Blocks.Tht5)
        validTickets.add(ticket); 
    } 
    return validTickets;
  }
}
