package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;

public class DisguiseGuardian extends DisguiseMonster {
	
	public DisguiseGuardian(){
		super();
		
		dataTypes.put(16, BYTE);
		dataTypes.put(17, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Guardian){
			Guardian g = (Guardian) e;
			setElder(g.isElder());
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
		return getBitMask(11, 0x02);
	}
	
	public void setRetractingSpikes(boolean retractingSpikes){
		setBitMask(11, 0x02, retractingSpikes);
	}
	
	public boolean isElder(){
		return getBitMask(11, 0x04);
	}
	
	public void setElder(boolean elder){
		setBitMask(11, 0x04, elder);
	}
	
	public int getTarget(){
		return getInteger(12);
	}
	
	public void setTarget(int target){
		set(12, target);
	}
}