package us.artit.slashdiscord;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to run /discord!");
            return false;
        }

        Player p = (Player) sender;

        if (Main.getPlugin().getConfig().getBoolean("enable_permission") && !(p.hasPermission(Main.getPlugin().getConfig().getString("permission")) || p.isOp())) {
            sender.sendMessage(Main.getPlugin().getConfig().getString("no_permission_message"));
            return false;
        }

        Main.getPlugin().getConfig().getStringList("message").forEach(line -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', line)));
        return true;
    }
}
