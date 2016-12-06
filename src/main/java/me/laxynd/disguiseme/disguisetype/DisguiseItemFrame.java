package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.SLOT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;

public class DisguiseItemFrame extends DisguiseHanging {
	
	public DisguiseItemFrame(){
		super();
		
		dataTypes.put(6, SLOT);
		dataTypes.put(7, VARINT);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ITEM_FRAME;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {
		if (e instanceof ItemFrame){
			setRotation(((ItemFrame) e).getRotation().ordinal());
		} else throw new IllegalArgumentException();
	}
	
	public int getRotation(){
		return getInteger(7);
	}
	
	public void setRotation(int rotation){
		set(7, rotation);
	}
}