package net.trilleo.mc.plugins.trilobby.commands.moderation

import net.trilleo.mc.plugins.trilobby.registration.PluginCommand
import net.trilleo.mc.plugins.trilobby.utils.MessageUtil
import net.trilleo.mc.plugins.trilobby.utils.sendPrefixed
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

/**
 * Reloads the plugin configuration from disk.
 *
 * Registered as `/trilobby reload` and requires the
 * `trilobby.reload` permission.
 */
class ReloadCommand(private val plugin: JavaPlugin) : PluginCommand(
    name = "reload",
    description = "Reload the plugin configuration",
    permission = "trilobby.reload"
) {
    override fun execute(sender: CommandSender, args: Array<out String>): Boolean {
        plugin.reloadConfig()
        val prefix = plugin.config.getString("message-prefix") ?: "[TriLobby]"
        MessageUtil.init(prefix)
        if (sender is Player) {
            sender.sendPrefixed("Configuration reloaded!")
        } else {
            sender.sendMessage("Configuration reloaded!")
        }
        return true
    }
}
