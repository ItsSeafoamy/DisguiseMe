package me.laxynd.disguiseme;

import static com.comphenix.protocol.PacketType.Play.Server.ENTITY_EQUIPMENT;
import static com.comphenix.protocol.PacketType.Play.Server.ENTITY_HEAD_ROTATION;
import static com.comphenix.protocol.PacketType.Play.Server.ENTITY_METADATA;
import static com.comphenix.protocol.PacketType.Play.Server.NAMED_ENTITY_SPAWN;
import static com.comphenix.protocol.PacketType.Play.Server.NAMED_SOUND_EFFECT;
import static com.comphenix.protocol.PacketType.Play.Server.PLAYER_INFO;
import static com.comphenix.protocol.PacketType.Play.Server.SPAWN_ENTITY_LIVING;
import static com.comphenix.protocol.PacketType.Play.Server.SPAWN_ENTITY;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import com.comphenix.packetwrapper.WrapperPlayServerEntityDestroy;
import com.comphenix.packetwrapper.WrapperPlayServerEntityEquipment;
import com.comphenix.packetwrapper.WrapperPlayServerEntityHeadRotation;
import com.comphenix.packetwrapper.WrapperPlayServerEntityMetadata;
import com.comphenix.packetwrapper.WrapperPlayServerNamedEntitySpawn;
import com.comphenix.packetwrapper.WrapperPlayServerNamedSoundEffect;
import com.comphenix.packetwrapper.WrapperPlayServerPlayerInfo;
import com.comphenix.packetwrapper.WrapperPlayServerSpawnEntity;
import com.comphenix.packetwrapper.WrapperPlayServerSpawnEntityLiving;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedDataWatcher.Registry;
import com.comphenix.protocol.wrappers.WrappedDataWatcher.Serializer;
import com.comphenix.protocol.wrappers.WrappedDataWatcher.WrappedDataWatcherObject;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedSignedProperty;
import com.google.common.base.Optional;
import me.laxynd.disguiseme.disguisetype.Disguise;
import me.laxynd.disguiseme.disguisetype.DisguiseAreaEffectCloud;
import me.laxynd.disguiseme.disguisetype.DisguiseArmorStand;
import me.laxynd.disguiseme.disguisetype.DisguiseArrow;
import me.laxynd.disguiseme.disguisetype.DisguiseBat;
import me.laxynd.disguiseme.disguisetype.DisguiseBlaze;
import me.laxynd.disguiseme.disguisetype.DisguiseBoat;
import me.laxynd.disguiseme.disguisetype.DisguiseCaveSpider;
import me.laxynd.disguiseme.disguisetype.DisguiseChicken;
import me.laxynd.disguiseme.disguisetype.DisguiseCow;
import me.laxynd.disguiseme.disguisetype.DisguiseCreeper;
import me.laxynd.disguiseme.disguisetype.DisguiseEnderCrystal;
import me.laxynd.disguiseme.disguisetype.DisguiseEnderDragon;
import me.laxynd.disguiseme.disguisetype.DisguiseEnderman;
import me.laxynd.disguiseme.disguisetype.DisguiseEndermite;
import me.laxynd.disguiseme.disguisetype.DisguiseFireball;
import me.laxynd.disguiseme.disguisetype.DisguiseFirework;
import me.laxynd.disguiseme.disguisetype.DisguiseGhast;
import me.laxynd.disguiseme.disguisetype.DisguiseGuardian;
import me.laxynd.disguiseme.disguisetype.DisguiseHorse;
import me.laxynd.disguiseme.disguisetype.DisguiseIronGolem;
import me.laxynd.disguiseme.disguisetype.DisguiseItem;
import me.laxynd.disguiseme.disguisetype.DisguiseItemFrame;
import me.laxynd.disguiseme.disguisetype.DisguiseLivingEntity;
import me.laxynd.disguiseme.disguisetype.DisguiseMagmaCube;
import me.laxynd.disguiseme.disguisetype.DisguiseMooshroom;
import me.laxynd.disguiseme.disguisetype.DisguiseOcelot;
import me.laxynd.disguiseme.disguisetype.DisguisePig;
import me.laxynd.disguiseme.disguisetype.DisguisePlayer;
import me.laxynd.disguiseme.disguisetype.DisguiseRabbit;
import me.laxynd.disguiseme.disguisetype.DisguiseSheep;
import me.laxynd.disguiseme.disguisetype.DisguiseShulker;
import me.laxynd.disguiseme.disguisetype.DisguiseSilverfish;
import me.laxynd.disguiseme.disguisetype.DisguiseSkeleton;
import me.laxynd.disguiseme.disguisetype.DisguiseSlime;
import me.laxynd.disguiseme.disguisetype.DisguiseSnowman;
import me.laxynd.disguiseme.disguisetype.DisguiseSpider;
import me.laxynd.disguiseme.disguisetype.DisguiseSquid;
import me.laxynd.disguiseme.disguisetype.DisguiseTippedArrow;
import me.laxynd.disguiseme.disguisetype.DisguiseVillager;
import me.laxynd.disguiseme.disguisetype.DisguiseWitch;
import me.laxynd.disguiseme.disguisetype.DisguiseWither;
import me.laxynd.disguiseme.disguisetype.DisguiseWitherSkull;
import me.laxynd.disguiseme.disguisetype.DisguiseWolf;
import me.laxynd.disguiseme.disguisetype.DisguiseZombie;
import me.laxynd.disguiseme.disguisetype.DisguiseZombiePigman;

public class DisguiseAPI {

	private static Hashtable<Integer, Disguise> disguises = new Hashtable<Integer, Disguise>();
	private static Hashtable<UUID, Integer> ids = new Hashtable<UUID, Integer>();
	private static Hashtable<EntityType, Class<? extends Disguise>> disguiseTypes = new Hashtable<EntityType, Class<? extends Disguise>>();

	public static void init(){
		registerDisguiseType(DisguiseAreaEffectCloud.class);
		registerDisguiseType(DisguiseArmorStand.class);
		registerDisguiseType(DisguiseArrow.class);
		registerDisguiseType(DisguiseBat.class);
		registerDisguiseType(DisguiseBlaze.class);
		registerDisguiseType(DisguiseBoat.class);
		registerDisguiseType(DisguiseCaveSpider.class);
		registerDisguiseType(DisguiseChicken.class);
		registerDisguiseType(DisguiseCow.class);
		registerDisguiseType(DisguiseCreeper.class);
		registerDisguiseType(DisguiseEnderCrystal.class);
		registerDisguiseType(DisguiseEnderDragon.class);
		registerDisguiseType(DisguiseEnderman.class);
		registerDisguiseType(DisguiseEndermite.class);
		registerDisguiseType(DisguiseFireball.class);
		registerDisguiseType(DisguiseFirework.class);
		registerDisguiseType(DisguiseGhast.class);
		registerDisguiseType(DisguiseGuardian.class);
		registerDisguiseType(DisguiseHorse.class);
		registerDisguiseType(DisguiseIronGolem.class);
		registerDisguiseType(DisguiseItem.class);
		registerDisguiseType(DisguiseItemFrame.class);
		registerDisguiseType(DisguiseMagmaCube.class);
		registerDisguiseType(DisguiseMooshroom.class);
		registerDisguiseType(DisguiseOcelot.class);
		registerDisguiseType(DisguisePig.class);
		registerDisguiseType(DisguisePlayer.class);
		registerDisguiseType(DisguiseRabbit.class);
		registerDisguiseType(DisguiseSheep.class);
		registerDisguiseType(DisguiseShulker.class);
		registerDisguiseType(DisguiseSilverfish.class);
		registerDisguiseType(DisguiseSkeleton.class);
		registerDisguiseType(DisguiseSlime.class);
		registerDisguiseType(DisguiseSnowman.class);
		registerDisguiseType(DisguiseSpider.class);
		registerDisguiseType(DisguiseSquid.class);
		registerDisguiseType(DisguiseTippedArrow.class);
		registerDisguiseType(DisguiseVillager.class);
		registerDisguiseType(DisguiseWitch.class);
		registerDisguiseType(DisguiseWither.class);
		registerDisguiseType(DisguiseWitherSkull.class);
		registerDisguiseType(DisguiseWolf.class);
		registerDisguiseType(DisguiseZombie.class);
		registerDisguiseType(DisguiseZombiePigman.class);

		ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

		protocolManager.addPacketListener(new PacketAdapter(DisguiseMe.plugin, ListenerPriority.NORMAL, SPAWN_ENTITY_LIVING, ENTITY_METADATA, NAMED_ENTITY_SPAWN, PLAYER_INFO, ENTITY_EQUIPMENT, ENTITY_HEAD_ROTATION, NAMED_SOUND_EFFECT){
			@SuppressWarnings("deprecation")
			@Override
			public void onPacketSending(final PacketEvent event) {
				if (event.getPacketType() == SPAWN_ENTITY_LIVING) {
					WrapperPlayServerSpawnEntityLiving packet = new WrapperPlayServerSpawnEntityLiving(event.getPacket());

					if (packet.getEntityID() == event.getPlayer().getEntityId()){
						return;
					}

					if (isDisguised(packet.getEntityID())){
						Disguise dis = getDisguise(packet.getEntityID());

						if (!(dis instanceof DisguisePlayer) && (dis instanceof DisguiseLivingEntity)){
							int id = packet.getEntityID();

							Entity e = getEntity(id);

							if (e == null){
								return;
							}

							EntityType type = e.getType();
							Disguise d = createDisguise(type);

							if (d == null){
								return;
							}

							dis.writeDefaults();

							WrappedDataWatcher watcher = getDefaultWatcher(dis.getEntityType(), event.getPlayer());

							for (Entry<Integer, Object> entry : dis.metadata.entrySet()){
								Serializer serializer = Registry.get(DataType.getClass(dis.dataTypes.get(entry.getKey())));

								Object value = entry.getValue();

								if (serializer.isOptional()){
									value = Optional.of(entry.getValue());
								}
								watcher.setObject(new WrappedDataWatcherObject(entry.getKey(), serializer), value);
							}

							packet.setMetadata(watcher);
							packet.setType(dis.getEntityType());
						} else if (dis instanceof DisguisePlayer){
							event.setCancelled(true);

							DisguisePlayer dp = (DisguisePlayer) dis;

							WrapperPlayServerPlayerInfo infoPacket = new WrapperPlayServerPlayerInfo();
							infoPacket.setAction(PlayerInfoAction.ADD_PLAYER);

							WrappedGameProfile profile = new WrappedGameProfile(dp.getUUID(), dp.getPlayerName());

							List<PlayerInfoData> data = new ArrayList<PlayerInfoData>();
							data.add(new PlayerInfoData(profile, 0, NativeGameMode.ADVENTURE, WrappedChatComponent.fromText(dp.getPlayerName())));

							infoPacket.setData(data);

							final WrapperPlayServerPlayerInfo removePacket = new WrapperPlayServerPlayerInfo();
							removePacket.setAction(PlayerInfoAction.REMOVE_PLAYER);
							removePacket.setData(data);

							WrapperPlayServerNamedEntitySpawn spawnPacket = new WrapperPlayServerNamedEntitySpawn();
							spawnPacket.setPlayerUUID(dp.getUUID());

							spawnPacket.setEntityID(packet.getEntityID());

							spawnPacket.setX(packet.getX());
							spawnPacket.setY(packet.getY());
							spawnPacket.setZ(packet.getZ());
							spawnPacket.setPitch(packet.getHeadPitch());
							spawnPacket.setYaw(packet.getYaw());

							WrapperPlayServerEntityEquipment held = new WrapperPlayServerEntityEquipment();
							held.setEntityID(packet.getEntityID());
							held.setSlot(0);

							WrapperPlayServerEntityEquipment offhand = new WrapperPlayServerEntityEquipment();
							offhand.setEntityID(packet.getEntityID());
							offhand.setSlot(1);

							WrapperPlayServerEntityEquipment boots = new WrapperPlayServerEntityEquipment();
							boots.setEntityID(packet.getEntityID());
							boots.setSlot(2);

							WrapperPlayServerEntityEquipment leggings = new WrapperPlayServerEntityEquipment();
							leggings.setEntityID(packet.getEntityID());
							leggings.setSlot(3);

							WrapperPlayServerEntityEquipment chestplate = new WrapperPlayServerEntityEquipment();
							chestplate.setEntityID(packet.getEntityID());
							chestplate.setSlot(4);

							WrapperPlayServerEntityEquipment helmet = new WrapperPlayServerEntityEquipment();
							helmet.setEntityID(packet.getEntityID());
							helmet.setSlot(5);

							infoPacket.sendPacket(event.getPlayer());
							spawnPacket.sendPacket(event.getPlayer());
							held.sendPacket(event.getPlayer());
							offhand.sendPacket(event.getPlayer());
							boots.sendPacket(event.getPlayer());
							leggings.sendPacket(event.getPlayer());
							chestplate.sendPacket(event.getPlayer());
							helmet.sendPacket(event.getPlayer());

							Bukkit.getScheduler().scheduleSyncDelayedTask(DisguiseMe.plugin, new Runnable(){
								@Override
								public void run(){
									removePacket.sendPacket(event.getPlayer());
								}
							}, 20);
						} else {
							event.setCancelled(true);

							WrapperPlayServerSpawnEntity spawnPacket = new WrapperPlayServerSpawnEntity();
							spawnPacket.setEntityID(packet.getEntityID());
							spawnPacket.setUUID(packet.getEntityUUID());
							spawnPacket.setPitch(packet.getHeadPitch());
							spawnPacket.setYaw(packet.getYaw());
							spawnPacket.setX(packet.getX());
							spawnPacket.setY(packet.getY());
							spawnPacket.setZ(packet.getZ());
							spawnPacket.setType(dis.getEntityType().getTypeId());
							spawnPacket.setObjectData(0);

							spawnPacket.sendPacket(event.getPlayer());
						}
					}
				} else if (event.getPacketType() == ENTITY_METADATA){
					WrapperPlayServerEntityMetadata packet = new WrapperPlayServerEntityMetadata(event.getPacket());

					if (packet.getEntityId() == event.getPlayer().getEntityId()){
						return;
					}

					if (isDisguised(packet.getEntityId())){
						Disguise dis = getDisguise(packet.getEntityId());

						int id = packet.getEntityId();
						Entity e = getEntity(id);

						if (e == null){
							return;
						}

						EntityType type = e.getType();
						Disguise d = createDisguise(type);

						if (d == null){
							return;
						}

						dis.writeDefaults();

						WrappedDataWatcher watcher = getDefaultWatcher(dis.getEntityType(), event.getPlayer());

						for (Entry<Integer, Object> entry : dis.metadata.entrySet()){
							Serializer serializer = Registry.get(DataType.getClass(dis.dataTypes.get(entry.getKey())));

							Object value = entry.getValue();

							if (serializer.isOptional()){
								value = Optional.of(entry.getValue());
							}
							watcher.setObject(new WrappedDataWatcherObject(entry.getKey(), serializer), value);
						}

						packet.setEntityMetadata(watcher.getWatchableObjects());
					}
				} else if (event.getPacketType() == NAMED_ENTITY_SPAWN){
					WrapperPlayServerNamedEntitySpawn packet = new WrapperPlayServerNamedEntitySpawn(event.getPacket());

					if (packet.getEntityID() == event.getPlayer().getEntityId()){
						return;
					}

					Entity e = getEntity(packet.getEntityID());

					if (e != null){
						if (isDisguised(packet.getEntityID())){
							Disguise dis = getDisguise(packet.getEntityID());

							if (!(dis instanceof DisguisePlayer) && dis instanceof DisguiseLivingEntity){
								dis.writeDefaults();

								WrapperPlayServerSpawnEntityLiving spawnPacket = new WrapperPlayServerSpawnEntityLiving();
								spawnPacket.setEntityID(packet.getEntityID());

								spawnPacket.setX(e.getLocation().getX());
								spawnPacket.setY(e.getLocation().getY());
								spawnPacket.setZ(e.getLocation().getZ());
								spawnPacket.setHeadPitch(e.getLocation().getPitch());
								spawnPacket.setYaw(e.getLocation().getYaw());

								spawnPacket.sendPacket(event.getPlayer());

								event.setCancelled(true);
							} else if (dis instanceof DisguisePlayer){
								DisguisePlayer d = (DisguisePlayer) dis;
								packet.setPlayerUUID(d.getUUID());
							} else {
								event.setCancelled(true);

								WrapperPlayServerSpawnEntity spawnPacket = new WrapperPlayServerSpawnEntity();

								spawnPacket.setEntityID(packet.getEntityID());
								spawnPacket.setUUID(packet.getPlayerUUID());
								spawnPacket.setX(e.getLocation().getX());
								spawnPacket.setY(e.getLocation().getY());
								spawnPacket.setZ(e.getLocation().getZ());
								spawnPacket.setPitch(e.getLocation().getPitch());
								spawnPacket.setYaw(e.getLocation().getYaw());
								spawnPacket.setType(dis.getEntityType().getTypeId());
								spawnPacket.setObjectData(0);

								spawnPacket.sendPacket(event.getPlayer());

								event.setCancelled(true);
							}
						}
					}
				} else if (event.getPacketType() == PLAYER_INFO){
					WrapperPlayServerPlayerInfo packet = new WrapperPlayServerPlayerInfo(event.getPacket());

					if (packet.getAction() == PlayerInfoAction.ADD_PLAYER){
						List<PlayerInfoData> datas = new ArrayList<PlayerInfoData>();

						for (PlayerInfoData data : packet.getData()){
							try {
								int entityid = ids.get(data.getProfile().getUUID());

								if (getDisguise(entityid) instanceof DisguisePlayer){
									DisguisePlayer dis = (DisguisePlayer) getDisguise(entityid);

									WrappedGameProfile profile = new WrappedGameProfile(dis.getUUID(), dis.getPlayerName());

									if (dis.getSkin() != null){
										Collection<WrappedSignedProperty> wsp = new ArrayList<WrappedSignedProperty>();
										wsp.add(new WrappedSignedProperty("textures", dis.getSkin().texture, dis.getSkin().signature));

										profile.getProperties().putAll("textures", wsp);
									}

									datas.add(new PlayerInfoData(profile, 0, NativeGameMode.ADVENTURE, WrappedChatComponent.fromText(dis.getPlayerName())));
								} else {
									datas.add(data);
								}
							} catch (Exception e){
								datas.add(data);
							}
						}

						packet.setData(datas);
					}
				} else if (event.getPacketType() == SPAWN_ENTITY){
					WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event.getPacket());

					if (packet.getEntityID() == event.getPlayer().getEntityId()){
						return;
					}

					Entity e = getEntity(packet.getEntityID());

					if (e == null) return;

					if (isDisguised(packet.getEntityID())){
						Disguise dis = getDisguise(packet.getEntityID());

						if (!(dis instanceof DisguisePlayer) && dis instanceof DisguiseLivingEntity){
							dis.writeDefaults();

							WrapperPlayServerSpawnEntityLiving spawnPacket = new WrapperPlayServerSpawnEntityLiving();
							spawnPacket.setEntityID(packet.getEntityID());

							spawnPacket.setX(e.getLocation().getX());
							spawnPacket.setY(e.getLocation().getY());
							spawnPacket.setZ(e.getLocation().getZ());
							spawnPacket.setHeadPitch(e.getLocation().getPitch());
							spawnPacket.setYaw(e.getLocation().getYaw());

							spawnPacket.sendPacket(event.getPlayer());

							event.setCancelled(true);
						} else if (dis instanceof DisguisePlayer){
							event.setCancelled(true);

							DisguisePlayer dp = (DisguisePlayer) dis;

							WrapperPlayServerPlayerInfo infoPacket = new WrapperPlayServerPlayerInfo();
							infoPacket.setAction(PlayerInfoAction.ADD_PLAYER);

							WrappedGameProfile profile = new WrappedGameProfile(dp.getUUID(), dp.getPlayerName());

							List<PlayerInfoData> data = new ArrayList<PlayerInfoData>();
							data.add(new PlayerInfoData(profile, 0, NativeGameMode.ADVENTURE, WrappedChatComponent.fromText(dp.getPlayerName())));

							infoPacket.setData(data);

							final WrapperPlayServerPlayerInfo removePacket = new WrapperPlayServerPlayerInfo();
							removePacket.setAction(PlayerInfoAction.REMOVE_PLAYER);
							removePacket.setData(data);

							WrapperPlayServerNamedEntitySpawn spawnPacket = new WrapperPlayServerNamedEntitySpawn();
							spawnPacket.setPlayerUUID(dp.getUUID());

							spawnPacket.setEntityID(packet.getEntityID());

							spawnPacket.setX(packet.getX());
							spawnPacket.setY(packet.getY());
							spawnPacket.setZ(packet.getZ());
							spawnPacket.setPitch(packet.getPitch());
							spawnPacket.setYaw(packet.getYaw());

							WrapperPlayServerEntityEquipment held = new WrapperPlayServerEntityEquipment();
							held.setEntityID(packet.getEntityID());
							held.setSlot(0);

							WrapperPlayServerEntityEquipment offhand = new WrapperPlayServerEntityEquipment();
							offhand.setEntityID(packet.getEntityID());
							offhand.setSlot(1);

							WrapperPlayServerEntityEquipment boots = new WrapperPlayServerEntityEquipment();
							boots.setEntityID(packet.getEntityID());
							boots.setSlot(2);

							WrapperPlayServerEntityEquipment leggings = new WrapperPlayServerEntityEquipment();
							leggings.setEntityID(packet.getEntityID());
							leggings.setSlot(3);

							WrapperPlayServerEntityEquipment chestplate = new WrapperPlayServerEntityEquipment();
							chestplate.setEntityID(packet.getEntityID());
							chestplate.setSlot(4);

							WrapperPlayServerEntityEquipment helmet = new WrapperPlayServerEntityEquipment();
							helmet.setEntityID(packet.getEntityID());
							helmet.setSlot(5);

							infoPacket.sendPacket(event.getPlayer());
							spawnPacket.sendPacket(event.getPlayer());
							held.sendPacket(event.getPlayer());
							offhand.sendPacket(event.getPlayer());
							boots.sendPacket(event.getPlayer());
							leggings.sendPacket(event.getPlayer());
							chestplate.sendPacket(event.getPlayer());
							helmet.sendPacket(event.getPlayer());

							Bukkit.getScheduler().scheduleSyncDelayedTask(DisguiseMe.plugin, new Runnable(){
								@Override
								public void run(){
									removePacket.sendPacket(event.getPlayer());
								}
							}, 20);
						} else {
							packet.setType(dis.getEntityType().getTypeId());
						}
					}					
				} else if (event.getPacketType() == ENTITY_EQUIPMENT){
					WrapperPlayServerEntityEquipment packet = new WrapperPlayServerEntityEquipment(event.getPacket());

					if (packet.getEntityID() == event.getPlayer().getEntityId()){
						return;
					}

					int id = packet.getEntityID();

					if (isDisguised(id)){
						if (getDisguise(id) instanceof DisguiseLivingEntity){
							DisguiseLivingEntity dis = (DisguiseLivingEntity) getDisguise(id);

							if (dis.getEquipment()[packet.getSlot()] != null){
								packet.setItem(dis.getEquipment()[packet.getSlot()]);
							} else {
								event.setCancelled(true);
							}
						} else {
							event.setCancelled(true);
						}
					}
				} else if (event.getPacketType() == ENTITY_HEAD_ROTATION){
					WrapperPlayServerEntityHeadRotation packet = new WrapperPlayServerEntityHeadRotation(event.getPacket());

					if (packet.getEntityID() == event.getPlayer().getEntityId()){
						return;
					}

					int id = packet.getEntityID();

					if (isDisguised(id)){
						if (getDisguise(id) instanceof DisguiseLivingEntity){
							DisguiseLivingEntity dis = (DisguiseLivingEntity) getDisguise(id);

							if (dis.isHeadYawSet())
								packet.setHeadYaw(dis.getHeadYaw());
						}
					}
				} else if (event.getPacketType() == NAMED_SOUND_EFFECT){
					WrapperPlayServerNamedSoundEffect packet = new WrapperPlayServerNamedSoundEffect(event.getPacket());

					int x = (int) (packet.getEffectPositionX()/8.0);
					int y = (int) (packet.getEffectPositionY()/8.0);
					int z = (int) (packet.getEffectPositionZ()/8.0);

					for (World w : Bukkit.getWorlds()){
						for (Entity e : w.getEntities()){
							int ex = (int) e.getLocation().getX();
							int ey = (int) e.getLocation().getY();
							int ez = (int) e.getLocation().getZ();

							if (x == ex && y == ey && z == ez){
								if (isDisguised(e.getEntityId())){
									Disguise dis = getDisguise(e.getEntityId());

									event.setCancelled(true);
									return;
									/*if (dis.getSound() == null){
										event.setCancelled(true);
										return;
									} else {
										packet.setSound(dis.getSound());
										event.setCancelled(true);
										return;
									}*/
								}
							}
						}
					}
				}
			}
		});
	} 

	private static Entity getEntity(int entityID){
		for (World w : Bukkit.getWorlds()){
			for (Entity e : w.getEntities()){
				if (e.getEntityId() == entityID){
					return e;
				}
			}
		}

		return null;
	}

	public static boolean isDisguised(int entityID){
		return disguises.containsKey(entityID);
	}

	public static Disguise getDisguise(int entityID){		
		return disguises.get(entityID);
	}

	@SuppressWarnings("deprecation")
	public static void disguise(int entityID, Disguise disguise){	
		Entity e = getEntity(entityID);

		if (e == null){
			return;
		}

		disguises.put(entityID, disguise);

		WrapperPlayServerEntityDestroy packet = new WrapperPlayServerEntityDestroy();
		packet.setEntities(new int[]{entityID});

		WrapperPlayServerEntityMetadata metaPacket = new WrapperPlayServerEntityMetadata();
		metaPacket.setEntityId(entityID);

		WrapperPlayServerEntityEquipment held = new WrapperPlayServerEntityEquipment();
		held.setEntityID(entityID);
		held.setSlot(0);

		WrapperPlayServerEntityEquipment offhand = new WrapperPlayServerEntityEquipment();
		offhand.setEntityID(entityID);
		offhand.setSlot(1);

		WrapperPlayServerEntityEquipment boots = new WrapperPlayServerEntityEquipment();
		boots.setEntityID(entityID);
		boots.setSlot(2);

		WrapperPlayServerEntityEquipment leggings = new WrapperPlayServerEntityEquipment();
		leggings.setEntityID(entityID);
		leggings.setSlot(3);

		WrapperPlayServerEntityEquipment chestplate = new WrapperPlayServerEntityEquipment();
		chestplate.setEntityID(entityID);
		chestplate.setSlot(4);

		WrapperPlayServerEntityEquipment helmet = new WrapperPlayServerEntityEquipment();
		helmet.setEntityID(entityID);
		helmet.setSlot(5);

		WrapperPlayServerEntityHeadRotation headPacket = new WrapperPlayServerEntityHeadRotation();
		headPacket.setEntityID(entityID);

		if (!(disguise instanceof DisguisePlayer) && disguise instanceof DisguiseLivingEntity){
			WrapperPlayServerSpawnEntityLiving spawnPacket = new WrapperPlayServerSpawnEntityLiving();
			spawnPacket.setEntityID(entityID);

			spawnPacket.setX(e.getLocation().getX());
			spawnPacket.setY(e.getLocation().getY());
			spawnPacket.setZ(e.getLocation().getZ());
			spawnPacket.setHeadPitch(e.getLocation().getPitch());
			spawnPacket.setYaw(e.getLocation().getYaw());
			spawnPacket.setEntityUUID(e.getUniqueId());

			for (Player p : Bukkit.getOnlinePlayers()){
				if (p.getEntityId() != entityID){
					packet.sendPacket(p);
					spawnPacket.sendPacket(p);
					metaPacket.sendPacket(p);
					held.sendPacket(p);
					offhand.sendPacket(p);
					boots.sendPacket(p);
					leggings.sendPacket(p);
					chestplate.sendPacket(p);
					helmet.sendPacket(p);
					headPacket.sendPacket(p);
				}
			}
		} else if (disguise instanceof DisguisePlayer){
			DisguisePlayer dis = (DisguisePlayer) disguise;

			ids.put(dis.getUUID(), entityID);

			WrapperPlayServerPlayerInfo infoPacket = new WrapperPlayServerPlayerInfo();
			infoPacket.setAction(PlayerInfoAction.ADD_PLAYER);

			WrappedGameProfile profile = new WrappedGameProfile(dis.getUUID(), dis.getPlayerName());

			List<PlayerInfoData> data = new ArrayList<PlayerInfoData>();
			data.add(new PlayerInfoData(profile, 0, NativeGameMode.ADVENTURE, WrappedChatComponent.fromText(dis.getPlayerName())));

			infoPacket.setData(data);

			WrapperPlayServerNamedEntitySpawn spawnPacket = new WrapperPlayServerNamedEntitySpawn();
			spawnPacket.setEntityID(entityID);
			spawnPacket.setPlayerUUID(dis.getUUID());

			spawnPacket.setX(e.getLocation().getX());
			spawnPacket.setY(e.getLocation().getY());
			spawnPacket.setZ(e.getLocation().getZ());
			spawnPacket.setPitch(e.getLocation().getPitch());
			spawnPacket.setYaw(e.getLocation().getYaw());

			final WrapperPlayServerPlayerInfo removePacket = new WrapperPlayServerPlayerInfo();
			removePacket.setAction(PlayerInfoAction.REMOVE_PLAYER);
			removePacket.setData(data);

			for (final Player p : Bukkit.getOnlinePlayers()){
				if (p.getEntityId() != entityID){
					packet.sendPacket(p);
					infoPacket.sendPacket(p);
					spawnPacket.sendPacket(p);
					metaPacket.sendPacket(p);
					held.sendPacket(p);
					boots.sendPacket(p);
					offhand.sendPacket(p);
					leggings.sendPacket(p);
					chestplate.sendPacket(p);
					helmet.sendPacket(p);
					headPacket.sendPacket(p);

					Bukkit.getScheduler().scheduleSyncDelayedTask(DisguiseMe.plugin, new Runnable(){
						@Override
						public void run(){
							removePacket.sendPacket(p);
						}
					}, 20);
				}
			}
		} else {
			WrapperPlayServerSpawnEntity spawnPacket = new WrapperPlayServerSpawnEntity();
			spawnPacket.setEntityID(entityID);
			spawnPacket.setUUID(e.getUniqueId());
			spawnPacket.setPitch(e.getLocation().getPitch());
			spawnPacket.setYaw(e.getLocation().getYaw());
			spawnPacket.setX(e.getLocation().getX());
			spawnPacket.setY(e.getLocation().getY());
			spawnPacket.setZ(e.getLocation().getZ());
			spawnPacket.setType(disguise.getEntityType().getTypeId());
			spawnPacket.setObjectData(0);

			for (Player p : Bukkit.getOnlinePlayers()){
				if (p.getEntityId() != entityID){
					spawnPacket.sendPacket(p);
				}
			}
		}
	}

	public static void update(int entityID){
		WrapperPlayServerEntityMetadata meta = new WrapperPlayServerEntityMetadata();
		meta.setEntityId(entityID);

		WrapperPlayServerEntityMetadata metaPacket = new WrapperPlayServerEntityMetadata();
		metaPacket.setEntityId(entityID);

		WrapperPlayServerEntityEquipment held = new WrapperPlayServerEntityEquipment();
		held.setEntityID(entityID);
		held.setSlot(0);

		WrapperPlayServerEntityEquipment offhand = new WrapperPlayServerEntityEquipment();
		offhand.setEntityID(entityID);
		offhand.setSlot(1);

		WrapperPlayServerEntityEquipment boots = new WrapperPlayServerEntityEquipment();
		boots.setEntityID(entityID);
		boots.setSlot(2);

		WrapperPlayServerEntityEquipment leggings = new WrapperPlayServerEntityEquipment();
		leggings.setEntityID(entityID);
		leggings.setSlot(3);

		WrapperPlayServerEntityEquipment chestplate = new WrapperPlayServerEntityEquipment();
		chestplate.setEntityID(entityID);
		chestplate.setSlot(4);

		WrapperPlayServerEntityEquipment helmet = new WrapperPlayServerEntityEquipment();
		helmet.setEntityID(entityID);
		helmet.setSlot(5);

		WrapperPlayServerEntityHeadRotation headPacket = new WrapperPlayServerEntityHeadRotation();
		headPacket.setEntityID(entityID);

		for (Player p : Bukkit.getOnlinePlayers()){
			if (p.getEntityId() != entityID){
				meta.sendPacket(p);
				held.sendPacket(p);
				offhand.sendPacket(p);
				boots.sendPacket(p);
				leggings.sendPacket(p);
				chestplate.sendPacket(p);
				helmet.sendPacket(p);
				headPacket.sendPacket(p);
			}
		}

		if (getDisguise(entityID) instanceof DisguisePlayer){
			DisguisePlayer dis = (DisguisePlayer) getDisguise(entityID);

			WrapperPlayServerPlayerInfo infoPacket = new WrapperPlayServerPlayerInfo();
			infoPacket.setAction(PlayerInfoAction.UPDATE_DISPLAY_NAME);

			WrappedGameProfile profile = new WrappedGameProfile(dis.getUUID(), dis.getPlayerName());

			List<PlayerInfoData> data = new ArrayList<PlayerInfoData>();
			data.add(new PlayerInfoData(profile, 0, NativeGameMode.ADVENTURE, WrappedChatComponent.fromText(dis.getPlayerName())));

			infoPacket.setData(data);

			for (Player p : Bukkit.getOnlinePlayers()){
				if (p.getEntityId() != entityID){
					infoPacket.sendPacket(p);
				}
			}
		}
	}

	public static void undisguise(final int entityID){
		Entity entity = getEntity(entityID);
		final Disguise dis = createDisguise(entity);
		disguise(entityID, dis);

		Bukkit.getScheduler().scheduleSyncDelayedTask(DisguiseMe.plugin, new Runnable(){
			@Override
			public void run(){
				if (getDisguise(entityID) == dis){
					disguises.remove(entityID);
				}
			}
		}, 10);
	}

	public static boolean registerDisguiseType(Class<? extends Disguise> clazz){
		try {
			Object obj = clazz.newInstance();
			EntityType type = (EntityType) clazz.getMethod("getEntityType").invoke(obj);
			disguiseTypes.put(type, clazz);
			return true;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static Disguise createDisguise(EntityType type){
		Class<? extends Disguise> clazz = disguiseTypes.get(type);

		if (clazz == null) throw new NotImplementedException("This entity type does not currently have a disuise type associated with it");

		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Disguise createDisguise(Entity entity){
		Disguise dis = createDisguise(entity.getType());
		dis.from(entity);
		return dis;
	}

	private static WrappedDataWatcher getDefaultWatcher(EntityType type, Player player) {
		if (type != EntityType.PLAYER){
			Entity entity = Bukkit.getWorlds().get(0).spawnEntity(new Location(Bukkit.getWorlds().get(0), 0, 256, 0), type);
			WrappedDataWatcher watcher = WrappedDataWatcher.getEntityWatcher(entity).deepClone();

			entity.remove();

			return watcher;
		} else {
			return WrappedDataWatcher.getEntityWatcher(player).deepClone();
		}
	}
}