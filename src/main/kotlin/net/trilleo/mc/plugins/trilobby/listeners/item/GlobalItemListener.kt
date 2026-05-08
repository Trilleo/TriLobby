package net.trilleo.mc.plugins.trilobby.listeners.item

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.plugin.java.JavaPlugin

class GlobalItemListener(private val plugin: JavaPlugin) : Listener {
    // Detect inventory click
    @EventHandler
    fun onClick(event: InventoryClickEvent) {
        val player = event.whoClicked as Player
        if (player.isOp) return

        if (event.clickedInventory?.holder == player) event.isCancelled = true
    }

    // Detect item drop
    @EventHandler
    fun onDrop(event: PlayerDropItemEvent) {
        val player = event.player
        if (player.isOp) return

        event.isCancelled = true
    }
}