package pisi.unitedmeows.pispigot.event.impl;

import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C08PacketPlayerBlockPlacement extends PisiEvent
{
    public C08PacketPlayerBlockPlacement(PacketEvent event) {
        super(event);
    }

    public BlockPosition position() {
        return packet().getBlockPositionModifier().read(0);
    }
    public int direction() { return packet().getIntegers().read(0); }

    public ItemStack heldItem() { return packet().getItemModifier().read(0); }

    public float cursorX() { return packet().getFloat().read(0); }
    public float cursorY() { return packet().getFloat().read(1); }
    public float cursorZ() { return packet().getFloat().read(2); }

    public C08PacketPlayerBlockPlacement setDirection(int direction) {
        packet().getIntegers().write(3, direction);
        return this;
    }

    public C08PacketPlayerBlockPlacement setItem(ItemStack item) {
        packet().getItemModifier().write(0, item);
        return this;
    }

    public C08PacketPlayerBlockPlacement setCursorX(float x) {
        packet().getFloat().write(0, x);
        return this;
    }

    public C08PacketPlayerBlockPlacement setCursorY(float y) {
        packet().getFloat().write(0, y);
        return this;
    }

    public C08PacketPlayerBlockPlacement setCursorZ(float z) {
        packet().getFloat().write(2, z);
        return this;
    }
}
