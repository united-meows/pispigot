package pisi.unitedmeows.pispigot.event.impl;

import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.inventory.ItemStack;
import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C99PacketPlayerBookEdit extends PisiEvent {

    public C99PacketPlayerBookEdit(PacketEvent event) {
        super(event);
    }

    public C99PacketPlayerBookEdit setNewBook(ItemStack item) {
        packet().getItemModifier().write(0, item);
        return this;
    }

    public ItemStack newBook() {
        return packet().getItemModifier().read(0);
    }

    public boolean isSigned() {
        return packet().getBooleans().read(0);
    }

    public C99PacketPlayerBookEdit setSigned(boolean state) {
        packet().getBooleans().write(0, state);
        return this;
    }
}
