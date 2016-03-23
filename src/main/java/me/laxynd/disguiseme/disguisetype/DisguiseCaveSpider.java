package me.laxynd.disguiseme.disguisetype;

import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseCaveSpider extends DisguiseSpider {
	
	@Override
	public EntityType getEntityType(){
		return EntityType.CAVE_SPIDER;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof CaveSpider){
		} else throw new IllegalArgumentException();
	}
}