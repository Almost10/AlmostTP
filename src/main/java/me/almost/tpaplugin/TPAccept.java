package me.almost.tpaplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import static me.almost.tpaplugin.TPAPlugin.TpList;
import static me.almost.tpaplugin.TPAPlugin.NameOf;
import org.bukkit.entity.Player;

public class TPAccept implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player receiver) {
            if (TpList.containsValue(receiver.getDisplayName())) {
                TPAPlugin.getPlugin().getLogger().info("tp "+NameOf.get(receiver.getDisplayName())+" "+receiver.getDisplayName());
                Player Teleporter1 = Bukkit.getPlayer(NameOf.get(receiver.getDisplayName()));
                Player Teleporter2 = Bukkit.getPlayer(receiver.getDisplayName());
                Teleporter1.teleport(Teleporter2);

                receiver.sendMessage(ChatColor.GREEN+"You have accepted the teleportation request of "+ NameOf.get(receiver.getDisplayName()));
                Player D2 = Bukkit.getPlayer(NameOf.get(receiver.getDisplayName()));
                D2.sendMessage(ChatColor.GREEN+"Your teleportation request has been accepted, "+ receiver.getDisplayName()+" has been teleportated to you");
                TpList.remove(NameOf.get(receiver.getDisplayName()));
                NameOf.remove(receiver.getDisplayName());

            }
            else {
                receiver.sendMessage(ChatColor.RED +"You have no pending TPA requests.");
            }
        }



        return true;
    }
}
