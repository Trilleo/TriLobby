package net.trilleo.mc.plugins.trilobby.listeners.player

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.trilleo.mc.plugins.trilobby.Main
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.plugin.java.JavaPlugin

/**
 * Teleports a player back to the configured server spawn point when they fall
 * below Y = [VOID_Y_THRESHOLD] (out of the world / into the void).
 *
 * The teleport only triggers when the player crosses the threshold downward
 * (i.e. `from.y >= threshold` and `to.y < threshold`), preventing repeated
 * teleport calls while the player is already in the void.
 *
 * The spawn location is read from the `server-spawn` section of `config.yml`
 * via [Main.pluginConfig]. If the configured world is not loaded, the
 * teleport is silently skipped.
 */
class VoidTeleportListener(private val plugin: JavaPlugin) : Listener {

    companion object {
        private const val VOID_Y_THRESHOLD = -64.0
    }

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (event.from.y < VOID_Y_THRESHOLD || event.to.y >= VOID_Y_THRESHOLD) return
        val spawn = (plugin as Main).pluginConfig.getServerSpawn() ?: return
        event.player.teleport(spawn)
        event.player.sendMessage(Component.text("You fell out of the world!").color(NamedTextColor.RED))
    }
}
