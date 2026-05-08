package net.trilleo.mc.plugins.trilobby.managers

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class GameManager(private val plugin: JavaPlugin) {
    public fun clearItem(player: Player) {
        player.inventory.clear()
    }
}