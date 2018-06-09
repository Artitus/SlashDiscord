package us.artit.slashdiscord;

import org.bstats.bukkit.Metrics;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
        getCommand("discord").setExecutor(new DiscordCommand());

        Metrics metrics = new Metrics(this);
    }

    public static Main getPlugin() { return plugin; }

}