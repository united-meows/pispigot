package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

// this class wont have setters, setting keys will fuck it up
public class C01PacketEncryptionResponse extends PisiEvent {
	public static final PacketType TYPE = PacketType.Login.Client.ENCRYPTION_BEGIN;
	private byte[] secretKeyEncrypted = new byte[0];
	private byte[] verifyTokenEncrypted = new byte[0];

	public C01PacketEncryptionResponse(PacketEvent event) {
		super(event);
		secretKeyEncrypted = event.getPacket().getByteArrays().read(0);
		verifyTokenEncrypted = event.getPacket().getByteArrays().read(1);
	}

	public byte[] secretKey() {
		return secretKeyEncrypted;
	}

	public byte[] verifyToken() {
		return verifyTokenEncrypted;
	}
}
