package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

public class DisguiseSlime extends DisguiseFlying {
	
	public DisguiseSlime(){
		super();
		
		dataTypes.put(11, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Slime){
			Slime s = (Slime) e;
			setSize((byte) s.getSize());
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SLIME;
	}
	
	public int getSize(){
		return getInteger(11);
	}
	
	public void setSize(int size){
		set(11, size);
	}
}