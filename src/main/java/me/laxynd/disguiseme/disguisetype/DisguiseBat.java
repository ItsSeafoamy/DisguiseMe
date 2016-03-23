package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseBat extends DisguiseAmbient {
	
	public DisguiseBat(){
		super();
		
		dataTypes.put(11, BYTE);
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
	
	public boolean isHanging(){
		return getBitMask(11, 0x01);
	}
	
	public void setHanging(boolean hanging){
		setBitMask(11, 0x01, hanging);
	}
}