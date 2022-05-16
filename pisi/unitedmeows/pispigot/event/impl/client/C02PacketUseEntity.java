package pisi.unitedmeows.pispigot.event.impl.client;

import java.util.List;

import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "use_entity")
public class C02PacketUseEntity extends PisiEvent {
	@Nullable
	private Entity entity;
	private EnumWrappers.EntityUseAction action;

	public C02PacketUseEntity(PacketEvent event) {
		super(event);
		int entityId = entityId();
		List<Entity> entities = player().getWorld().getEntities();
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			if (e.getEntityId() == entityId) {
				entity = e;
				break;
			}
		}
		action = event.getPacket().getEntityUseActions().read(0);
	}

	public EnumWrappers.EntityUseAction action() {
		return action;
	}

	@Nullable
	public Entity entity() {
		return entity;
	}

	public int entityId() {
		return packetEvent.getPacket().getIntegers().read(0);
	}
}
