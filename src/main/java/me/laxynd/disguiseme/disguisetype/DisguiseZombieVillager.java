package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.*;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class DisguiseZombieVillager extends DisguiseZombie {
	
	public static final int FARMER = 0;
	public static final int LIBRARIAN = 1;
	public static final int PRIEST = 2;
	public static final int BLACKSMITH = 3;
	public static final int BUTCHER = 4;
	public static final int NITWIT = 5;
	
	public DisguiseZombieVillager(){
		super();
		
		dataTypes.put(15, BOOLEAN);
		dataTypes.put(16, VARINT);
	}
	
	@Override
	public EntityType getEntityType(){
		return EntityType.ZOMBIE_VILLAGER;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_ZOMBIE_VILLAGER_AMBIENT;
	}
	
	public boolean isConverting(){
		return getBoolean(15);
	}
	
	public void setConverting(boolean converting){
		set(15, converting);
	}
	
	public int getProfession(){
		return getInteger(16);
	}
	
	public void setProfession(int profession){
		set(16, profession);
	}
}