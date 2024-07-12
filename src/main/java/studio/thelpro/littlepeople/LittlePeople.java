package studio.thelpro.littlepeople;

import org.bukkit.plugin.java.JavaPlugin;
import studio.thelpro.littlepeople.commands.SummonCommand;

public final class LittlePeople extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("summonperson").setExecutor(new SummonCommand());

    }
}