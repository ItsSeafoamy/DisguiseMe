package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;

public class DisguiseSpider extends DisguiseMonster {
	
	public DisguiseSpider(){
		super();
		
		dataTypes.put(11, BYTE);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Spider){
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.SPIDER;
	}
	
	public boolean isClimbing(){
		return getBitMask(11, 0x01);
	}
	
	public void setClimbing(boolean climbing){
		setBitMask(11, 0x01, climbing);
	}
}