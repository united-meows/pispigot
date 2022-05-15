package pisi.unitedmeows.pispigot.listener;

import static com.comphenix.protocol.ProtocolLibrary.*;
import static com.comphenix.protocol.events.ListenerPriority.*;
import static pisi.unitedmeows.pispigot.Pispigot.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import org.reflections.Reflections;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.Pispigot;
import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.event.impl.client.C04PacketPlayerPosition;
import pisi.unitedmeows.pispigot.event.impl.client.C05PacketPlayerLook;
import pisi.unitedmeows.pispigot.event.impl.client.C06PacketPlayerPosLook;

/**
 * C00PacketServerQuery.java
 * C01PacketPing.java
 * C00Handshake.java
 * C00PacketLoginStart.java done
 * C01PacketEncryptionResponse.java done
 * C00PacketKeepAlive.java done
 * C01PacketChatMessage.java done
 * C02PacketUseEntity.java done
 * C03PacketPlayer.java done
 * C07PacketPlayerDigging.java done
 * C08PacketPlayerBlockPlacement.java done
 * C09PacketHeldItemChange.java done
 * C0APacketAnimation.java done
 * C0BPacketEntityAction.java
 * C0CPacketInput.java
 * C0DPacketCloseWindow.java
 * C0EPacketClickWindow.java
 * C0FPacketConfirmTransaction.java
 * C10PacketCreativeInventoryAction.java
 * C11PacketEnchantItem.java
 * C12PacketUpdateSign.java
 * C13PacketPlayerAbilities.java
 * C14PacketTabComplete.java
 * C15PacketClientSettings.java
 * C16PacketClientStatus.java
 * C17PacketCustomPayload.java
 * C18PacketSpectate.java
 * C19PacketResourcePackStatus.java
 */
public class PacketListener {
	private static Map<Class<? extends PisiEvent>, PacketType> map = new HashMap<>();
	private static List<PacketAdapter> adapters = new ArrayList<>();

	public static void startListening(boolean test) {
		try {
			Reflections reflections = new Reflections("pisi.unitedmeows.pispigot.event.impl.client");
			Set<Class<? extends PisiEvent>> classes = reflections.getSubTypesOf(PisiEvent.class);
			// these arent subtypes of pisievent i think so i hardcoded them
			classes.add(C04PacketPlayerPosition.class);
			classes.add(C05PacketPlayerLook.class);
			classes.add(C06PacketPlayerPosLook.class);
			for (Class<? extends PisiEvent> clazz : classes) {
				PacketType type = (PacketType) clazz.getDeclaredField("TYPE").get(clazz);
				adapters.add(new PacketAdapter(self(), HIGHEST, type) {
					@Override
					public void onPacketReceiving(PacketEvent packetEvent) {
						try {
							PisiEvent pisiEvent = clazz.getDeclaredConstructor(packetEvent.getClass()).newInstance(packetEvent);
							Pispigot.playerSystem(packetEvent.getPlayer()).fire(pisiEvent);
							if (pisiEvent.isCanceled()) {
								packetEvent.setCancelled(true);
								pisiEvent.onCanceled();
								return;
							}
							if (pisiEvent.isSilentCanceled()) {
								packetEvent.setCancelled(true);
							}
						}
						catch (InstantiationException
									| IllegalAccessException
									| IllegalArgumentException
									| InvocationTargetException
									| NoSuchMethodException
									| SecurityException e) {
							e.printStackTrace();
						}
						super.onPacketReceiving(packetEvent);
					}
				});
			}
			adapters.forEach(getProtocolManager()::addPacketListener);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void stopListening(boolean test) {
		adapters.forEach(getProtocolManager()::removePacketListener);
	}
}
