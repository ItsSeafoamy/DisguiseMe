package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseCaveSpider extends DisguiseSpider {
	
	@Override
	public EntityType getEntityType(){
		return EntityType.CAVE_SPIDER;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_SPIDER_AMBIENT;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof CaveSpider){
		} else throw new IllegalArgumentException();
	}
}