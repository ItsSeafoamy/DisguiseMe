package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseChicken extends DisguiseAnimal {

	@Override
	public EntityType getEntityType() {
		return EntityType.CHICKEN;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_CHICKEN_AMBIENT;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Chicken){
		} else throw new IllegalArgumentException();
	}
}