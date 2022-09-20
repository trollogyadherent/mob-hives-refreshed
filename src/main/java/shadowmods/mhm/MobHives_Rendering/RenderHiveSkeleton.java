package shadowmods.mhm.MobHives_Rendering;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHiveSkeleton extends RenderBiped {
  private static final ResourceLocation skeletonTextures = new ResourceLocation("textures/entity/skeleton/skeleton.png");
  
  public RenderHiveSkeleton(ModelBiped model, float shadowsize) {
    super(model, 0.5F);
  }
  
  protected ResourceLocation getEntityTexture(Entity entity) {
    return skeletonTextures;
  }
  
  public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float rotationPitch) {
    doRender((EntityLiving)entity, x, y, z, rotationYaw, rotationPitch);
  }
}
