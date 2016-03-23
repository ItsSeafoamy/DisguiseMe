package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseBlaze extends DisguiseMonster {
	
	public DisguiseBlaze(){
		super();
		
		dataTypes.put(11, BYTE);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Blaze){
			Blaze b = (Blaze) e;
			setOnFire(b.getFireTicks() > 0);
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.BLAZE;
	}
	
	public boolean isOnFire(){
		return getBitMask(11, 0x01);
	}
	
	public void setOnFire(boolean onFire){
		setBitMask(11, 0x01, onFire);
	}
}