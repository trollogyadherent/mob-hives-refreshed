package shadowmods.mhm.MobHives_TileEntities;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraftforge.common.ForgeChunkManager;
import shadowmods.mhm.MobHives;
import shadowmods.mhm.MobHives_Entities.EntityHiveSkeleton;
import shadowmods.mhm.MobHives_ImportantClasses.mhm_Blocks;

public class HiveTier2TE extends TileEntity {
  private ForgeChunkManager.Ticket ticket;
  
  boolean triedToAssignTicket;
  
  public void writeToNBT(NBTTagCompound tag) {
    super.writeToNBT(tag);
  }
  
  public void readFromNBT(NBTTagCompound compound) {
    super.readFromNBT(compound);
  }
  
  public boolean canUpdate() {
    return true;
  }
  
  public void invalidate() {
    ForgeChunkManager.releaseTicket(this.ticket);
    super.invalidate();
  }
  
  public void forceChunkLoading(ForgeChunkManager.Ticket ticket) {
    if (this.ticket == null)
      this.ticket = ticket; 
    ChunkCoordIntPair chunk = new ChunkCoordIntPair(this.xCoord >> 4, this.zCoord >> 4);
    ForgeChunkManager.forceChunk(ticket, chunk);
  }
  
  public void updateEntity() {
    super.updateEntity();
    if (!this.triedToAssignTicket && !this.worldObj.isRemote) {
      this.triedToAssignTicket = true;
      if (this.ticket == null)
        this.ticket = ForgeChunkManager.requestTicket(MobHives.instance, this.worldObj, ForgeChunkManager.Type.NORMAL);
      if (this.ticket == null) {
        System.out.println("Ticket could not be reserved for Tier 2 Hive @ (" + this.xCoord + "," + this.yCoord + "," + this.zCoord + ")");
      } else {
        this.ticket.getModData().setInteger("coreX", this.xCoord);
        this.ticket.getModData().setInteger("coreY", this.yCoord);
        this.ticket.getModData().setInteger("coreZ", this.zCoord);
        ForgeChunkManager.forceChunk(this.ticket, new ChunkCoordIntPair(this.xCoord >> 4, this.zCoord >> 4));
      } 
    } 
    boolean found = false;
    if (this.worldObj.getClosestVulnerablePlayer(this.xCoord, this.yCoord, this.zCoord, 50.0D) == null)
      this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, mhm_Blocks.ht2); 
    List<EntityMob> e = this.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox((this.xCoord - 50), (this.yCoord - 20), (this.zCoord - 50), (this.xCoord + 50), (this.yCoord + 20), (this.zCoord + 50)));
    for (int h = 0; h < e.size(); h++) {
      if (e.get(h) instanceof EntityHiveSkeleton)
        found = true; 
    } 
    if (!found) {
      this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, mhm_Blocks.dh);
      TileEntity chest = this.worldObj.getTileEntity(this.xCoord, this.yCoord + 1, this.zCoord);
      if (chest == null) {
        this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, (Block)Blocks.chest);
        chest = this.worldObj.getTileEntity(this.xCoord, this.yCoord + 1, this.zCoord);
        System.out.println("Chest Placed");
      } 
      TileEntityChest schest = (TileEntityChest)chest;
      if (schest.getStackInSlot(0) == null)
        schest.setInventorySlotContents(0, new ItemStack(Items.iron_ingot, 16)); 
      if (schest.getStackInSlot(1) == null)
        schest.setInventorySlotContents(1, new ItemStack(Items.flint, 16)); 
      if (schest.getStackInSlot(2) == null)
        schest.setInventorySlotContents(2, new ItemStack(Items.cooked_beef, 16)); 
      if (schest.getStackInSlot(3) == null)
        schest.setInventorySlotContents(3, new ItemStack(Blocks.coal_block, 8)); 
      if (schest.getStackInSlot(4) == null)
        schest.setInventorySlotContents(4, new ItemStack(Blocks.cobblestone, 32)); 
    } 
  }
}
