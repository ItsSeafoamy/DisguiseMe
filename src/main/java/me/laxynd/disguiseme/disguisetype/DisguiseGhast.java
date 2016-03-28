package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;

public class DisguiseGhast extends DisguiseFlying{
	
	public DisguiseGhast(){
		super();
		
		dataTypes.put(11, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Ghast){
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.GHAST;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_GHAST_AMBIENT;
	}
	
	public boolean isAttacking(){
		return getBoolean(11);
	}
	
	public void setAttacking(boolean attacking){
		set(11, attacking);
	}
}