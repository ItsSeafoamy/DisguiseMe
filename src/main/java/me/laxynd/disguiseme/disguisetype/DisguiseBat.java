package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseBat extends DisguiseAmbient {
	
	public DisguiseBat(){
		super();
		
		dataTypes.put(12, BYTE);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Bat){
			Bat b = (Bat) e;
			setHanging(!b.isAwake());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.BAT;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_BAT_AMBIENT;
	}
	
	public boolean isHanging(){
		return getBitMask(12, 0x01);
	}
	
	public void setHanging(boolean hanging){
		setBitMask(12, 0x01, hanging);
	}
}