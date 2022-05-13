package pisi.unitedmeows.pispigot.listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import pisi.unitedmeows.pispigot.Pispigot;
import pisi.unitedmeows.pispigot.event.impl.*;

public class PacketListener {


    private static final PacketAdapter heldItemPacket = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.HELD_ITEM_SLOT) {
        public void onPacketReceiving(PacketEvent event) {
            C09PacketHeldItemChange heldItemChange = new C09PacketHeldItemChange(event);

            Pispigot.playerSystem(event.getPlayer()).fire(heldItemChange);

            if (heldItemChange.isCanceled()) {
                event.setCancelled(true);
                heldItemChange.onCanceled();
                return;
            }

            if (heldItemChange.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter swingListener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.ARM_ANIMATION) {
        public void onPacketReceiving(PacketEvent event) {
            C0APacketAnimation swingAnim = new C0APacketAnimation(event);
            Pispigot.playerSystem(event.getPlayer()).fire(swingAnim);
            if (swingAnim.isCanceled()) {
                event.setCancelled(true);
                swingAnim.onCanceled();
                return;
            }

            if (swingAnim.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter chatListener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.CHAT) {
        public void onPacketReceiving(PacketEvent event) {
            C01PacketChat chatPacket = new C01PacketChat(event);
            Pispigot.playerSystem(event.getPlayer()).fire(chatPacket);

            if (chatPacket.isCanceled()) {
                event.setCancelled(true);
                chatPacket.onCanceled();
                return;
            }

            if (chatPacket.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter useEntityListener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.USE_ENTITY) {
        public void onPacketReceiving(PacketEvent event) {
            C02PacketUseEntity useEntity = new C02PacketUseEntity(event);
            Pispigot.playerSystem(event.getPlayer()).fire(useEntity);

            if (useEntity.isCanceled()) {
                event.setCancelled(true);
                useEntity.onCanceled();
                return;
            }

            if (useEntity.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter c03listener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.FLYING) {
        public void onPacketReceiving(PacketEvent event) {
            C03PacketPlayer c03packet = new C03PacketPlayer(event);
            Pispigot.playerSystem(event.getPlayer()).fire(c03packet);

            if (c03packet.isCanceled()) {
                event.setCancelled(true);
                c03packet.onCanceled();
                return;
            }

            if (c03packet.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter c04listener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.POSITION) {
        public void onPacketReceiving(PacketEvent event) {
            C04PacketPlayerPosition c04packet = new C04PacketPlayerPosition(event);
            Pispigot.playerSystem(event.getPlayer()).fire(c04packet);

            if (c04packet.isCanceled()) {
                event.setCancelled(true);
                c04packet.onCanceled();
                return;
            }

            if (c04packet.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter c05listener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.LOOK) {
        public void onPacketReceiving(PacketEvent event) {
            C05PacketPlayerLook c05packet = new C05PacketPlayerLook(event);
            Pispigot.playerSystem(event.getPlayer()).fire(c05packet);

            if (c05packet.isCanceled()) {
                event.setCancelled(true);
                c05packet.onCanceled();
                return;
            }

            if (c05packet.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter c06listener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.POSITION_LOOK) {
        public void onPacketReceiving(PacketEvent event) {
            C06PacketPlayerPosLook c06packet = new C06PacketPlayerPosLook(event);
            Pispigot.playerSystem(event.getPlayer()).fire(c06packet);

            if (c06packet.isCanceled()) {
                event.setCancelled(true);
                c06packet.onCanceled();
                return;
            }

            if (c06packet.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter bookeditlistener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.B_EDIT) {
        public void onPacketReceiving(PacketEvent event) {
            C99PacketPlayerBookEdit bookEditPacket = new C99PacketPlayerBookEdit(event);
            Pispigot.playerSystem(event.getPlayer()).fire(bookEditPacket);

            if (bookEditPacket.isCanceled()) {
                event.setCancelled(true);
                bookEditPacket.onCanceled();
                return;
            }

            if (bookEditPacket.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter playerabilitieslistener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.ABILITIES) {
        public void onPacketReceiving(PacketEvent event) {
            C13PacketPlayerAbilities playerabilities = new C13PacketPlayerAbilities(event);
            Pispigot.playerSystem(event.getPlayer()).fire(playerabilities);

            if (playerabilities.isCanceled()) {
                event.setCancelled(true);
                playerabilities.onCanceled();
                return;
            }

            if (playerabilities.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter playersteerlistener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.STEER_VEHICLE) {
        public void onPacketReceiving(PacketEvent event) {
            C0CPacketInput c0CPacketInput = new C0CPacketInput(event);
            Pispigot.playerSystem(event.getPlayer()).fire(c0CPacketInput);

            if (c0CPacketInput.isCanceled()) {
                event.setCancelled(true);
                c0CPacketInput.onCanceled();
                return;
            }

            if (c0CPacketInput.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter playertabcomplete = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.TAB_COMPLETE) {
        public void onPacketReceiving(PacketEvent event) {
            C14PacketTabComplete tabComplete = new C14PacketTabComplete(event);
            Pispigot.playerSystem(event.getPlayer()).fire(tabComplete);

            if (tabComplete.isCanceled()) {
                event.setCancelled(true);
                tabComplete.onCanceled();
                return;
            }

            if (tabComplete.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };

    private static final PacketAdapter c08listener = new PacketAdapter(Pispigot.self(), ListenerPriority.HIGHEST, PacketType.Play.Client.BLOCK_PLACE) {
        public void onPacketReceiving(PacketEvent event) {
            C08PacketPlayerBlockPlacement placePacket = new C08PacketPlayerBlockPlacement(event);
            Pispigot.playerSystem(event.getPlayer()).fire(placePacket);

            if (placePacket.isCanceled()) {
                event.setCancelled(true);
                placePacket.onCanceled();
                return;
            }

            if (placePacket.isSilentCanceled()) {
                event.setCancelled(true);
            }
        }
    };




    // :DDD no to reflections :D
    public static void startListening() {
        ProtocolLibrary.getProtocolManager().addPacketListener(heldItemPacket);
        ProtocolLibrary.getProtocolManager().addPacketListener(swingListener);
        ProtocolLibrary.getProtocolManager().addPacketListener(chatListener);
        ProtocolLibrary.getProtocolManager().addPacketListener(useEntityListener);
        ProtocolLibrary.getProtocolManager().addPacketListener(c03listener);
        ProtocolLibrary.getProtocolManager().addPacketListener(c04listener);
        ProtocolLibrary.getProtocolManager().addPacketListener(c05listener);
        ProtocolLibrary.getProtocolManager().addPacketListener(c06listener);
        ProtocolLibrary.getProtocolManager().addPacketListener(bookeditlistener);
        ProtocolLibrary.getProtocolManager().addPacketListener(playerabilitieslistener);
        ProtocolLibrary.getProtocolManager().addPacketListener(playersteerlistener);
        ProtocolLibrary.getProtocolManager().addPacketListener(playertabcomplete);
        ProtocolLibrary.getProtocolManager().addPacketListener(c08listener);
    }

    public static void stopListening() {
        ProtocolLibrary.getProtocolManager().removePacketListener(heldItemPacket);
        ProtocolLibrary.getProtocolManager().removePacketListener(swingListener);
        ProtocolLibrary.getProtocolManager().removePacketListener(chatListener);
        ProtocolLibrary.getProtocolManager().removePacketListener(useEntityListener);
        ProtocolLibrary.getProtocolManager().removePacketListener(c03listener);
        ProtocolLibrary.getProtocolManager().removePacketListener(c04listener);
        ProtocolLibrary.getProtocolManager().removePacketListener(c05listener);
        ProtocolLibrary.getProtocolManager().removePacketListener(c06listener);
        ProtocolLibrary.getProtocolManager().removePacketListener(bookeditlistener);
        ProtocolLibrary.getProtocolManager().removePacketListener(playerabilitieslistener);
        ProtocolLibrary.getProtocolManager().removePacketListener(playersteerlistener);
        ProtocolLibrary.getProtocolManager().removePacketListener(playertabcomplete);
        ProtocolLibrary.getProtocolManager().removePacketListener(c08listener);
    }
}
