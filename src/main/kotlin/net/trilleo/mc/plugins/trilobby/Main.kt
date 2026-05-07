package net.trilleo.mc.plugins.trilobby

import net.trilleo.mc.plugins.trilobby.config.PluginConfig
import net.trilleo.mc.plugins.trilobby.data.PlayerDataManager
import net.trilleo.mc.plugins.trilobby.data.ServerDataManager
import net.trilleo.mc.plugins.trilobby.registration.CommandRegistrar
import net.trilleo.mc.plugins.trilobby.registration.GUIManager
import net.trilleo.mc.plugins.trilobby.registration.ListenerRegistrar
import net.trilleo.mc.plugins.trilobby.registration.PermissionRegistrar
import net.trilleo.mc.plugins.trilobby.utils.MessageUtil
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    /** Typed configuration wrapper – available after [onEnable]. */
    lateinit var pluginConfig: PluginConfig
        private set

    override fun onEnable() {
        pluginConfig = PluginConfig(this)
        MessageUtil.init(pluginConfig.messagePrefix)

        ServerDataManager.init(this)
        PlayerDataManager.init(this)

        CommandRegistrar.registerAll(this)
        PermissionRegistrar.registerAll(this)
        ListenerRegistrar.registerAll(this)
        GUIManager.registerAll(this)

        logger.info("TriLobby enabled!")
    }

    override fun onDisable() {
        PlayerDataManager.saveAll()
        ServerDataManager.save()

        logger.info("TriLobby disabled!")
    }
}
