package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.OPT_UUID;

public abstract class DisguiseAbstractHorse extends DisguiseAnimal {

	public DisguiseAbstractHorse(){
		super();

		dataTypes.put(13, BYTE);
		dataTypes.put(14, OPT_UUID);
	}
	
	public boolean getTamed(){
		return getBitMask(13, 0x02);
	}
	
	public void setTamed(boolean tamed){
		setBitMask(13, 0x02, tamed);
	}
	
	public boolean hasSaddle(){
		return getBitMask(13, 0x04);
	}
	
	public void setSaddle(boolean saddle){
		setBitMask(13, 0x04, saddle);
	}
	
	public boolean hasChest(){
		return getBitMask(13, 0x08);
	}
	
	public void setChest(boolean chest){
		setBitMask(13, 0x08, chest);
	}
	
	public boolean isBred(){
		return getBitMask(13, 0x10);
	}
	
	public void setBred(boolean bred){
		setBitMask(13, 0x10, bred);
	}
	
	public boolean isEating(){
		return getBitMask(13, 0x20);
	}
	
	public void setEating(boolean eating){
		setBitMask(13, 0x20, eating);
	}
	
	public boolean isRearing(){
		return getBitMask(13, 0x40);
	}
	
	public void setRearing(boolean rearing){
		setBitMask(13, 0x40, rearing);
	}
	
	public boolean getMouthOpen(){
		return getBitMask(13, 0x80);
	}
	
	public void setMouthOpen(boolean mouthOpen){
		setBitMask(13, 0x80, mouthOpen);
	}
}