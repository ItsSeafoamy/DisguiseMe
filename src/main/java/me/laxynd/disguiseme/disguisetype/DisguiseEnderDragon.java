package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.EntityType;

public class DisguiseEnderDragon extends DisguiseInsentient {
	
	public DisguiseEnderDragon(){
		super();
		
		dataTypes.put(11, VARINT);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ENDER_DRAGON;
	}
	
	public int getDragonPhase(){
		return getInteger(11);
	}
	
	public void setDragonPhase(int dragonPhase){
		set(11, dragonPhase);
	}
}