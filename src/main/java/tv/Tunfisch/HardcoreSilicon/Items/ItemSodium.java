package tv.Tunfisch.HardcoreSilicon.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tv.Tunfisch.HardcoreSilicon.Entity.EntitySodium;

public class ItemSodium extends Item{
	public ItemSodium(){

	}
	
	@Override
	public boolean hasCustomEntity(ItemStack stack)
    {
        return true;
    }
	
	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack)
    {
        EntityItem ItemSodium = new EntitySodium(location.worldObj, location, itemstack);
        NBTTagCompound nbt = new NBTTagCompound();
        location.writeToNBTOptional(nbt);
        ItemSodium.readFromNBT(nbt);
        return ItemSodium;
    }
}
