package net.trilleo.mc.plugins.trilobby.config

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin

/**
 * A typed wrapper around the plugin's `config.yml`.
 *
 * On construction the default configuration is saved (if the file does not
 * yet exist) and the current values are loaded into memory. Call [reload]
 * to re-read the file at runtime without restarting the server.
 *
 * @param plugin the owning plugin instance
 */
class PluginConfig(private val plugin: JavaPlugin) {

    /** The currently loaded Bukkit [FileConfiguration]. */
    private var config: FileConfiguration

    init {
        plugin.saveDefaultConfig()
        config = plugin.config
    }

    /**
     * Re-reads `config.yml` from disk, picking up any changes made since
     * the last load.
     */
    fun reload() {
        plugin.reloadConfig()
        config = plugin.config
    }

    // ── Plugin Properties ────────────────────────────────────────────────

    /**
     * The prefix shown before plugin messages. Taken from the `message-prefix`
     * key in `config.yml`.
     */
    val messagePrefix: String
        get() = getString("message-prefix", "[TriLobby]")

    /**
     * Returns the server spawn [Location] built from the `server-spawn` section
     * of `config.yml`, or `null` when the configured world cannot be found.
     */
    fun getServerSpawn(): Location? {
        val worldName = getString("server-spawn.world", "world")
        val world = Bukkit.getWorld(worldName) ?: return null
        val x = getDouble("server-spawn.x", 0.0)
        val y = getDouble("server-spawn.y", 64.0)
        val z = getDouble("server-spawn.z", 0.0)
        val yaw = getDouble("server-spawn.yaw", 0.0).toFloat()
        val pitch = getDouble("server-spawn.pitch", 0.0).toFloat()
        return Location(world, x, y, z, yaw, pitch)
    }

    // ── Typed Getters ───────────────────────────────────────────────────

    /**
     * Returns the [String] value at [path], or [default] when the key is
     * absent or not a string.
     */
    fun getString(path: String, default: String = ""): String =
        config.getString(path, default) ?: default

    /**
     * Returns the [Int] value at [path], or [default] when the key is
     * absent or not an integer.
     */
    fun getInt(path: String, default: Int = 0): Int =
        config.getInt(path, default)

    /**
     * Returns the [Double] value at [path], or [default] when the key is
     * absent or not a double.
     */
    fun getDouble(path: String, default: Double = 0.0): Double =
        config.getDouble(path, default)

    /**
     * Returns the [Boolean] value at [path], or [default] when the key is
     * absent or not a boolean.
     */
    fun getBoolean(path: String, default: Boolean = false): Boolean =
        config.getBoolean(path, default)

    /**
     * Returns the [List] of [String] values at [path], or an empty list
     * when the key is absent.
     */
    fun getStringList(path: String): List<String> =
        config.getStringList(path)

    /**
     * Returns `true` when [path] exists in the loaded configuration.
     */
    fun contains(path: String): Boolean =
        config.contains(path)
}
