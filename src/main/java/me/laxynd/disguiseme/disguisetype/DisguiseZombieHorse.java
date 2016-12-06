package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseZombieHorse extends DisguiseAbstractHorse {

	@Override
	public EntityType getEntityType() {
		return EntityType.ZOMBIE_HORSE;
	}

	@Override
	public Sound getSound() {
		return Sound.ENTITY_ZOMBIE_HORSE_AMBIENT;
	}
}