package shadowmods.mhm.MobHives_Entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHiveZombieRegular extends EntityMob {
  private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);
  
  private final EntityAIBreakDoor field_146075_bs = new EntityAIBreakDoor(this);
  
  public EntityHiveZombieRegular(World world) {
    super(world);
    setSize(0.6F, 1.8F);
    getNavigator().setBreakDoors(true);
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
    this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
    this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
    this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
    this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
    this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 50.0F));
    this.tasks.addTask(8, new EntityAILookIdle(this));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
  }
  
  public EntityHiveZombieRegular(World world, double x, double y, double z) {
    this(world);
    setPosition(x, y, z);
  }
  
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  protected boolean canDespawn() {
    return false;
  }
  
  public void onUpdate() {
    super.onUpdate();
    this.fallDistance = 0.0F;
  }
  
  protected String getLivingSound() {
    return "mob.zombie.say";
  }
  
  protected String getHurtSound() {
    return "mob.zombie.hurt";
  }
  
  protected String getDeathSound() {
    return "mob.zombie.death";
  }
  
  protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    playSound("mob.zombie.step", 0.15F, 1.0F);
  }
  
  public EnumCreatureAttribute getCreatureAttribute() {
    return EnumCreatureAttribute.UNDEAD;
  }
  
  public boolean attackEntityAsMob(Entity p_70652_1_) {
    if (super.attackEntityAsMob(p_70652_1_))
      return true; 
    return false;
  }
  
  protected Item getDropItem() {
    return Items.rotten_flesh;
  }
  
  protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
    int j = this.rand.nextInt(3 + p_70628_2_);
    for (int k = 0; k < j; k++)
      dropItem(Items.rotten_flesh, 1); 
  }
  
  protected void dropRareDrop(int p_70600_1_) {
    entityDropItem(new ItemStack(Items.iron_ingot, 1, 1), 0.0F);
  }
  
  public double getYOffset() {
    return super.getYOffset() - 0.5D;
  }
  
  protected Entity findPlayerToAttack() {
    EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 48.0D);
    return (entityplayer != null && canEntityBeSeen(entityplayer)) ? entityplayer : null;
  }
}
