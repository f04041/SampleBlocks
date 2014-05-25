package mods.blocksample.common;

import mods.blocksample.common.block.BlockPlasitcPanels;
import mods.blocksample.common.block.BlockPlastic;
import mods.blocksample.common.block.BlockPlasticGlass;
import mods.blocksample.common.block.BlockSample;
import mods.blocksample.common.block.BlocksamplePanel;
import mods.blocksample.common.block.ItemBlockPlastic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="BlockSampleMod", name="BlockSampleMod", version="1.0")
public class SampleBlockCore
{
	public static Block blockSample;
	public static int blockSampleID = 4087;
	public static Block blockSamplePanel;
	public static Block blockPlastic;
	public static Block blockPlastic2;
	public static Block blockPlasticGlass;
	public static Block blockPlasticPanels;
	public static Block blockPlasticPanels2;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//表示名の登録
		LanguageRegistry.addName(blockSample, "Sample Block");
		LanguageRegistry.instance().addNameForObject(blockSample, "ja_JP", "サンプル ブロック");
		LanguageRegistry.addName(blockSamplePanel, "Sample Block Panel");
		LanguageRegistry.instance().addNameForObject(blockSamplePanel, "ja_JP", "サンプル ブロックパネル");
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//ブロックの登録
		blockSamplePanel=new BlocksamplePanel(blockSampleID+1, "iron_bars", "iron_bars", Material.wood, false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockSamplePanel").setLightValue(1.0F);
		blockSample = new BlockSample(blockSampleID, Material.cloth).setLightValue(1.0F);
		blockPlastic=new BlockPlastic(blockSampleID+2,Material.cloth).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setLightValue(1.0F).setUnlocalizedName("blockPlastic");
		blockPlastic2=new BlockPlastic(blockSampleID+3,Material.cloth).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlastic2");
		blockPlasticGlass=new BlockPlasticGlass(blockSampleID+4,Material.glass,false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("blockPlasticGlass").setTextureName("glass");
		blockPlasticPanels=new BlockPlasitcPanels(blockSampleID+5, "glass", "glass", Material.glass, false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("blockPlasticPanel").setLightValue(1.0F);
		blockPlasticPanels2=new BlockPlasitcPanels(blockSampleID+6, "glass", "glass", Material.glass, false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("blockPlasticPanel2");

		GameRegistry.registerBlock(blockSample, "blockSample");
		GameRegistry.registerBlock(blockSamplePanel, "blockSamplePanel");
		GameRegistry.registerBlock(blockPlastic, ItemBlockPlastic.class, "blockPlastic");
		GameRegistry.registerBlock(blockPlastic2, ItemBlockPlastic.class, "blockPlastic2");
		GameRegistry.registerBlock(blockPlasticGlass, ItemBlockPlastic.class, "blockPlasticGlass");
		GameRegistry.registerBlock(blockPlasticPanels, ItemBlockPlastic.class, "blockPlasticPanel");
		GameRegistry.registerBlock(blockPlasticPanels2, ItemBlockPlastic.class, "blockPlasticPanel2");
	}
}