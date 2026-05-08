package net.trilleo.mc.plugins.trilobby.listeners.item

import net.trilleo.mc.plugins.trilobby.managers.GameManager
import net.trilleo.mc.plugins.trilobby.managers.MainItemManager
import net.trilleo.mc.plugins.trilobby.registration.GUIManager
import net.trilleo.mc.plugins.trilobby.utils.PDCUtil
import org.bukkit.NamespacedKey
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class MainItemListener(private val plugin: JavaPlugin) : Listener {
    // Detect join
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player

        GameManager(plugin).clearItem(player)
        MainItemManager(plugin).setMainItem(player)
    }

    // Detect interaction
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        val player = event.player
        val item = event.item ?: return

        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            if (PDCUtil.get(
                    item,
                    NamespacedKey(plugin, "itemIdentifier"),
                    PersistentDataType.STRING
                ) == "main-item"
            ) {
                GUIManager.open(player, "navigator")
                player.playSound(
                    player,
                    Sound.ENTITY_EXPERIENCE_ORB_PICKUP,
                    1.0f,
                    1.0f
                )
            }
        }
    }
}