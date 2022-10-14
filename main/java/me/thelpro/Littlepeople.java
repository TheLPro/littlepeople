package me.thelpro;

import me.thelpro.commands.summonCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Littlepeople extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("summonperson").setExecutor(new summonCommand());

    }
}
