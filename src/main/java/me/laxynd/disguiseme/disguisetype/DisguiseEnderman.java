package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BLOCK_ID;
import static me.laxynd.disguiseme.DataType.BOOLEAN;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class DisguiseEnderman extends DisguiseMonster {
	
	public DisguiseEnderman(){
		super();
		
		dataTypes.put(11, BLOCK_ID);
		dataTypes.put(12, BOOLEAN);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Enderman){
			Enderman end = (Enderman) e;
			setCarriedBlock(end.getCarriedMaterial().toItemStack());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.ENDERMAN;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_ENDERMEN_AMBIENT;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getCarriedBlock(){
		int id = getInteger(11) >> 4;
		int data = getInteger(11) & 0xF;
		
		return new ItemStack(Bukkit.getUnsafe().getMaterialFromInternalName(Integer.toString(id)), 1, (short) data);
	}
	
	@SuppressWarnings("deprecation")
	public void setCarriedBlock(ItemStack carriedBlock){
		set(11, carriedBlock.getTypeId() << 4 | carriedBlock.getDurability());
	}
	
	public boolean isScreaming(){
		return getBoolean(12);
	}
	
	public void setScreaming(boolean screaming){
		set(12, screaming);
	}
}