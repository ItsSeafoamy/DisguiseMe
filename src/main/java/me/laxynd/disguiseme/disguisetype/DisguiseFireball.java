package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseFireball extends Disguise {

	@Override
	public EntityType getEntityType() {
		return EntityType.FIREBALL;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {}
}