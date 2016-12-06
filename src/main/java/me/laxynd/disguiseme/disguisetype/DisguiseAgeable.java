package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;

public abstract class DisguiseAgeable extends DisguiseCreature {
	
	public DisguiseAgeable(){
		super();
		
		dataTypes.put(12, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Ageable){
			Ageable a = (Ageable) e;
			
			setChild(!a.isAdult());
		} else throw new IllegalArgumentException();
	}
	
	/**
	 * Checks if this disguise is of a child
	 * @return If this disguise represents a child
	 */
	public boolean isChild(){
		return getBoolean(12);
	}
	
	/**
	 * Set whether this disguise should be a child or not
	 * @param child - If true, this disguise will be of a child, otherwise it will be of an adult
	 */
	public void setChild(boolean child){
		set(12, child);
	}
}