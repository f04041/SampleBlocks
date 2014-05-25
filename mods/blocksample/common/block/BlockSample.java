package mods.blocksample.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockSample extends Block
{

	public BlockSample(int par1, Material par2Material)
	{
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);//クリエイティブタブの選択
		this.setUnlocalizedName("blockSample");	//システム名の設定
		this.setTextureName("wool_colored");	//ブロックのテクスチャの指定
		//いらないものは消してください
		this.setHardness(0.0F);			//硬さ
		this.setResistance(2000.0F);		//爆破耐性
		this.setStepSound(Block.soundStoneFootstep);	//ブロックの音
		this.setBurnProperties(this.blockID, 5, 10);
	}

	/*
	 * 以下おまけ
	 * 特に機能がなければ消してしまってください
	 */

	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		//ブロックを壊した時にドロップするもの
		return this.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		//ブロックを壊した時にドロップする量
		return 1;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float disX, float disY, float disZ)
	{
		//ブロックが右クリックされた時
		return false;
	}

}