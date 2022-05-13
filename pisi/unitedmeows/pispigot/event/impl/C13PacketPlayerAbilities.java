package pisi.unitedmeows.pispigot.event.impl;

import com.comphenix.protocol.events.PacketEvent;
import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C13PacketPlayerAbilities extends PisiEvent {

    public C13PacketPlayerAbilities(PacketEvent event) {
        super(event);
    }

    public boolean isInvulnerable() {
        return packet().getBooleans().read(0);
    }

    public boolean isFlying() {
        return packet().getBooleans().read(1);
    }

    public C13PacketPlayerAbilities setFlying(boolean value) {
        packet().getBooleans().write(1, value);
        return this;
    }

    public boolean canFly() {
        return packet().getBooleans().read(2);
    }

    public C13PacketPlayerAbilities setCanFly(boolean value) {
        packet().getBooleans().write(2, value);
        return this;
    }

    public boolean canInstantlyBuild() {
        return packet().getBooleans().read(3);
    }

    public C13PacketPlayerAbilities setCanInstantlyBuild(boolean value) {
        packet().getBooleans().write(3, value);
        return this;
    }

    public float getFlyingSpeed() {
        return packet().getFloat().read(0);
    }

    public C13PacketPlayerAbilities setFlyingSpeed(float value) {
        packet().getFloat().write(0, value);
        return this;
    }

    public float getWalkingSpeed() {
        return packet().getFloat().read(1);
    }

    public C13PacketPlayerAbilities setWalkingSpeed(float value) {
        packet().getFloat().write(1, value);
        return this;
    }


}
