package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseSkeletonHorse extends DisguiseAbstractHorse {

	@Override
	public EntityType getEntityType() {
		return EntityType.SKELETON_HORSE;
	}

	@Override
	public Sound getSound() {
		return Sound.ENTITY_SKELETON_HORSE_AMBIENT;
	}
}