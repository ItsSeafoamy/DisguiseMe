package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.VARINT;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;


public class DisguiseHorse extends DisguiseAbstractHorse {
	
	@Deprecated
	public static final byte HORSE = 0;
	@Deprecated
	public static final byte DONKEY = 1;
	@Deprecated
	public static final byte MULE = 2;
	@Deprecated
	public static final byte ZOMBIE = 3;
	@Deprecated
	public static final byte SKELETON = 4;
	
	public static final int COLOR_WHITE = 0;
	public static final int COLOR_CREAMY = 1;
	public static final int COLOR_CHESTNUT = 2;
	public static final int COLOR_BROWN = 3;
	public static final int COLOR_BLACK = 4;
	public static final int COLOR_GRAY = 5;
	public static final int COLOR_DARK_BROWN = 6;
	
	public static final int STYLE_NONE = 0;
	public static final int STYLE_WHITE = 1;
	public static final int STYLE_WHITEFIELD = 2;
	public static final int STYLE_WHITE_DOTS = 3;
	public static final int STYLE_BLACK_DOTS = 4;
	
	public static final int ARMOR_NONE = 0;
	public static final int ARMOR_IRON = 1;
	public static final int ARMOR_GOLD = 2;
	public static final int ARMOR_DIAMOND = 3;

	public DisguiseHorse(){
		super();

		dataTypes.put(15, VARINT);
		dataTypes.put(16, VARINT);
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Horse){
			Horse h = (Horse) e;
			setTamed(h.isTamed());
			setSaddle(h.getInventory().getSaddle() != null);
			setBred(!h.canBreed());
			setColor(h.getColor().ordinal());
			setStyle((byte) h.getStyle().ordinal());
			setArmorMaterial(h.getInventory().getArmor() == null ? null : h.getInventory().getArmor().getType());
		} else throw new IllegalArgumentException();
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.HORSE;
	}
	
	@Override
	public Sound getSound(){
		return Sound.ENTITY_HORSE_AMBIENT;
	}	
	
	public int getVariant(){
		return getInteger(15);
	}
	
	public void setVariant(int variant){
		set(15, variant);
	}
	
	public int getColor(){
		return getInteger(15) & 0x00FF;
	}
	
	public void setColor(int color){
		set(14, (getInteger(15) & 0xFF00) + color);
	}
	
	public int getStyle(){
		return (getInteger(15) & 0xFF00) >> 8;
	}
	
	public void setStyle(int style){
		set(15, getColor() + (style << 8));
	}
	
	public int getArmor(){
		return getInteger(16);
	}
	
	public void setArmor(int armor){
		set(16, armor);
	}
	
	public Material getArmorMaterial(){
		if (getArmor() == 0) return null;
		else if (getArmor() == 1) return Material.IRON_BARDING;
		else if (getArmor() == 2) return Material.GOLD_BARDING;
		else if (getArmor() == 3) return Material.DIAMOND_BARDING;
		else return null;
	}
	
	public void setArmorMaterial(Material mat){
		if (mat == Material.IRON_BARDING) set(16, 1);
		else if (mat == Material.GOLD_BARDING) set(16, 2);
		else if (mat == Material.DIAMOND_BARDING) set(16, 3);
		else set(16, 0);
	}
}