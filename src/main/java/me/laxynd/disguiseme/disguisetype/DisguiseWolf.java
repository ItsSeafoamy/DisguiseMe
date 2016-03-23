package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

public class DisguiseWolf extends DisguiseTameable {
	
	public DisguiseWolf(){
		super();
		
		dataTypes.put(14, FLOAT);
		dataTypes.put(15, BOOLEAN);
		dataTypes.put(16, VARINT);
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
	
	public float getDamageTaken(){
		return getFloat(14);
	}
	
	public void setDamageTaken(float damageTaken){
		set(14, damageTaken);
	}
	
	public boolean isBegging(){
		return getBoolean(15);
	}
	
	public void setBegging(boolean begging){
		set(15, begging);
	}
	
	public int getCollarColor(){
		return getByte(15);
	}
	
	public void setCollarColor(int collarColor){
		set(15, collarColor);
	}
}
