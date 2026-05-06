<h1 align="center">
  TriLobby
</h1>

A Paper (Minecraft) plugin built with Kotlin. It comes with an auto-registration system for
commands, listeners, permissions, and GUIs — just extend a base class, drop it in the right package, and the plugin
handles the rest.

## Project Structure

```
src/main/kotlin/net/trilleo/mc/plugins/trilobby/
├── Main.kt                  # Plugin entry point
├── commands/                # Auto-registered commands (extend PluginCommand)
├── data/                    # JSON-persisted player and server data (PlayerData, ServerData)
├── enums/                   # Plugin-wide enums (e.g. FillMode, PagedGUIMode)
├── guis/                    # Auto-registered GUIs (extend PluginGUI)
├── listeners/               # Auto-registered listeners (implement Listener)
├── registration/            # Auto-registration framework
└── utils/                   # Utility helpers (ItemStack DSL, TeamUtil, TagUtil, etc.)
```

See [`docs/DEVELOPER_GUIDE.md`](docs/DEVELOPER_GUIDE.md) for detailed instructions on creating commands, listeners,
and GUIs.

See [`docs/UTILITY_GUIDE.md`](docs/UTILITY_GUIDE.md) for documentation on the built-in utility helpers such as
the `itemStack` DSL builder, `TeamUtil`, `TagUtil`, `MessageUtil`, and `PDCUtil`.

See [`docs/COMMIT_STRUCTURE.md`](docs/COMMIT_STRUCTURE.md) for the required commit message format.

