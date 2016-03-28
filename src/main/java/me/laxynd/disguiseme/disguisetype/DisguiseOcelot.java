package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;

public class DisguiseOcelot extends DisguiseTameable {
	
	public DisguiseOcelot(){
		super();
		
		dataTypes.put(14, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Ocelot){
			Ocelot o = (Ocelot) e;
			setType(o.getCatType().ordinal());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.OCELOT;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_CAT_AMBIENT;
	}
	
	public int getType(){
		return getInteger(14);
	}
	
	public void setType(int type){
		set(14, type);
	}
}