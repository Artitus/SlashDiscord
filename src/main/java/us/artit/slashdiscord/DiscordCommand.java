package us.artit.slashdiscord;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Main plugin = Main.getPlugin();

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to run /discord!");
            return false;
        }

        Player p = (Player) sender;

        if (plugin.getConfig().getBoolean("enable_permission") && !(p.hasPermission(plugin.getConfig().getString("permission")) || p.isOp())) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("no_permission_message")));
            return false;
        }

        plugin.getConfig().getStringList("message").forEach(line ->
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', line)));
        return true;
    }
}
