package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

public class DisguisePig extends DisguiseAnimal {
	
	public DisguisePig(){
		super();
		
		dataTypes.put(12, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Pig){
			Pig p = (Pig) e;
			setSaddle(p.hasSaddle());
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.PIG;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_PIG_AMBIENT;
	}
	
	public boolean hasSaddle(){
		return getBoolean(16);
	}
	
	public void setSaddle(boolean saddle){
		set(16, saddle);
	}
}