package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

// this class wont have setters, setting keys will fuck it up
@Type(main = "login" , client = true , finalType = "encryption_begin")
public class C01PacketEncryptionResponse extends PisiEvent {
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
