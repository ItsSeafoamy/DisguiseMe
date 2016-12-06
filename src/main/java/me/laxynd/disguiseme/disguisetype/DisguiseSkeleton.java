package me.laxynd.disguiseme.disguisetype;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;

public class DisguiseSkeleton extends DisguiseAbstractSkeleton {
	
	@Deprecated
	public static final int NORMAL = 0;
	@Deprecated
	public static final int WITHER = 1;
	
	public DisguiseSkeleton(){
		super();
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Skeleton){
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SKELETON;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_SKELETON_AMBIENT;
	}
	
	@Deprecated
	public int getType(){
		return -1;
	}
	
	@Deprecated
	public void setType(int type){}
}