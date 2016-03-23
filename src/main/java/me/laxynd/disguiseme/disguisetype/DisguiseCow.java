package me.laxynd.disguiseme.disguisetype;

import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseCow extends DisguiseAnimal {

	@Override
	public EntityType getEntityType() {
		return EntityType.COW;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Cow){
		} else throw new IllegalArgumentException();
	}
}