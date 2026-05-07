package net.trilleo.mc.plugins.trilobby.listeners.player

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.potion.PotionEffectType

class PlayerLeaveListener : Listener {
    @EventHandler
    fun onPlayerLeave(event: PlayerQuitEvent) {
        event.quitMessage(null)
        event.player.removePotionEffect(PotionEffectType.SPEED)
        event.player.removePotionEffect(PotionEffectType.SATURATION)
    }
}