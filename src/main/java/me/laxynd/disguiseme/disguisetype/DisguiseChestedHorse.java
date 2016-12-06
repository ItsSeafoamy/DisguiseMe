package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Entity;

public abstract class DisguiseChestedHorse extends DisguiseAbstractHorse {
	
	public DisguiseChestedHorse(){
		super();
		
		dataTypes.put(15, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof ChestedHorse){
			setChest(((ChestedHorse) e).isCarryingChest());
		} else throw new IllegalArgumentException();
	}
	
	public boolean hasChest(){
		return getBoolean(15);
	}
	
	public void setChest(boolean chest){
		set(15, chest);
	}
}