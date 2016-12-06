package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

public class DisguiseWolf extends DisguiseTameable {
	
	public DisguiseWolf(){
		super();
		
		dataTypes.put(15, FLOAT);
		dataTypes.put(16, BOOLEAN);
		dataTypes.put(17, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Wolf){
			Wolf w = (Wolf) e;
			setBegging(w.isAngry());
			setHealth((float) w.getHealth());
			setCollarColor((byte) w.getCollarColor().ordinal());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.WOLF;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_WOLF_AMBIENT;
	}
	
	public float getDamageTaken(){
		return getFloat(15);
	}
	
	public void setDamageTaken(float damageTaken){
		set(15, damageTaken);
	}
	
	public boolean isBegging(){
		return getBoolean(16);
	}
	
	public void setBegging(boolean begging){
		set(16, begging);
	}
	
	public int getCollarColor(){
		return getByte(17);
	}
	
	public void setCollarColor(int collarColor){
		set(17, collarColor);
	}
}
