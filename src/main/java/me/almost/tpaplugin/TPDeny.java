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
        if (sender instanceof Player receiver) {
            if (TpVerifier.get(receiver.getDisplayName())) {
                TpVerifier.remove(TpList.get(receiver.getDisplayName()));
                TpList.remove(NameOf.get(receiver.getDisplayName()));
                NameOf.remove(receiver.getDisplayName());
                receiver.sendMessage(ChatColor.RED+"You have denied the teleportation request of "+ NameOf.get(receiver.getDisplayName()));
            }
        }
        return true;
    }
}