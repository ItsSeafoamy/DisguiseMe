package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public abstract class DisguiseLivingEntity extends Disguise {
	
	private ItemStack held, offhand, boots, leggings, chestplate, helmet;
	private byte yaw;
	private boolean customYaw;
	
	public DisguiseLivingEntity(){
		super();
		
		dataTypes.put(5, BYTE);
		dataTypes.put(6, FLOAT);
		dataTypes.put(7, VARINT);
		dataTypes.put(8, BOOLEAN);
		dataTypes.put(9, VARINT);
		
		set(6, 20f);
	}
	
	@Override
	public void from(Entity e){
		if (e instanceof LivingEntity){
			LivingEntity le = (LivingEntity) e;
			setCustomName(le.getCustomName());
			setCustomNameVisible(le.isCustomNameVisible());
			setHealth((float) le.getHealth());
		}
	}
	
	public float getHealth(){
		return getFloat(6);
	}
	
	public void setHealth(float health){
		set(6, health);
	}
	
	public int getPotionEffectColor(){
		return getInteger(7);
	}
	
	public void setPotionEffectColor(int potionEffectColor){
		set(7, potionEffectColor);
	}
	
	public boolean isPotionEffectAmbient(){
		return getBoolean(8);
	}
	
	public void setPotionEffectAmbient(boolean potionEffectAmbient){
		set(8, potionEffectAmbient);
	}
	
	public int getNumberOfArrowsInEntity(){
		return getInteger(9);
	}
	
	public void setNumberOfArrowsInEntity(int numberOfArrowsInEntity){
		set(9, numberOfArrowsInEntity);
	}
	
	public ItemStack getHeldItem(){
		return held;
	}
	
	public void setHeldItem(ItemStack held){
		this.held = held;
	}
	
	public ItemStack getOffHandItem(){
		return offhand;
	}
	
	public void setOffHandItem(ItemStack offHandItem){
		offhand = offHandItem;
	}
	
	public ItemStack getBoots(){
		return boots;
	}
	
	public void setBoots(ItemStack boots){
		this.boots = boots;
	}
	
	public ItemStack getLeggings(){
		return leggings;
	}
	
	public void setLeggings(ItemStack leggings){
		this.leggings = leggings;
	}
	
	public ItemStack getChestplate(){
		return chestplate;
	}
	
	public void setChestplate(ItemStack chestplate){
		this.chestplate = chestplate;
	}
	
	public ItemStack getHelmet(){
		return helmet;
	}
	
	public void setHelmet(ItemStack helmet){
		this.helmet = helmet;
	}
	
	public ItemStack[] getEquipment(){
		return new ItemStack[]{held, offhand, boots, leggings, chestplate, helmet};
	}
	
	public void setEquipment(ItemStack[] equipment){
		if (equipment.length != 6) throw new IllegalArgumentException("Equipment must contain 6 values");
		
		held = equipment[0];
		offhand = equipment[1];
		boots = equipment[2];
		leggings = equipment[3];
		chestplate = equipment[4];
		helmet = equipment[5];
	}
	
	public byte getHeadYaw(){
		return yaw;
	}
	
	public void setHeadYaw(byte yaw){
		this.yaw = yaw;
		customYaw = true;
	}
	
	public void setHeadYaw(float yaw){
		this.yaw = (byte) ((yaw/180f)*128f);
		customYaw = true;
	}
	
	public void resetHeadYaw(){
		customYaw = false;
	}
	
	public boolean isHeadYawSet(){
		return customYaw;
	}
}