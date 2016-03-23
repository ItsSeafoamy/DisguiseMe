package me.laxynd.disguiseme.disguisetype;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;

public class DisguiseMagmaCube extends DisguiseSlime {

	@Override
	public EntityType getEntityType(){
		return EntityType.MAGMA_CUBE;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof MagmaCube){
		} else throw new IllegalArgumentException();
	}
}