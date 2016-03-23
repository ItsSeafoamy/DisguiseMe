package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;

public class DisguiseSkeleton extends DisguiseMonster {
	
	public static final int NORMAL = 0;
	public static final int WITHER = 1;
	
	public DisguiseSkeleton(){
		super();
		
		dataTypes.put(11, VARINT);
		dataTypes.put(12, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Skeleton){
			Skeleton s = (Skeleton) e;
			setType(s.getSkeletonType() == Skeleton.SkeletonType.WITHER ? 1 : 0);
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SKELETON;
	}
	
	public int getType(){
		return getInteger(11);
	}
	
	public void setType(int type){
		set(11, type);
	}
}