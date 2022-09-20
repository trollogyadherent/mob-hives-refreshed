package shadowmods.mhm.MobHives_ImportantClasses;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import shadowmods.mhm.MobHives_Entities.EntityHiveCreeper;

public class EntityAIHiveCreeperSwell extends EntityAIBase {
  EntityHiveCreeper swellingCreeper;
  
  EntityLivingBase creeperAttackTarget;

  public EntityAIHiveCreeperSwell(EntityHiveCreeper p_i1655_1_) {
    this.swellingCreeper = p_i1655_1_;
    setMutexBits(1);
  }
  
  public boolean shouldExecute() {
    EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
    return (this.swellingCreeper.getCreeperState() > 0 || (entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity(entitylivingbase) < 9.0D));
  }
  
  public void startExecuting() {
    this.swellingCreeper.getNavigator().clearPathEntity();
    this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
  }
  
  public void resetTask() {
    this.creeperAttackTarget = null;
  }
  
  public void updateTask() {
    if (this.creeperAttackTarget == null) {
      this.swellingCreeper.setCreeperState(-1);
    } else if (this.swellingCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0D) {
      this.swellingCreeper.setCreeperState(-1);
    } else if (!this.swellingCreeper.getEntitySenses().canSee(this.creeperAttackTarget)) {
      this.swellingCreeper.setCreeperState(-1);
    } else {
      this.swellingCreeper.setCreeperState(1);
    } 
  }
}
