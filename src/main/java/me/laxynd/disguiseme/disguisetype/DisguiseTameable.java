package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.OPT_UUID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Tameable;

public abstract class DisguiseTameable extends DisguiseAnimal {

	public DisguiseTameable(){
		super();
		
		dataTypes.put(12, BYTE);
		dataTypes.put(13, OPT_UUID);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Tameable){
			Tameable t = (Tameable) e;
			setTamed(t.isTamed());
		} else throw new IllegalArgumentException();
	}
	
	public boolean isSitting(){
		return getBitMask(12, 0x01);
	}
	
	public void setSitting(boolean sitting){
		setBitMask(12, 0x01, sitting);
	}
	
	public boolean isTamed(){
		return getBitMask(12, 0x04);
	}
	
	public void setTamed(boolean tamed){
		setBitMask(12, 0x04, tamed);
	}
}