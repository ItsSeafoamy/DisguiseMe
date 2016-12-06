package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseWitherSkull extends DisguiseFireball {
	
	public DisguiseWitherSkull(){
		super();
		
		dataTypes.put(6, BOOLEAN);
	}
	
	@Override
	public EntityType getEntityType(){
		return EntityType.WITHER_SKULL;
	}
	
	@Override
	public void from(Entity e){}
	
	public boolean isInvulnerable(){
		return getBoolean(6);
	}
	
	public void setInvulnerable(boolean invulnerable){
		set(6, invulnerable);
	}
}