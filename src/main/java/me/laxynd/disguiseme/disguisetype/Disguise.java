package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BLOCK_ID;
import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.CHAT;
import static me.laxynd.disguiseme.DataType.DIRECTION;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.OPT_POSITION;
import static me.laxynd.disguiseme.DataType.OPT_UUID;
import static me.laxynd.disguiseme.DataType.POSITION;
import static me.laxynd.disguiseme.DataType.SLOT;
import static me.laxynd.disguiseme.DataType.STRING;
import static me.laxynd.disguiseme.DataType.VARINT;
import static me.laxynd.disguiseme.DataType.VECTOR3F;
import java.util.Hashtable;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import me.laxynd.disguiseme.DisguiseAPI;

public abstract class Disguise {

	public Hashtable<Integer, Object> metadata = new Hashtable<Integer, Object>();
	public Hashtable<Integer, Integer> dataTypes = new Hashtable<Integer, Integer>();

	/**
	 * Gets the entity type this disguise is of
	 * @return The entity type
	 */
	public abstract EntityType getEntityType();
	
	/**
	 * Gets the idle sound this disguise should make
	 * @return The sound if it should make one, null otherwise
	 */
	public abstract Sound getSound();

	public Disguise(){
		dataTypes.put(0, BYTE);
		dataTypes.put(1, VARINT);
		dataTypes.put(2, STRING);
		dataTypes.put(3, BOOLEAN);
		dataTypes.put(4, BOOLEAN);
		dataTypes.put(5, BOOLEAN);
	}

	public void solveConflicts(Disguise other){
		for (int index : other.dataTypes.keySet()){
			if (dataTypes.containsKey(index) && dataTypes.get(index) != other.dataTypes.get(index) && !metadata.containsKey(index)){
				if (dataTypes.get(index) == BYTE) set(index, (byte) 0);
				else if (dataTypes.get(index) == VARINT) set(index, 0);
				else if (dataTypes.get(index) == FLOAT) set(index, 0f);
				else if (dataTypes.get(index) == STRING) set(index, "");
				else if (dataTypes.get(index) == CHAT) set(index, "");
				else if (dataTypes.get(index) == SLOT) ;
				else if (dataTypes.get(index) == BOOLEAN) set(index, false);
				else if (dataTypes.get(index) == VECTOR3F) set(index, new float[3]);
				else if (dataTypes.get(index) == POSITION) ;
				else if (dataTypes.get(index) == OPT_POSITION) ;
				else if (dataTypes.get(index) == DIRECTION) ;
				else if (dataTypes.get(index) == OPT_UUID) ;
				else if (dataTypes.get(index) == BLOCK_ID) set(index, 0);
			}
		}
	}

	public void writeDefaults(){
		for (int index : dataTypes.keySet()){
			if (!metadata.containsKey(index)){
				if (dataTypes.get(index) == BYTE) set(index, (byte) 0);
				else if (dataTypes.get(index) == VARINT) set(index, 0);
				else if (dataTypes.get(index) == FLOAT) set(index, 0f);
				else if (dataTypes.get(index) == STRING) set(index, "");
				else if (dataTypes.get(index) == CHAT) set(index, "");
				else if (dataTypes.get(index) == SLOT) ;
				else if (dataTypes.get(index) == BOOLEAN) set(index, false);
				else if (dataTypes.get(index) == VECTOR3F) set(index, new float[3]);
				else if (dataTypes.get(index) == POSITION) ;
				else if (dataTypes.get(index) == OPT_POSITION) ;
				else if (dataTypes.get(index) == DIRECTION) ;
				else if (dataTypes.get(index) == OPT_UUID) ;
				else if (dataTypes.get(index) == BLOCK_ID) set(index, 0);
			}
		}
	}

	/**
	 * Disguises the given entity as this disguise
	 * @param entityID - The entity ID of the entity to disguise
	 */
	public void disguise(int entityID){
		DisguiseAPI.disguise(entityID, this);
	}

	/**
	 * Updates the disguise on the given entity
	 * This is preferred over {@link #disguise(int)} if you have only changed metadata or entity equipment
	 * @param entityID - The entity ID of the entity to disguise
	 */
	public void update(int entityID){
		DisguiseAPI.update(entityID);
	}

	/**
	 * Undisguises the given entity
	 * @param entityID - The entity ID of the entity to disguise
	 */
	public void undisguise(int entityID){
		DisguiseAPI.undisguise(entityID);
	}

	/**
	 * Create a new Disguise based on an existing entity
	 * @param entity - The entity to base this disguise from
	 */
	public abstract void from(Entity entity);

	public void set(int index, Object value){
		if (value != null){
			metadata.put(index, value);
		}
	}

	public void setBitMask(int index, int bitMask, boolean value){
		if (value){
			set(index, (byte) (getByte(index) | bitMask));
		} else {
			set(index, (byte) ((getByte(index) & (0xFF - bitMask))));
		}
	}

	public boolean getBitMask(int index, int bitMask){
		return (getByte(index) & bitMask) == 1;
	}

	public byte getByte(int index){
		if (metadata.containsKey(index)){
			return (byte) metadata.get(index);
		} else {
			return (byte) 0;
		}
	}

	public int getInteger(int index){
		if (metadata.containsKey(index)){
			return (int) metadata.get(index);
		} else {
			return 0;
		}
	}

	public float getFloat(int index){
		if (metadata.containsKey(index)){
			return (float) metadata.get(index);
		} else {
			return 0f;
		}
	}

	public String getString(int index){
		if (metadata.containsKey(index)){
			return (String) metadata.get(index);
		} else {
			return null;
		}
	}

	public String getChat(int index){
		if (metadata.containsKey(index)){
			return (String) metadata.get(index);
		} else {
			return null;
		}
	}

	public boolean getBoolean(int index){
		if (metadata.containsKey(index)){
			return (boolean) metadata.get(index);
		} else {
			return false;
		}
	}

	public float[] getVector3F(int index){
		if (metadata.containsKey(index)){
			return (float[]) metadata.get(index);
		} else {
			return new float[3];
		}
	}

	public int getBlockId(int index){
		if (metadata.containsKey(index)){
			return (int) metadata.get(index);
		} else {
			return 0;
		}
	}

	public boolean isOnFire(){
		byte b = getByte(0);
		int c = b & 0x01;

		return c == 1;
	}

	public void setOnFire(boolean onFire){
		if (onFire){
			metadata.put(0, getByte(0) | 0x01);
		} else {
			metadata.put(0, getByte(0) & (0xFF - 0x01));
		}
	}

	public boolean isCrouched(){
		byte b = getByte(0);
		int c = b & 0x02;

		return c == 1;
	}

	public void setCrouched(boolean crouched){
		if (crouched){
			metadata.put(0, getByte(0) | 0x02);
		} else {
			metadata.put(0, getByte(0) & (0xFF - 0x02));
		}
	}

	public boolean isSprinting(){
		byte b = getByte(0);
		int c = b & 0x08;

		return c == 1;
	}

	public void setSprinting(boolean sprinting){
		if (sprinting){
			metadata.put(0, getByte(0) | 0x08);
		} else {
			metadata.put(0, getByte(0) & (0xFF - 0x08));
		}
	}

	public boolean isBlocking(){
		byte b = getByte(0);
		int c = b & 0x10;

		return c == 1;
	}

	public void setBlocking(boolean blocking){
		if (blocking){
			metadata.put(0, getByte(0) | 0x10);
		} else {
			metadata.put(0, getByte(0) & (0xFF - 0x10));
		}
	}

	public boolean isInvisible(){
		byte b = getByte(0);
		int c = b & 0x20;

		return c == 1;
	}

	public void setInvisible(boolean invisible){
		if (invisible){
			metadata.put(0, getByte(0) | 0x20);
		} else {
			metadata.put(0, getByte(0) & (0xFF - 0x20));
		}
	}

	public boolean isGlowing(){
		byte b = getByte(0);
		int c = b & 0x40;

		return c == 1;
	}

	public void setGlowing(boolean glowing){
		if (glowing){
			metadata.put(0, getByte(0) | 0x40);
		} else {
			metadata.put(0, getByte(0) & (0xFF - 0x40));
		}
	}

	public boolean isFlyingWithElytra(){
		byte b = getByte(0);
		int c = b & 0x80;

		return c == 1;
	}

	public void setFlyingWithElytra(boolean flyingWithElytra){
		if (flyingWithElytra){
			metadata.put(0, getByte(0) | 0x80);
		} else {
			metadata.put(0, getByte(0) & (0xFF - 0x80));
		}
	}

	public int getAir(){
		return getInteger(1);
	}

	public void setAir(int air){
		set(1, air);
	}

	public String getCustomName(){
		return getString(2);
	}

	public void setCustomName(String customName){
		set(2, customName);
	}

	public boolean isCustomNameVisible(){
		return getBoolean(3);
	}

	public void setCustomNameVisible(boolean customNameVisible){
		set(3, customNameVisible);
	}

	public boolean isSilent(){
		return getBoolean(4);
	}

	public void setSilent(boolean silent){
		set(4, silent);
	}
	
	public boolean hasNoGravity(){
		return getBoolean(5);
	}
	
	public void setNoGravity(boolean noGravity){
		set(5, noGravity);
	}
}