package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C11PacketEnchantItem extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.ENCHANT_ITEM;
	private int windowID;
	private int button;

	public C11PacketEnchantItem(PacketEvent event) {
		super(event);
		this.windowID = packet().getIntegers().read(0);
		this.button = packet().getIntegers().read(1);
	}

	public C11PacketEnchantItem windowID(int windowID_) {
		packet().getIntegers().write(0, windowID_);
		this.windowID = windowID_;
		return this;
	}

	public C11PacketEnchantItem button(int button_) {
		packet().getIntegers().write(1, button_);
		this.button = button_;
		return this;
	}

	public int button() {
		return button;
	}

	public int windowID() {
		return windowID;
	}
}
