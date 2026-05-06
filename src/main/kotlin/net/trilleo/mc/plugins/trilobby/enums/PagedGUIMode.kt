package net.trilleo.mc.plugins.trilobby.enums

/**
 * Controls how items are supplied to a [net.trilleo.mc.plugins.trilobby.registration.PagedPluginGUI].
 *
 * | Value  | Override      | Description                                                                                       |
 * |:-------|:--------------|:--------------------------------------------------------------------------------------------------|
 * | [LIST] | `getItems`    | Items provided as a flat list, automatically distributed across pages (one item per slot)         |
 * | [SET]  | `getSetItems` | Items placed manually by page and slot, giving full control over each item's exact position       |
 */
enum class PagedGUIMode {
    LIST,
    SET
}
