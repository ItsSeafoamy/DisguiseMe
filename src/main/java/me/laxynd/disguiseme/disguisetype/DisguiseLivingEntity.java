package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BOOLEAN;
import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public abstract class DisguiseLivingEntity extends Disguise {
	
	public static final boolean MAIN_HAND = false;
	public static final boolean OFF_HAND = true;
	
	private ItemStack held, offhand, boots, leggings, chestplate, helmet;
	private byte yaw;
	private boolean customYaw;
	
	public DisguiseLivingEntity(){
		super();
		
		dataTypes.put(6, BYTE);
		dataTypes.put(7, FLOAT);
		dataTypes.put(8, VARINT);
		dataTypes.put(9, BOOLEAN);
		dataTypes.put(10, VARINT);
		
		set(7, 20f);
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
	
	public boolean isHandActive(){
		return getBitMask(6, 0x01);
	}
	
	public void setHandActive(boolean handActive){
		setBitMask(6, 0x01, handActive);
	}
	
	public boolean getActiveHand(){
		return getBitMask(6, 0x02);
	}
	
	public void setActiveHand(boolean activeHand){
		setBitMask(6, 0x01, activeHand);
	}
	
	public float getHealth(){
		return getFloat(7);
	}
	
	public void setHealth(float health){
		set(7, health);
	}
	
	public int getPotionEffectColor(){
		return getInteger(8);
	}
	
	public void setPotionEffectColor(int potionEffectColor){
		set(8, potionEffectColor);
	}
	
	public boolean isPotionEffectAmbient(){
		return getBoolean(9);
	}
	
	public void setPotionEffectAmbient(boolean potionEffectAmbient){
		set(9, potionEffectAmbient);
	}
	
	public int getNumberOfArrowsInEntity(){
		return getInteger(10);
	}
	
	public void setNumberOfArrowsInEntity(int numberOfArrowsInEntity){
		set(10, numberOfArrowsInEntity);
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