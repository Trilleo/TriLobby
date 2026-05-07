package net.trilleo.mc.plugins.trilobby.listeners.player

import net.trilleo.mc.plugins.trilobby.Main
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

/**
 * Teleports every player to the configured server spawn point when they join.
 *
 * The spawn location is read from the `server-spawn` section of `config.yml`
 * via [Main.pluginConfig]. If the configured world is not loaded, the
 * teleport is silently skipped.
 */
class JoinSpawnListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val spawn = (plugin as Main).pluginConfig.getServerSpawn() ?: return
        event.player.teleport(spawn)
        event.joinMessage(null)
    }
}
