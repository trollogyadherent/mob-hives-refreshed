package shadowmods.mhm.MobHives_Rendering;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHiveZombieRegular extends RenderBiped {
  private static final ResourceLocation zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
  
  public RenderHiveZombieRegular(ModelBiped model, float shadowsize) {
    super((ModelBiped)new ModelZombie(), 0.5F, 1.0F);
  }
  
  protected ResourceLocation getEntityTexture(Entity entity) {
    return zombieTextures;
  }
  
  public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float rotationPitch) {
    doRender((EntityLiving)entity, x, y, z, rotationYaw, rotationPitch);
  }
}
