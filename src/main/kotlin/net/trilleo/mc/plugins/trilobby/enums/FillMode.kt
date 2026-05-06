package net.trilleo.mc.plugins.trilobby.enums

/**
 * Controls how empty inventory slots are pre-filled in a [net.trilleo.mc.plugins.trilobby.registration.PluginGUI].
 *
 * | Value        | Filler item              | Description                                                              |
 * |:-------------|:-------------------------|:-------------------------------------------------------------------------|
 * | [NONE]       | *(none)*                 | No filler is placed; the inventory is left empty before `setup` is called |
 * | [LIGHT]      | White stained glass pane | All slots are pre-filled with white glass before `setup` is called        |
 * | [DARK]       | Black stained glass pane | All slots are pre-filled with black glass before `setup` is called        |
 */
enum class FillMode {
    NONE,
    LIGHT,
    DARK
}
