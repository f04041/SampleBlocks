package mods.blocksample.common;

import mods.blocksample.common.block.BlockSample;
import mods.blocksample.common.block.BlocksamplePanel;
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
	public static Block blockSamplePanel=(new BlocksamplePanel(blockSampleID+1, "iron_bars", "iron_bars", Material.wood, true)).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockSamplePanel");

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
		blockSample = new BlockSample(blockSampleID, Material.cloth);
		GameRegistry.registerBlock(blockSample, "blockSample");
		GameRegistry.registerBlock(blockSamplePanel, "blockSamplePanel");
	}
}