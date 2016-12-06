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
		
		dataTypes.put(6, FLOAT);
		dataTypes.put(7, VARINT);
		dataTypes.put(8, BOOLEAN);
		dataTypes.put(9, VARINT);
		dataTypes.put(10, VARINT);
		dataTypes.put(11,  VARINT);
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
		return getFloat(6);
	}
	
	public void setRadius(float radius){
		set(6, radius);
	}
	
	public int getColor(){
		return getInteger(7);
	}
	
	public void setColor(int color){
		set(7, color);
	}
	
	public boolean isSinglePoint(){
		return getBoolean(8);
	}
	
	public void setSinglePoint(boolean singlePoint){
		set(8, singlePoint);
	}
	
	public int getParticleId(){
		return getInteger(9);
	}
	
	public void setParticleId(int particleId){
		set(9, particleId);
	}
	
	public int getParticleParameter1(){
		return getInteger(10);
	}
	
	public void setParticleParameter1(int particleParameter1){
		set(10, particleParameter1);
	}
	
	public int getParticleParameter2(){
		return getInteger(11);
	}
	
	public void setParticleParameter2(int particleParameter2){
		set(11, particleParameter2);
	}
}