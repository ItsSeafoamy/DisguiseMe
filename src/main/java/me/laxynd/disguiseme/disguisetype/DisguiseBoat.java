package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseBoat extends Disguise {
	
	public DisguiseBoat(){
		super();
		
		dataTypes.put(6, VARINT);
		dataTypes.put(7, VARINT);
		dataTypes.put(8, FLOAT);
		dataTypes.put(9, VARINT);
		dataTypes.put(10, BOOLEAN);
		dataTypes.put(11, BOOLEAN);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.BOAT;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {}
	
	public int getTimeSinceLastHit(){
		return getInteger(6);
	}
	
	public void setTimeSinceLastHit(int timeSinceLastHit){
		set(6, timeSinceLastHit);
	}
	
	public int getForwardDirection(){
		return getInteger(7);
	}
	
	public void setForwardDirection(int forwardDirection){
		set(7, forwardDirection);
	}
	
	public float getDamageTaken(){
		return getFloat(8);
	}
	
	public void setDamageTaken(float damageTaken){
		set(8, damageTaken);
	}
	
	public int getType(){
		return getInteger(9);
	}
	
	public void setType(int type){
		set(9, type);
	}
	
	public boolean isRightPaddleTurning(){
		return getBoolean(10);
	}
	
	public void setRightPaddleTurning(boolean rightPaddleTurning){
		set(10, rightPaddleTurning);
	}
	
	public boolean isLeftPaddleTurning(){
		return getBoolean(11);
	}
	
	public void setLeftPaddleTurning(boolean leftPaddleTurning){
		set(10, leftPaddleTurning);
	}
}