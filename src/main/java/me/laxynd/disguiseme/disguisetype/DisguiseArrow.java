package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseArrow extends Disguise {
	
	public DisguiseArrow(){
		super();
		
		dataTypes.put(5, BYTE);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ARROW;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {
		if (e instanceof Arrow){
			Arrow arrow = (Arrow) e;
			setCritical(arrow.isCritical());
		}
	}
	
	public boolean isCritical(){
		return getByte(5) != 0;
	}
	
	public void setCritical(boolean critical){
		set(5, critical ? (byte) 1 : (byte) 0);
	}
}