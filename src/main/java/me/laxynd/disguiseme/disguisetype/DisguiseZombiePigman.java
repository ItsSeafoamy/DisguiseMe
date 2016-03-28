package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;

public class DisguiseZombiePigman extends DisguiseZombie {

	@Override
	public EntityType getEntityType(){
		return EntityType.PIG_ZOMBIE;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_ZOMBIE_PIG_AMBIENT;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof PigZombie){
		} else throw new IllegalArgumentException();
	}
}
