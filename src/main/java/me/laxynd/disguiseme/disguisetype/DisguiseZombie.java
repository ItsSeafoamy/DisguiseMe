package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public class DisguiseZombie extends DisguiseMonster {
	
	public DisguiseZombie(){
		super();
		
		dataTypes.put(12, BOOLEAN);
		dataTypes.put(13, VARINT);
		dataTypes.put(14, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Zombie){
			Zombie z = (Zombie) e;
			setChild(z.isBaby());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ZOMBIE;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_ZOMBIE_AMBIENT;
	}
	
	public boolean isChild(){
		return getBoolean(12);
	}
	
	public void setChild(boolean child){
		set(12, child);
	}
	
	@Deprecated
	public int getVillagerProfession(){
		return -1;
	}
	
	@Deprecated
	public void setVillagerProfession(int villagerProfession){}
	
	@Deprecated
	public boolean isConverting(){
		return false;
	}
	
	@Deprecated
	public void setConverting(boolean converting){}
	
	public boolean areHandsHeldUp(){
		return getBoolean(14);
	}
	
	public void setHandsHeldUp(boolean handsHeldUp){
		set(14, handsHeldUp);
	}
}
