package apricity.damagevisualize;

import org.bukkit.plugin.java.JavaPlugin;

public final class DamageVisualize extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Damage Visualization enabled !");
        this.getServer().getPluginManager().registerEvents(new MyEventHandler(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
