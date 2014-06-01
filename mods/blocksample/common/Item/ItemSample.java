package mods.blocksample.common.Item;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
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
		boolean flag = true;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);
        if (par1ItemStack.getItemDamage() == 2)
        {
        	par3EntityPlayer.dropPlayerItem(new ItemStack(this, 1, 1));
            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }
        }else if(par1ItemStack.getItemDamage() == 0){
        	if (movingobjectposition == null)
            {
                return par1ItemStack;
            }else{
            	if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                    {
                        return par1ItemStack;
                    }

                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    if (par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
                    {
                        par2World.setBlockToAir(i, j, k);

                        ItemStack item = new ItemStack(this,1,1);

                        if (par3EntityPlayer.capabilities.isCreativeMode)
                        {
                            return par1ItemStack;
                        }

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return item;
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(item))
                        {
                            par3EntityPlayer.dropPlayerItem(item);
                        }

                        return par1ItemStack;
                    }
            }


        }
      }
        return par1ItemStack;
    }

        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister) {
        this.iconItemSample = new Icon[3];

        for (int i = 0; i < this.iconItemSample.length; ++i)
        {
            this.iconItemSample[i] = par1IconRegister.registerIcon("samplemod:itemsample_" + i);
        }
    }

}