package pisi.unitedmeows.pispigot.event.impl;

import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Location;
import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C03PacketPlayer extends PisiEvent {

    protected boolean ground;
    protected float yaw, pitch;
    protected double posX, posY, posZ;
    protected C03Type type = C03Type.GROUND;

    public C03PacketPlayer(PacketEvent event) {
        super(event);

        ground = event.getPacket().getBooleans().read(0);
    }

    public boolean isLookUpdated() {
        return type == C03Type.LOOK || type == C03Type.LOOK_POS;
    }

    public boolean isPositionUpdated() {
        return type == C03Type.POS || type == C03Type.LOOK_POS;
    }

    public C03Type type() {
        return type;
    }

    public boolean isOnGround() {
        return ground;
    }

    public C03PacketPlayer setPosX(double _posX) {
        posX = _posX;
        packetEvent.getPacket().getDoubles().write(0, posX);
        return this;
    }

    public C03PacketPlayer setPosY(double _posY) {
        posY = _posY;
        packetEvent.getPacket().getDoubles().write(1, posY);
        return this;
    }

    public C03PacketPlayer setPosZ(double _posZ) {
        posZ = _posZ;
        packetEvent.getPacket().getDoubles().write(2, posZ);
        return this;
    }

    public C03PacketPlayer set(double _posX, double _posY, double _posZ) {
        setPosX(_posX);
        setPosY(_posY);
        setPosZ(_posZ);
        return this;
    }

    public double posX() {
        return posX;
    }

    public double posY() {
        return posY;
    }

    public double posZ() {
        return posZ;
    }


    @Override
    public void onCanceled() {
        Location location = player().getLocation();
        location.setYaw(yaw);
        location.setPitch(pitch);
        player().teleport(location);
    }

    public float yaw() {
        return yaw;
    }

    public float pitch() {
        return pitch;
    }

    public C03PacketPlayer setYaw(float _yaw) {
        yaw = _yaw;
        return this;
    }

    public C03PacketPlayer setPitch(float _pitch) {
        pitch = _pitch;
        return this;
    }

    public enum C03Type {
        GROUND,
        LOOK,
        POS,
        LOOK_POS,
    }
}
