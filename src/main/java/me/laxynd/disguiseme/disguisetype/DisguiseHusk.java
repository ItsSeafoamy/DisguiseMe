package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseHusk extends DisguiseZombie {

	@Override
	public EntityType getEntityType(){
		return EntityType.HUSK;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_HUSK_AMBIENT;
	}
}