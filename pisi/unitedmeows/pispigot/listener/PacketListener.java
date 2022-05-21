package pisi.unitedmeows.pispigot.listener;

import static com.comphenix.protocol.ProtocolLibrary.*;
import static com.comphenix.protocol.events.ListenerPriority.*;
import static java.lang.Class.*;
import static java.lang.String.valueOf;
import static java.util.Locale.*;
import static pisi.unitedmeows.pispigot.Pispigot.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.reflections.Reflections;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

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

	public static void startListening() {
		try {
			if (classes.isEmpty()) {
				System.out.println("wow thank you reflections.");
				return;
			}
			classes.forEach(class_ -> System.out.println(String.format("Loaded %s using reflection!", class_.getName())));
			for (Class<?> clazz : classes) {
				Type type = clazz.getAnnotation(Type.class);
				StringBuilder builder = new StringBuilder();
				String main = type.main();
				builder.append("com.comphenix.protocol.PacketType.");
				builder.append(valueOf(main.charAt(0)).toUpperCase(ENGLISH) + main.substring(1).toLowerCase(ENGLISH) + ".");
				builder.append(type.client() ? "Client" : "Server");
				Class<?> baseClass = forName("com.comphenix.protocol.PacketType");
				Class foundClass = null;
				for (Class<?> nested : baseClass.getClasses()) {
					for (Class<?> superNested : nested.getClasses()) {
						String canonicalName = superNested.getCanonicalName();
						if (canonicalName.equals(builder.toString())) {
							foundClass = superNested;
							break;
						}
					}
				}
				if (foundClass == null) {
					System.out.println("-------------------------------");
					System.out.println(builder.toString() + " is null.");
					break;
				}
				PacketType packetType = (PacketType) foundClass.getDeclaredField(type.finalType().toUpperCase(ENGLISH)).get(foundClass);
				System.out.println(clazz.getName() + " registered as " + Arrays.toString(packetType.getClassNames()));
				adapters.add(new PacketAdapter(self(), HIGHEST, packetType) {
					@Override
					public void onPacketReceiving(PacketEvent packetEvent) {
						try {
							PisiEvent pisiEvent = (PisiEvent) clazz.getDeclaredConstructor(packetEvent.getClass()).newInstance(packetEvent);
							playerSystem(packetEvent.getPlayer()).fire(pisiEvent);
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
					}
				});
			}
			adapters.forEach(getProtocolManager()::addPacketListener);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void stopListening() {
		adapters.forEach(getProtocolManager()::removePacketListener);
	}
}
