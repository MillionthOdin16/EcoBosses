package com.willfp.ecobosses.commands

import com.willfp.eco.core.command.impl.PluginCommand
import com.willfp.ecobosses.EcoBossesPlugin
import com.willfp.ecobosses.bosses.Bosses
import com.willfp.libreforge.lrcdb.CommandExport
import com.willfp.libreforge.lrcdb.CommandImport
import com.willfp.libreforge.lrcdb.ExportableConfig
import org.bukkit.command.CommandSender

class CommandEcobosses(plugin: EcoBossesPlugin) : PluginCommand(
    plugin,
    "ecobosses",
    "ecobosses.command.ecobosses",
    false
) {
    override fun onExecute(
        sender: CommandSender,
        args: List<String>
    ) {
        sender.sendMessage(plugin.langYml.getMessage("invalid-command"))
    }

    init {
        addSubcommand(CommandReload(plugin))
            .addSubcommand(CommandKillall(plugin))
            .addSubcommand(CommandSpawn(plugin))
            .addSubcommand(CommandGive(plugin))
            .addSubcommand(CommandImport("bosses", plugin))
            .addSubcommand(CommandExport(plugin) {
                Bosses.values().map {
                    ExportableConfig(
                        it.id,
                        it.config
                    )
                }
            })
    }
}
