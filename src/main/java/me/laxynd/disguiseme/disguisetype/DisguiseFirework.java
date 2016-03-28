package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.SLOT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseFirework extends Disguise {
	
	public DisguiseFirework(){
		super();
		
		dataTypes.put(5, SLOT);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.FIREWORK;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {}
}