package net.trilleo.mc.plugins.trilobby.listeners.player

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerLeaveListener : Listener {
    @EventHandler
    fun onPlayerLeave(event: PlayerQuitEvent) {
        event.quitMessage(null)
    }
}