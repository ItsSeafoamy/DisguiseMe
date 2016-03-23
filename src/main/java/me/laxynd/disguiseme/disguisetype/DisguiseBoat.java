package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseBoat extends Disguise {
	
	public DisguiseBoat(){
		super();
		
		dataTypes.put(5, VARINT);
		dataTypes.put(6, VARINT);
		dataTypes.put(7, FLOAT);
		dataTypes.put(8, VARINT);
		dataTypes.put(9, BOOLEAN);
		dataTypes.put(10, BOOLEAN);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.BOAT;
	}

	@Override
	public void from(Entity e) {}
	
	public int getTimeSinceLastHit(){
		return getInteger(5);
	}
	
	public void setTimeSinceLastHit(int timeSinceLastHit){
		set(5, timeSinceLastHit);
	}
	
	public int getForwardDirection(){
		return getInteger(6);
	}
	
	public void setForwardDirection(int forwardDirection){
		set(6, forwardDirection);
	}
	
	public float getDamageTaken(){
		return getFloat(7);
	}
	
	public void setDamageTaken(float damageTaken){
		set(7, damageTaken);
	}
	
	public int getType(){
		return getInteger(8);
	}
	
	public void setType(int type){
		set(8, type);
	}
}