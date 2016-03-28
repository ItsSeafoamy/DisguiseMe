package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;

public class DisguiseWither extends DisguiseMonster {

	public DisguiseWither(){
		super();
		
		dataTypes.put(11, VARINT);
		dataTypes.put(12, VARINT);
		dataTypes.put(13, VARINT);
		dataTypes.put(14, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Wither){
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.WITHER;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_WITHER_AMBIENT;
	}
	
	public int getWatchedTarget1(){
		return getInteger(11);
	}
	
	public void setWatchedTarget1(int watchedTarget1){
		set(11, watchedTarget1);
	}
	
	public int getWatchedTarget2(){
		return getInteger(12);
	}
	
	public void setWatchedTarget2(int watchedTarget2){
		set(12, watchedTarget2);
	}
	
	public int getWatchedTarget3(){
		return getInteger(13);
	}
	
	public void setWatchedTarget3(int watchedTarget3){
		set(13, watchedTarget3);
	}
	
	public int getInvulnerableTime(){
		return getInteger(14);
	}
	
	public void setInvulnerableTime(int invulnerableTime){
		set(14, invulnerableTime);
	}
}