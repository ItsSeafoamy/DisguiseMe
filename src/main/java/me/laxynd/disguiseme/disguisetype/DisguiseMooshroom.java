package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MushroomCow;

public class DisguiseMooshroom extends DisguiseAgeable {

	@Override
	public EntityType getEntityType() {
		return EntityType.MUSHROOM_COW;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_COW_AMBIENT;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof MushroomCow){
		} else throw new IllegalArgumentException();
	}
}