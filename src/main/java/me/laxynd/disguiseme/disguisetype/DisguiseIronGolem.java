package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;

public class DisguiseIronGolem extends DisguiseLivingEntity {

	public DisguiseIronGolem(){
		super();
		
		dataTypes.put(11, BYTE);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof IronGolem){
			IronGolem ig = (IronGolem) e;
			setPlayerCreated(ig.isPlayerCreated());
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.IRON_GOLEM;
	}
	
	public boolean isPlayerCreated(){
		return getBitMask(11, 0x01);
	}
	
	public void setPlayerCreated(boolean playerCreated){
		setBitMask(11, 0x01, playerCreated);
	}
}
