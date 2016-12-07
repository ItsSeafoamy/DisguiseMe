package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;

public abstract class DisguiseInsentient extends DisguiseLivingEntity {
	
	public DisguiseInsentient(){
		super();
		
		dataTypes.put(11, BYTE);
	}
	
	public boolean hasNoAI(){
		return getBitMask(11, 0x01);
	}
	
	public void setNoAI(boolean noAI){
		setBitMask(11, 0x01, noAI);
	}
	
	public boolean isLeftHanded(){
		return getBitMask(11, 0x02);
	}
	
	public void setLeftHanded(boolean leftHanded){
		setBitMask(11, 0x02, leftHanded);
	}
}
