package net.trilleo.mc.plugins.trilobby.guis

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import net.trilleo.mc.plugins.trilobby.enums.FillMode
import net.trilleo.mc.plugins.trilobby.registration.PluginGUI
import net.trilleo.mc.plugins.trilobby.utils.itemStack
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.plugin.java.JavaPlugin

class NavigatorUI(plugin: JavaPlugin) : PluginGUI(
    id = "navigator",
    title = Component.text("TriUniverse Navigator").color(NamedTextColor.GOLD).decorate(TextDecoration.BOLD),
    rows = 6,
    fillMode = FillMode.LIGHT
) {
    val slotIndex: Map<String, Int> = mapOf(
        "closeButtonSlot" to 49
    )
    val gameIndex: Map<String, Int> = mapOf(
        "smpButtonSlot" to 22
    )

    fun setupGameButtons(inventory: Inventory) {
        val smpButton = itemStack(Material.DIAMOND_PICKAXE) {
            name("<bold><dark_green>TriUniverse SMP")
            lore(
                "   ",
                "<gray>The vanilla survival experience"
            )
            enchant(Enchantment.KNOCKBACK, 1)
            flag(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES)
        }

        inventory.setItem(gameIndex.getValue("smpButtonSlot"), smpButton)
    }

    override fun setup(player: Player, inventory: Inventory) {
        val closeButton = itemStack(Material.BARRIER) {
            name("<red>Close")
        }

        inventory.setItem(slotIndex.getValue("closeButtonSlot"), closeButton)
        setupGameButtons(inventory)
    }

    override fun onClick(event: InventoryClickEvent) {
        event.isCancelled = true
        val player = event.whoClicked as Player

        if (event.slot in slotIndex.values) {
            player.playSound(
                player,
                Sound.UI_BUTTON_CLICK,
                SoundCategory.MASTER,
                1.0f,
                1.0f
            )
        }
        if (event.slot in gameIndex.values) {
            player.playSound(
                player,
                Sound.ENTITY_EXPERIENCE_ORB_PICKUP,
                SoundCategory.MASTER,
                1.0f,
                1.0f
            )
        }

        if (event.slot == slotIndex.getValue("closeButtonSlot")) {
            player.closeInventory()
        }

        if (event.slot == gameIndex.getValue("smpButtonSlot")) {
            player.performCommand("/server smp")
        }
    }
}