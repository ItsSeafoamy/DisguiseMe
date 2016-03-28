package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseAreaEffectCloud extends Disguise {
	
	public DisguiseAreaEffectCloud(){
		super();
		
		dataTypes.put(5, FLOAT);
		dataTypes.put(6, VARINT);
		dataTypes.put(7, BOOLEAN);
		dataTypes.put(8, VARINT);
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.AREA_EFFECT_CLOUD;
	}
	
	@Override
	public Sound getSound(){
		return null;
	}

	@Override
	public void from(Entity e) {
		if (e instanceof AreaEffectCloud){
			AreaEffectCloud aec = (AreaEffectCloud) e;
			setRadius(aec.getRadius());
			setColor(aec.getColor().asRGB()); //I think
			setSinglePoint(false);
			setParticleId(aec.getParticle().ordinal());
		} else throw new IllegalArgumentException();
	}
	
	public float getRadius(){
		return getFloat(5);
	}
	
	public void setRadius(float radius){
		set(5, radius);
	}
	
	public int getColor(){
		return getInteger(6);
	}
	
	public void setColor(int color){
		set(6, color);
	}
	
	public boolean isSinglePoint(){
		return getBoolean(7);
	}
	
	public void setSinglePoint(boolean singlePoint){
		set(7, singlePoint);
	}
	
	public int getParticleId(){
		return getInteger(8);
	}
	
	public void setParticleId(int particleId){
		set(8, particleId);
	}
}