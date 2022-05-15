package pisi.unitedmeows.pispigot.event.impl.client;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerAction;

import pisi.unitedmeows.pispigot.event.PisiEvent;

/**
 * auxData is Horse Jump Power
 */
public class C0BPacketEntityAction extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.ENTITY_ACTION;
	private int entityID , auxData;
	private PlayerAction action;

	public C0BPacketEntityAction(PacketEvent event) {
		super(event);
		this.entityID = packet().getIntegers().read(0);
		this.auxData = packet().getIntegers().read(1);
		this.action = packet().getPlayerActions().read(0);
	}

	public int entityID() {
		return entityID;
	}

	/**
	 * auxData is Horse Jump Power
	 */
	public int auxData() {
		return auxData;
	}

	public PlayerAction action() {
		return action;
	}

	public C0BPacketEntityAction entityID(int id) {
		packet().getIntegers().write(0, id);
		this.entityID = id;
		return this;
	}

	/**
	 * auxData is Horse Jump Power
	 */
	public C0BPacketEntityAction auxData(int data) {
		packet().getIntegers().write(1, data);
		this.auxData = data;
		return this;
	}

	public C0BPacketEntityAction action(PlayerAction action) {
		packet().getPlayerActions().write(0, action);
		this.action = action;
		return this;
	}

	public Entity getEntity(World world) {
		return packet().getEntityModifier(world).read(0);
	}

	public Entity getEntity(Player player) {
		return packet().getEntityModifier(player.getWorld()).read(0);
	}
}
