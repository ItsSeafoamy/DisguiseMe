package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseSilverfish extends DisguiseMonster {

	@Override
	public EntityType getEntityType() {
		return EntityType.SILVERFISH;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_SILVERFISH_AMBIENT;
	}
}