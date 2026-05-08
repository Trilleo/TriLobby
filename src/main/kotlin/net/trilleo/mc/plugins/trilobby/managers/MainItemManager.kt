package net.trilleo.mc.plugins.trilobby.managers

import net.trilleo.mc.plugins.trilobby.Main
import net.trilleo.mc.plugins.trilobby.utils.itemStack
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class MainItemManager(private val plugin: JavaPlugin) {
    public fun setMainItem(player: Player) {
        val mainItem = itemStack(Material.COMPASS) {
            name("<bold><yellow>Navigator")
            lore(
                "   ",
                "<gray>[Right Click] to open menu"
            )
            enchant(Enchantment.KNOCKBACK, 1)
            flag(ItemFlag.HIDE_ENCHANTS)
            pdc(
                NamespacedKey(plugin, "itemIdentifier"),
                PersistentDataType.STRING,
                "main-item"
                )
        }

        val spawn = (plugin as Main).pluginConfig.getServerSpawn() ?: return
        player.compassTarget = spawn

        player.inventory.setItem(8, mainItem)
    }
}