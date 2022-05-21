package pisi.unitedmeows.pispigot.listener;

import pisi.unitedmeows.eventapi.event.listener.Listener;
import pisi.unitedmeows.pispigot.event.impl.client.C08PacketPlayerBlockPlacement;
import pisi.unitedmeows.pispigot.event.impl.client.C14PacketTabComplete;

public class PSTestListener {
	public Listener<C14PacketTabComplete> tabCompleteListener = new Listener<>(event -> {});
	public Listener<C08PacketPlayerBlockPlacement> placeListener = new Listener<>(
				event -> event.player().sendRawMessage(event.position() + " " + event.direction() + " " + event.cursorX() + " " + event.cursorY() + " " + event.cursorZ()));
}
