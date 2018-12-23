package com.parzivail.swg.item.lightsaber;

import com.parzivail.swg.Resources;
import com.parzivail.swg.item.PItem;
import com.parzivail.util.audio.SoundHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLightsaber extends PItem
{
	public ItemLightsaber()
	{
		super("lightsaber");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking())
		{
			if (!world.isRemote)
			{
				LightsaberData bd = new LightsaberData(stack);

				if (bd.openingState == 0)
				{
					bd.isOpen = !bd.isOpen;

					if (bd.isOpen)
						SoundHandler.playSound(player, Resources.modColon("swg.fx.saber.start"), 1, 1);
					else
						SoundHandler.playSound(player, Resources.modColon("swg.fx.saber.stop"), 1, 1);
				}

				bd.serialize(stack.stackTagCompound);
			}
		}
		else
			player.setItemInUse(stack, getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float subX, float subY, float subZ)
	{
		if (!world.isRemote)
		{
			LightsaberData bd = new LightsaberData(stack);

			if (bd.isOpen)
				SoundHandler.playSound(player, Resources.modColon("swg.fx.saber.swing"), 1, 1);
		}
		return super.onItemUse(stack, player, world, x, y, z, side, subX, subY, subZ);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int p_77663_4_, boolean p_77663_5_)
	{
		LightsaberData bd = new LightsaberData(stack);

		if (bd.isOpen)
		{
			if (bd.openAnimation < 4)
			{
				bd.openAnimation++;
				bd.openingState = 1;
			}
			else
			{
				bd.openAnimation = 4;
				bd.openingState = 0;
			}
		}
		else
		{
			if (bd.openAnimation > 0)
			{
				bd.openAnimation--;
				bd.openingState = -1;
			}
			else
			{
				bd.openAnimation = 0;
				bd.openingState = 0;
			}
		}

		bd.serialize(stack.stackTagCompound);
	}

	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.block;
	}

	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
		return 72000;
	}

	public boolean canItemHarvestBlock(Block p_150897_1_)
	{
		return false;
	}
}
