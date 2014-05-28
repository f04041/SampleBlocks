package mods.blocksample.common.Item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSample extends Item {

        @SideOnly(Side.CLIENT)
        private Icon[] iconItemSample;

	public ItemSample(int par1) {
		super(par1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return super.getIconFromDamage(par1);
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		//名前の登録
		return this.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		//メタデータでアイテムを追加する
		//par3List.add(new ItemStack(this, 1, <メタデータ>));
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
		par3List.add(new ItemStack(this, 1, 2));
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		boolean flag =false;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);
        if (par1ItemStack.getItemDamage() == 2)
        {
        	par3EntityPlayer.dropPlayerItem(new ItemStack(this, 1, 1));
            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }
        }
        return par1ItemStack;
    }

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int i1 = par3World.getBlockId(par4, par5, par6);
        Block block = Block.waterStill;
        if((par1ItemStack.getItemDamage() == 2)){

        	if (i1 == Block.waterStill.blockID && par1ItemStack.getItemDamage() == 0)
        	{
        		par2EntityPlayer.dropPlayerItem(new ItemStack(pickaxeDiamond, 1, 0));
        		--par1ItemStack.stackSize;
        		return true;
        }else{
        		return false;
        	}
        }
        return false;
    }


        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister) {
                //テクスチャのパス指定。
                //メタデータは0から2でつまり3未満
                //src/minecraft/assets/samplemod/items/itemsample_(メタデータ).png
        this.iconItemSample = new Icon[3];

        for (int i = 0; i < this.iconItemSample.length; ++i)
        {
            this.iconItemSample[i] = par1IconRegister.registerIcon("samplemod:itemsample_" + i);
        }
    }

}