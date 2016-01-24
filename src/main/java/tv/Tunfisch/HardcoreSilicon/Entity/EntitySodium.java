package tv.Tunfisch.HardcoreSilicon.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ExplosionEvent;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;


public class EntitySodium extends EntityItem{
	
	public EntitySodium(World worldIn, Entity location, ItemStack stack)
	    {
			super(worldIn);
	    }
	
	@Override
	public void onEntityUpdate(){
		if (this.isWet()){
			/*
			EntityTNTPrimed explode = new EntityTNTPrimed(worldObj, posX, posY, posZ, null);
			explode.setInvisible(true);
			explode.fuse = 0;
			setFire(5);
			worldObj.spawnEntityInWorld(explode);	
			*/	
			Explosion explode = new Explosion(worldObj, riddenByEntity, posX, posY, posZ, hoverStart, addedToChunk, addedToChunk);
			explode.doExplosionA();
			explode.doExplosionB(true);	
		}
	}

}
