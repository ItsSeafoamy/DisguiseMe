package me.laxynd.disguiseme;

import java.util.Hashtable;
import java.util.UUID;
import org.json.simple.JSONObject;

public class SkinData {
	
	public final UUID uuid;
	public final String name, texture, signature;
	
	private static Hashtable<UUID, SkinData> cache = new Hashtable<UUID, SkinData>();
	
	public SkinData(String texture, String signature){
		this(UUID.randomUUID(), "null", texture, signature);
	}
	
	public SkinData(UUID uuid, String name, String texture, String signature){
		this.uuid = uuid;
		this.name = name;
		this.texture = texture;
		this.signature = signature;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject toJSON(){
		JSONObject json = new JSONObject();
		
		json.put("uuid", uuid.toString());
		json.put("name", name);
		json.put("texture", texture);
		json.put("signature", signature);
		
		return json;
	}
	
	public void cache(){
		cache.put(uuid, this);
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof SkinData){
			SkinData other = (SkinData) o;
			
			return other.texture.equals(texture) && other.signature.equals(signature);
		}
		return false;
	}
	
	public String toID(){
		return texture.replaceAll("(.)", "§$1");
	}
	
	public static SkinData fromJSON(JSONObject json){
		return new SkinData(UUID.fromString((String) json.get("uuid")), (String) json.get("name"), (String) json.get("texture"), (String) json.get("signature"));		
	}
	
	public static SkinData getCached(UUID uuid){
		return cache.get(uuid);
	}
}