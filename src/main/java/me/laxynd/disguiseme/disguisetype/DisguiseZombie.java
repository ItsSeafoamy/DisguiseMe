package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public class DisguiseZombie extends DisguiseMonster {
	
	public DisguiseZombie(){
		super();
		
		dataTypes.put(11, BOOLEAN);
		dataTypes.put(12, VARINT);
		dataTypes.put(13, BOOLEAN);
		dataTypes.put(14, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Zombie){
			Zombie z = (Zombie) e;
			setChild(z.isBaby());
			setVillagerProfession(z.getVillagerProfession().ordinal());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ZOMBIE;
	}
	
	public boolean isChild(){
		return getBoolean(11);
	}
	
	public void setChild(boolean child){
		set(11, child);
	}
	
	public int getVillagerProfession(){
		return getInteger(12);
	}
	
	public void setVillagerProfession(int villagerProfession){
		set(12, villagerProfession);
	}
	
	public boolean isConverting(){
		return getBoolean(13);
	}
	
	public void setConverting(boolean converting){
		set(13, converting);
	}
	
	public boolean areHandsHeldUp(){
		return getBoolean(14);
	}
	
	public void setHandsHeldUp(boolean handsHeldUp){
		set(14, handsHeldUp);
	}
}
