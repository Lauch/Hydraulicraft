package k4unl.minecraft.Hydraulicraft.thirdParty.bluepower;

import java.util.ArrayList;

import k4unl.minecraft.Hydraulicraft.api.IHarvesterTrolley;
import k4unl.minecraft.Hydraulicraft.lib.config.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TrolleyFlax implements IHarvesterTrolley {
	private static final ResourceLocation resLoc =
            new ResourceLocation(ModInfo.LID,"textures/model/harvesterFlax.png");
	
	@Override
	public String getName() {
		return "flax";
	}

	@Override
	public boolean canHarvest(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z) == 7;
	}

	@Override
	public boolean canPlant(World world, int x, int y, int z, ItemStack seed) {
		Block soil = world.getBlock(x, y-1, z);
		return soil.equals(Blocks.dirt) || soil.equals(Blocks.grass) || soil.equals(Blocks.end_stone);
	}

	@Override
	public ArrayList<ItemStack> getHandlingSeeds() {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(Item.getItemFromBlock(BluePower.flaxBlock)));
		return ret;
	}

	@Override
	public Block getBlockForSeed(ItemStack seed) {
		return BluePower.flaxBlock;
	}

	@Override
	public ResourceLocation getTexture() {
		return resLoc;
	}

	@Override
	public int getPlantHeight(World world, int x, int y, int z) {
		return 1;
	}

}
