package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;

public abstract class DisguiseAbstractSkeleton extends DisguiseMonster {

	public DisguiseAbstractSkeleton(){
		super();
		
		dataTypes.put(12, BOOLEAN);
	}
	
	public boolean isSwingingArms(){
		return getBoolean(12);
	}
	
	public void setSwingingArms(boolean swingingArms){
		set(12, swingingArms);
	}
}