package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;

public class DisguiseRabbit extends DisguiseAnimal {
	
	public DisguiseRabbit(){
		super();
		
		dataTypes.put(13, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Rabbit){
			Rabbit r = (Rabbit) e;
			setType(r.getRabbitType().ordinal());
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.RABBIT;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_RABBIT_AMBIENT;
	}
	
	public int getType(){
		return getInteger(13);
	}
	
	public void setType(int type){
		set(13, type);
	}
}