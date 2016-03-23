package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseTippedArrow extends DisguiseArrow {
	
	public DisguiseTippedArrow(){
		super();
		
		dataTypes.put(6, VARINT);
	}
	
	@Override
	public EntityType getEntityType(){
		return EntityType.TIPPED_ARROW;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
	}

	public int getColor(){
		return getInteger(6);
	}
	
	public void setColor(int color){
		set(6, color);
	}
}