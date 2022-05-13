package pisi.unitedmeows.pispigot.event.impl;

import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.entity.Entity;
import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C02PacketUseEntity extends PisiEvent {

    @Nullable
    private Entity entity;
    private EnumWrappers.EntityUseAction action;

    public C02PacketUseEntity(PacketEvent event) {
        super(event);

        int entityId = entityId();
        for (Entity e : player().getWorld().getEntities()) {
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
