package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseStray extends DisguiseAbstractSkeleton {

	@Override
	public EntityType getEntityType() {
		return EntityType.STRAY;
	}

	@Override
	public Sound getSound() {
		return Sound.ENTITY_STRAY_AMBIENT;
	}
}