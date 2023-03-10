package me.almost.tpaplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.almost.tpaplugin.TPAPlugin.TpList;
import  static me.almost.tpaplugin.TPAPlugin.NameOf;

public class TPRequest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player pal) {
            if (!TpList.containsKey(pal.getDisplayName())) {
                Player receiver = Bukkit.getPlayer(args[0]);
                if (NameOf.containsKey(receiver.getDisplayName())) {
                    pal.sendMessage(ChatColor.RED+ "This person already has a pending TP request.");
                    receiver.sendMessage(ChatColor.RED+" "+pal.getDisplayName()+ " sent you a tp request but you have one already pending, please /tpdeny that one to be able to accept another. ");

                }
                else {
                    TpList.put(pal.getDisplayName(), args[0]);
                    NameOf.put(args[0], pal.getDisplayName());
                    TPAPlugin.getPlugin().getLogger().info(TpList.get(pal.getDisplayName()));
                    pal.sendMessage(ChatColor.GREEN + "You have sent a teleportation request to " + TpList.get(pal.getDisplayName()));
                    Player pal2 = Bukkit.getPlayer(args[0]);

                    pal2.sendMessage(ChatColor.GREEN + "You have been sent a teleporation request by "
                            + pal.getDisplayName() + ", To accept the request, please type /tpaccept");

                }
            }
            else {
                pal.sendMessage(ChatColor.RED+ "Please only send TP once.");
            }
        }


        return true;
    }
}
