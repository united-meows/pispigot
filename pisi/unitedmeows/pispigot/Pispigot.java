package pisi.unitedmeows.pispigot;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import pisi.unitedmeows.eventapi.system.BasicEventSystem;
import pisi.unitedmeows.pispigot.listener.PSTestListener;
import pisi.unitedmeows.pispigot.listener.PacketListener;

public class Pispigot extends JavaPlugin implements Listener {
	private static HashMap<Player, BasicEventSystem> playerEventSystems;
	private static BasicEventSystem serverEventSystem;
	private static Pispigot _self;

	@Override
	public void onEnable() {
		_self = this;
		playerEventSystems = new HashMap<>();
		serverEventSystem = new BasicEventSystem();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		PacketListener.startListening();
	}

	@Override
	public void onDisable() {
		playerEventSystems.clear();
		PacketListener.stopListening();
		super.onDisable();
	}

	/* only for debug */
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent event) {
		event.getPlayer().sendRawMessage("[DEBUG] Joined");
		playerSystem(event.getPlayer()).subscribeAll(new PSTestListener());
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		playerEventSystems.remove(event.getPlayer());
	}

	@EventHandler
	public void onKick(PlayerKickEvent event) {
		playerEventSystems.remove(event.getPlayer());
	}

	public static BasicEventSystem playerSystem(Player player) {
		return playerEventSystems.computeIfAbsent(player, k -> new BasicEventSystem());
	}

	public static Pispigot self() {
		return _self;
	}
}
