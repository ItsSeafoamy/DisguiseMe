package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseCreeper extends DisguiseMonster {
	
	public static final int IDLE = -1;
	public static final int FUSE = 1;
	
	public DisguiseCreeper(){
		super();
		
		dataTypes.put(12, VARINT);
		dataTypes.put(13, BOOLEAN);
		dataTypes.put(14, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Creeper){
			Creeper c = (Creeper) e;
			setCharged(c.isPowered());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.CREEPER;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}
	
	public int getState(){
		return getInteger(12);
	}
	
	public void setState(int state){
		set(12, state);
	}
	
	public boolean isCharged(){
		return getBoolean(13);
	}
	
	public void setCharged(boolean charged){
		set(13, charged);
	}
	
	public boolean isIgnited(){
		return getBoolean(14);
	}
	
	public void setIgnited(boolean ignited){
		set(14, ignited);
	}
}