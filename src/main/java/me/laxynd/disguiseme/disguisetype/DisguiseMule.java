package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseMule extends DisguiseChestedHorse {

	@Override
	public EntityType getEntityType() {
		return EntityType.MULE;
	}

	@Override
	public Sound getSound() {
		return Sound.ENTITY_MULE_AMBIENT;
	}
}