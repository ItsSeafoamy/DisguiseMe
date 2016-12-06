package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseWitherSkeleton extends DisguiseAbstractSkeleton {

	@Override
	public EntityType getEntityType() {
		return EntityType.WITHER_SKELETON;
	}

	@Override
	public Sound getSound() {
		return Sound.ENTITY_WITHER_SKELETON_AMBIENT;
	}
}