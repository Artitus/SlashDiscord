package us.artit.slashdiscord;

import org.bstats.bukkit.Metrics;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin implements CommandExecutor {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
        getCommand("discord").setExecutor(new DiscordCommand());

        if(getConfig().getBoolean("use_metrics")) {
            Metrics metrics = new Metrics(this);
        } else {
            getServer().getLogger().log(Level.INFO, "Metrics are disabled in config!");
            getServer().getLogger().log(Level.INFO, "Change 'use_metrics' to true to hide this message");
        }
    }

    public static Main getPlugin() { return plugin; }

}