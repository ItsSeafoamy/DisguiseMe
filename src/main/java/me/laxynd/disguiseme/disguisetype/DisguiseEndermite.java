package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseEndermite extends DisguiseMonster {

	@Override
	public EntityType getEntityType() {
		return EntityType.ENDERMITE;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_ENDERMITE_AMBIENT;
	}
}