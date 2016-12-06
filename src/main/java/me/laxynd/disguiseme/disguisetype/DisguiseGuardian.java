package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;

public class DisguiseGuardian extends DisguiseMonster {
	
	public DisguiseGuardian(){
		super();
		
		dataTypes.put(12, BOOLEAN);
		dataTypes.put(13, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Guardian){
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.GUARDIAN;
	}
	
	@Override
	public Sound getSound(){
		if (!isElder()){
			return Sound.ENTITY_GUARDIAN_AMBIENT;
		} else {
			return Sound.ENTITY_ELDER_GUARDIAN_AMBIENT;
		}
	}
	
	public boolean isRetractingSpikes(){
		return getBoolean(12);
	}
	
	public void setRetractingSpikes(boolean retractingSpikes){
		set(12, retractingSpikes);
	}
	
	@Deprecated
	public boolean isElder(){return false;}
	
	@Deprecated
	public void setElder(boolean elder){}
	
	public int getTarget(){
		return getInteger(13);
	}
	
	public void setTarget(int target){
		set(13, target);
	}
}