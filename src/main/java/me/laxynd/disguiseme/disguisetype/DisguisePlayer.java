package me.laxynd.disguiseme.disguisetype;

import static me.laxynd.disguiseme.DataType.BYTE;
import static me.laxynd.disguiseme.DataType.FLOAT;
import static me.laxynd.disguiseme.DataType.VARINT;
import java.util.UUID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import me.laxynd.disguiseme.SkinData;

public class DisguisePlayer extends DisguiseLivingEntity {
	
	public static final byte LEFT_HANDED = 0;
	public static final byte RIGHT_HANDED = 1;
	
	private String playerName;
	private UUID uuid;
	
	private SkinData skin;
	
	@Deprecated
	public DisguisePlayer(){
		this("Steve", UUID.randomUUID(), null);
	}
	
	public DisguisePlayer(String playerName){
		this(playerName, UUID.randomUUID(), null);
	}
	
	public DisguisePlayer(String playerName, UUID uuid){
		this(playerName, UUID.randomUUID(), null);
	}
	
	@Deprecated
	public DisguisePlayer(String playerName, String skin, String signature){
		this(playerName, UUID.randomUUID(), new SkinData(UUID.randomUUID(), playerName, skin, signature));
	}
	
	@Deprecated
	public DisguisePlayer(String playerName, UUID uuid, String skin, String signature){
		this(playerName, uuid, new SkinData(uuid, playerName, skin, signature));
	}
	
	public DisguisePlayer(String playerName, UUID uuid, SkinData skin){
		super();
		
		dataTypes.put(10, FLOAT);
		dataTypes.put(11, VARINT);
		dataTypes.put(12, BYTE);
		dataTypes.put(13, BYTE);
		
		this.playerName = playerName;
		this.uuid = uuid;
		this.skin = skin;
	}
	
	@Override
	public void from(Entity e){
		super.from(e);
		
		if (e instanceof Player){
			Player p = (Player) e;
			setSkinFlags((byte) 0xFF);
			setPlayerName(p.getName());
			setUUID(p.getUniqueId());
		} else throw new IllegalArgumentException();
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.PLAYER;
	}
	
	public float getAdditionalHearts(){
		return getFloat(10);
	}
	
	public void setAdditionalHearts(float additionalHearts){
		set(10, additionalHearts);
	}
	
	public int getScore(){
		return getInteger(11);
	}
	
	public void setScore(int score){
		set(11, score);
	}
	
	public byte getSkinFlags(){
		return getByte(12);
	}
	
	public void setSkinFlags(byte skinFlags){
		set(12, skinFlags);
	}
	
	public byte getMainHand(){
		return getByte(13);
	}
	
	public void setMainHand(byte mainHand){
		set(13, mainHand);
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	public UUID getUUID(){
		return uuid;
	}
	
	public void setUUID(UUID uuid){
		this.uuid = uuid;
	}
	
	public SkinData getSkin(){
		return skin;
	}
	
	public void setSkin(SkinData skin){
		this.skin = skin;
	}
}