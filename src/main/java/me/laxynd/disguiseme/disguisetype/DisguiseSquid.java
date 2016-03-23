package me.laxynd.disguiseme.disguisetype;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Squid;

public class DisguiseSquid extends DisguiseLivingEntity {

	@Override
	public EntityType getEntityType() {
		return EntityType.SQUID;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Squid){
		} else throw new IllegalArgumentException();
	}
}