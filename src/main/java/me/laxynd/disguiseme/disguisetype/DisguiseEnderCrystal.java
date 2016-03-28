package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.OPT_POSITION;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseEnderCrystal extends Disguise {
	
	public DisguiseEnderCrystal(){
		super();
		
		dataTypes.put(5, OPT_POSITION);
		dataTypes.put(6, BOOLEAN);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ENDER_CRYSTAL;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {}
	
	public boolean showingBottom(){
		return getBoolean(6);
	}
	
	public void showBottom(boolean showBottom){
		set(6, showBottom);
	}
}