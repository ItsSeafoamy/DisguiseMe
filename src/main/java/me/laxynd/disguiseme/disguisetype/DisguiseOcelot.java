package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;

public class DisguiseOcelot extends DisguiseTameable {
	
	public static final int TYPE_UNTAMED = 0;
	public static final int TYPE_TUXEDO = 1;
	public static final int TYPE_TABBY = 2;
	public static final int TYPE_SIAMESE = 3;

	
	public DisguiseOcelot(){
		super();
		
		dataTypes.put(15, VARINT);
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
		return getInteger(15);
	}
	
	public void setType(int type){
		set(15, type);
	}
}