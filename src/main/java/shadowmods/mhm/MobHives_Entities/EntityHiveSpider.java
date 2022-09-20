package shadowmods.mhm.MobHives_Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityHiveSpider extends EntitySpider {
  public EntityHiveSpider(World world, double x, double y, double z) {
    this(world);
    setPosition(x, y, z);
  }
  
  public EntityHiveSpider(World p_i1732_1_) {
    super(p_i1732_1_);
    setSize(1.4F, 0.9F);
  }
  
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0D);
  }
  
  public boolean attackEntityAsMob(Entity p_70652_1_) {
    if (super.attackEntityAsMob(p_70652_1_)) {
      if (p_70652_1_ instanceof EntityLivingBase) {
        byte b0 = 0;
        if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
          b0 = 7;
        } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
          b0 = 15;
        } 
        if (b0 > 0)
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0)); 
      } 
      return true;
    } 
    return false;
  }
  
  protected boolean canDespawn() {
    return false;
  }
  
  public void onUpdate() {
    super.onUpdate();
    this.fallDistance = 0.0F;
  }
  
  protected Entity findPlayerToAttack() {
    return this.worldObj.getClosestVulnerablePlayerToEntity(this, 48.0D);
  }
  
  public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
    return p_110161_1_;
  }
}
