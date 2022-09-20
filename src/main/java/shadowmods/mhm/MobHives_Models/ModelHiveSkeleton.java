package shadowmods.mhm.MobHives_Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelHiveSkeleton extends ModelZombie {
  public ModelHiveSkeleton() {
    this(0.0F);
  }
  
  public ModelHiveSkeleton(float p_i1156_1_) {
    super(p_i1156_1_, 0.0F, 64, 32);
    this.bipedRightArm = new ModelRenderer((ModelBase)this, 40, 16);
    this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i1156_1_);
    this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
    this.bipedLeftArm = new ModelRenderer((ModelBase)this, 40, 16);
    this.bipedLeftArm.mirror = true;
    this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i1156_1_);
    this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
    this.bipedRightLeg = new ModelRenderer((ModelBase)this, 0, 16);
    this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i1156_1_);
    this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
    this.bipedLeftLeg = new ModelRenderer((ModelBase)this, 0, 16);
    this.bipedLeftLeg.mirror = true;
    this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i1156_1_);
    this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
  }
  
  public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
    this.aimedBow = true;
    super.setLivingAnimations(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
  }
  
  public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
    super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
  }
}
