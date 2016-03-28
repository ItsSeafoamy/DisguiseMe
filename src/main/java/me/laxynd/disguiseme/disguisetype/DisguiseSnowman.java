package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowman;

public class DisguiseSnowman extends DisguiseLivingEntity {

	@Override
	public EntityType getEntityType() {
		return EntityType.SNOWMAN;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_SNOWMAN_AMBIENT;
	}

	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Snowman){
		} else throw new IllegalArgumentException();
	}
}
