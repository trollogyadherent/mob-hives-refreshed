package shadowmods.mhm.MobHives_Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityHiveSpiderRegular extends EntitySpider {
  public EntityHiveSpiderRegular(World world, double x, double y, double z) {
    this(world);
    setPosition(x, y, z);
  }
  
  public EntityHiveSpiderRegular(World p_i1732_1_) {
    super(p_i1732_1_);
    setSize(1.4F, 0.9F);
  }
  
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0D);
  }
  
  protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
    float f1 = getBrightness(1.0F);
    if (f1 > 0.5F && this.rand.nextInt(100) == 0) {
      this.entityToAttack = null;
    } else if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.rand.nextInt(10) == 0) {
      if (this.onGround) {
        double d0 = p_70785_1_.posX - this.posX;
        double d1 = p_70785_1_.posZ - this.posZ;
        float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
        this.motionX = d0 / f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
        this.motionZ = d1 / f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
        this.motionY = 0.4000000059604645D;
      } 
    } else {
      super.attackEntity(p_70785_1_, p_70785_2_);
    } 
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
