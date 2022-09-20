package shadowmods.mhm.MobHives_Entities;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHiveSkeletonRegular extends EntityMob implements IRangedAttackMob {
  private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
  
  private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);
  
  public EntityHiveSkeletonRegular(World world) {
    super(world);
    setSize(1.0F, 2.0F);
    this.tasks.addTask(1, new EntityAISwimming(this));
    this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
    this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 50.0F));
    this.tasks.addTask(3, new EntityAILookIdle(this));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    if (world != null && !world.isRemote)
      setCombatTask(); 
  }
  
  public EntityHiveSkeletonRegular(World world, double x, double y, double z) {
    this(world);
    setPosition(x, y, z);
  }
  
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  protected boolean canDespawn() {
    return false;
  }
  
  protected String getLivingSound() {
    return "mob.skeleton.say";
  }
  
  protected String getHurtSound() {
    return "mob.skeleton.hurt";
  }
  
  protected String getDeathSound() {
    return "mob.skeleton.death";
  }
  
  protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    playSound("mob.skeleton.step", 0.15F, 1.0F);
  }
  
  public boolean attackEntityAsMob(Entity p_70652_1_) {
    if (super.attackEntityAsMob(p_70652_1_))
      return true; 
    return false;
  }
  
  protected Item getDropItem() {
    return Items.arrow;
  }
  
  protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
    int j = this.rand.nextInt(3 + p_70628_2_);
    int k;
    for (k = 0; k < j; k++)
      dropItem(Items.arrow, 1); 
    j = this.rand.nextInt(3 + p_70628_2_);
    for (k = 0; k < j; k++)
      dropItem(Items.iron_ingot, 1); 
  }
  
  protected void dropRareDrop(int p_70600_1_) {
    entityDropItem(new ItemStack((Item)Items.bow, 1, 1), 0.0F);
  }
  
  public void setCombatTask() {
    this.tasks.removeTask(this.aiAttackOnCollide);
    this.tasks.removeTask(this.aiArrowAttack);
    //ItemStack itemstack = getHeldItem();
    this.tasks.addTask(4, this.aiArrowAttack);
  }
  
  public ItemStack getHeldItem() {
    return defaultHeldItem;
  }
  
  private static final ItemStack defaultHeldItem = new ItemStack(Items.bow, 1);
  
  public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
    EntityArrow entityarrow = new EntityArrow(this.worldObj, this, p_82196_1_, 1.6F, (14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
    int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, getHeldItem());
    int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, getHeldItem());
    entityarrow.setDamage((p_82196_2_ * 2.0F) + this.rand.nextGaussian() * 0.25D + (this.worldObj.difficultySetting.getDifficultyId() * 0.11F));
    if (i > 0)
      entityarrow.setDamage(entityarrow.getDamage() + i * 1.0D + 0.5D); 
    if (j > 0)
      entityarrow.setKnockbackStrength(j); 
    if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, getHeldItem()) > 0)
      entityarrow.setFire(100); 
    playSound("random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
    this.worldObj.spawnEntityInWorld(entityarrow);
  }
  
  public double getYOffset() {
    return super.getYOffset() - 0.5D;
  }
  
  public void onUpdate() {
    super.onUpdate();
    this.fallDistance = 0.0F;
  }
  
  protected Entity findPlayerToAttack() {
    EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 50.0D);
    return (entityplayer != null && canEntityBeSeen(entityplayer)) ? entityplayer : null;
  }
}
