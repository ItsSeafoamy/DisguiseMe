package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;

public class DisguiseLlama extends DisguiseChestedHorse {
	
	public static final int VARIANT_CREAMY = 0;
	public static final int VARIANT_WHITE = 1;
	public static final int VARIANT_BROWN = 2;
	public static final int VARIANT_GRAY = 3;

	
	public DisguiseLlama(){
		super();
		
		dataTypes.put(16, VARINT);
		dataTypes.put(17, VARINT);
		dataTypes.put(18, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Llama){
			Llama l = (Llama) e;
			setStrength(l.getStrength());
			setVariant(l.getColor().ordinal());
		}
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.LLAMA;
	}

	@Override
	public Sound getSound() {
		return Sound.ENTITY_LLAMA_AMBIENT;
	}
	
	public int getStrength(){
		return getInteger(16);
	}
	
	public void setStrength(int strength){
		set(16, strength);
	}
	
	public int getCarpetColor(){
		return getInteger(17);
	}
	
	public void setCarpetColor(int color){
		set(17, color);
	}
	
	public int getVariant(){
		return getInteger(18);
	}
	
	public void setVariant(int variant){
		set(18, variant);
	}
}