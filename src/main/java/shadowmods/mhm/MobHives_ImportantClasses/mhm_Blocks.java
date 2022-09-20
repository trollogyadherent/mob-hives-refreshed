package shadowmods.mhm.MobHives_ImportantClasses;

import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import shadowmods.mhm.MobHives;
import shadowmods.mhm.MobHives_Blocks.*;

public class mhm_Blocks {
  public static Block ht1;
  
  public static Block ht2;
  
  public static Block ht3;
  
  public static Block ht4;
  
  public static Block ht5;
  
  public static Block Tht1;
  
  public static Block Tht2;
  
  public static Block Tht3;
  
  public static Block Tht4;
  
  public static Block Tht5;
  
  public static Block dh;
  
  public static Block ch;
  
  public static Block sh;
  
  public static Block sph;
  
  public static Block zh;
  
  public static final Block.SoundType soundTypeStone = new Block.SoundType("stone", 1.0F, 1.0F);
  
  public static final Block.SoundType soundTypeGravel = new Block.SoundType("gravel", 1.0F, 1.0F);
  
  public static final Block.SoundType soundTypeGrass = new Block.SoundType("grass", 1.0F, 1.0F);
  
  public static List<Block> blockList = new ArrayList<Block>();
  
  public static void registerBlocks() {
    blockList.add(ht1 = (new HiveTier1(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(ht2 = (new HiveTier2(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(ht3 = (new HiveTier3(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(ht4 = (new HiveTier4(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(ht5 = (new HiveTier5(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(Tht1 = (new TriggeredHiveTier1(Material.rock)).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(Tht2 = (new TriggeredHiveTier2(Material.rock)).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(Tht3 = (new TriggeredHiveTier3(Material.rock)).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(Tht4 = (new TriggeredHiveTier4(Material.rock)).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(Tht5 = (new TriggeredHiveTier5(Material.rock)).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(dh = (new DeadHive(Material.leaves)).setCreativeTab(MobHives.mhmTab).setHardness(0.6F).setStepSound(soundTypeGrass));
    blockList.add(ch = (new CreeperHive(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(sh = (new SkeletonHive(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(sph = (new SpiderHive(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    blockList.add(zh = (new ZombieHive(Material.rock)).setCreativeTab(MobHives.mhmTab).setBlockUnbreakable().setResistance(3000.0F).setStepSound(soundTypeStone).setLightLevel(1.0F));
    for (Block block : blockList)
      GameRegistry.registerBlock(block, block.getUnlocalizedName()); 
  }
}
