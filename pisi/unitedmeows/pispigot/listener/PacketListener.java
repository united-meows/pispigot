package pisi.unitedmeows.pispigot.listener;

import static com.comphenix.protocol.ProtocolLibrary.*;
import static com.comphenix.protocol.events.ListenerPriority.*;
import static pisi.unitedmeows.pispigot.Pispigot.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.reflections.Reflections;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.Pispigot;
import pisi.unitedmeows.pispigot.event.PisiEvent;

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
	private static List<PacketAdapter> adapters = new ArrayList<>();
	private static List<Class<? extends PisiEvent>> classes = new ArrayList<>();
	static {
		try {
			Reflections reflections = new Reflections("pisi.unitedmeows.pispigot.event.impl.client");
			reflections.getSubTypesOf(PisiEvent.class).forEach(classes::add);
		}
		catch (Exception e) {
			try {
				// FUCKING SPIGOT
				Reflections reflections = new Reflections("pisi.unitedmeows.pispigot.event.impl.client\u0000");
				reflections.getSubTypesOf(PisiEvent.class).forEach(classes::add);
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void startListening(boolean test) {
		try {
			if (classes.isEmpty()) {
				System.out.println("wow thank you reflections.");
				return;
			}
			classes.forEach(class_ -> System.out.println(String.format("Loaded %s using reflection!", class_.getName())));
			for (Class<?> clazz : classes) {
				PacketType type = (PacketType) clazz.getDeclaredField("TYPE").get(clazz);
				System.out.println(clazz.getName() + " registered as " + Arrays.toString(type.getClassNames()));
				adapters.add(new PacketAdapter(self(), HIGHEST, type) {
					@Override
					public void onPacketReceiving(PacketEvent packetEvent) {
						try {
							PisiEvent pisiEvent = (PisiEvent) clazz.getDeclaredConstructor(packetEvent.getClass()).newInstance(packetEvent);
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
						catch (Exception e) {
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
