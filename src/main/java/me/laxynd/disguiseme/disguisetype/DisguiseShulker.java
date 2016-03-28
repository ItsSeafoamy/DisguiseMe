package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.DIRECTION;
import static me.laxynd.disguiseme.DataType.OPT_POSITION;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseShulker extends DisguiseGolem {
	
	public DisguiseShulker(){
		super();
		
		dataTypes.put(11, DIRECTION);
		dataTypes.put(12, OPT_POSITION);
		dataTypes.put(13, BYTE);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.SHULKER;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_SHULKER_AMBIENT;
	}
	
	public byte getShieldHeight(){
		return getByte(13);
	}
	
	public void setShieldHeight(byte shieldHeight){
		set(13, shieldHeight);
	}
}