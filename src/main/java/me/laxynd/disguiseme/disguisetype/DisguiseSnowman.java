package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowman;

public class DisguiseSnowman extends DisguiseGolem {

	public DisguiseSnowman(){
		super();
		
		dataTypes.put(12, BYTE);
	}
	
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
	
	public boolean hasNoPumpkinHat(){
		return getBitMask(12, 0x10);
	}
	
	public void setNoPumpkinHat(boolean noPumpkinHat){
		setBitMask(12, 0x10, noPumpkinHat);
	}
}
