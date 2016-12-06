package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseDonkey extends DisguiseChestedHorse {

	@Override
	public EntityType getEntityType() {
		return EntityType.DONKEY;
	}

	@Override
	public Sound getSound() {
		return Sound.ENTITY_DONKEY_AMBIENT;
	}
}