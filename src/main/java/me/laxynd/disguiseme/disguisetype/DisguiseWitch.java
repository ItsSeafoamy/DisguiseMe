package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Witch;

public class DisguiseWitch extends DisguiseMonster {

	public DisguiseWitch(){
		super();
		
		dataTypes.put(11, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Witch){
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.WITCH;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_WITCH_AMBIENT;
	}
	
	public boolean isAgressive(){
		return getBoolean(11);
	}
	
	public void setAgressive(boolean agressive){
		set(11, agressive);
	}
}