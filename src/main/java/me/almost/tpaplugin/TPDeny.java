package me.almost.tpaplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.almost.tpaplugin.TPAPlugin.*;
import static me.almost.tpaplugin.TPAPlugin.NameOf;

public class TPDeny implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player D) {
            if (TpVerifier.get(D.getDisplayName())) {
                TpVerifier.remove(TpList.get(D.getDisplayName()));
                TpList.remove(NameOf.get(D.getDisplayName()));
                NameOf.remove(D.getDisplayName());
                D.sendMessage(ChatColor.RED+"You have denied the teleportation request of "+ NameOf.get(D.getDisplayName()));
            }
        }
        return true;
    }
}