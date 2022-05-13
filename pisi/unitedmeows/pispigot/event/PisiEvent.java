package pisi.unitedmeows.pispigot.event;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.entity.Player;
import pisi.unitedmeows.eventapi.event.Event;


/*
    make this PisiPlayerPacketEvent
    and create a new event class with PacketEvent name and make this superclass of it
 */
public class PisiEvent extends Event {

    private boolean silentCancel;
    protected PacketEvent packetEvent;

    public PisiEvent(PacketEvent event) {
        packetEvent = event;
    }

    public void onCanceled() {
        player().getInventory().setHeldItemSlot(player().getInventory().getHeldItemSlot());
    }

    public PacketContainer packet() { return packetEvent.getPacket(); }
    public Player player() {
        return packetEvent.getPlayer();
    }

    public PisiEvent setSilentCancel(boolean _silentCancel) {
        silentCancel = _silentCancel;
        return this;
    }

    public boolean isSilentCanceled() {
        return silentCancel;
    }
}
