package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseElderGuardian extends DisguiseGuardian {
	
	@Override
	public EntityType getEntityType() {
		return EntityType.ELDER_GUARDIAN;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_ELDER_GUARDIAN_AMBIENT;
	}
}