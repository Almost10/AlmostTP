package me.almost.tpaplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import static me.almost.tpaplugin.TPAPlugin.TpList;
import  static me.almost.tpaplugin.TPAPlugin.TpVerifier;
import static me.almost.tpaplugin.TPAPlugin.NameOf;
import org.bukkit.entity.Player;

public class TPAccept implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player D) {
            if (TpVerifier.get(D.getDisplayName())) {
                TPAPlugin.getPlugin().getLogger().info("tp "+NameOf.get(D.getDisplayName())+" "+D.getDisplayName());
                Player Teleporter1 = Bukkit.getPlayer(NameOf.get(D.getDisplayName()));
                Player Teleporter2 = Bukkit.getPlayer(D.getDisplayName());
                Teleporter1.teleport(Teleporter2);

                D.sendMessage(ChatColor.GREEN+"You have accepted the teleportation request of "+ NameOf.get(D.getDisplayName()));
                Player D2 = Bukkit.getPlayer(NameOf.get(D.getDisplayName()));
                D2.sendMessage(ChatColor.GREEN+"Your teleportation request has been accepted, "+ D.getDisplayName()+" has been teleportated to you");
                TpVerifier.remove(TpList.get(D.getDisplayName()));
                TpList.remove(NameOf.get(D.getDisplayName()));
                NameOf.remove(D.getDisplayName());
            }
            else {
                D.sendMessage(ChatColor.BLACK +"You have no pending TPA requests.");
            }
        }



        return true;
    }
}
