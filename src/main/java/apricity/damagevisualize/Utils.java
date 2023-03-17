package apricity.damagevisualize;

import org.bukkit.Bukkit;

public class Utils {
    public static void sleep(double t){
        //ms
        try{
            Thread.sleep((int)t);
        }catch (InterruptedException e){
            Bukkit.getLogger().info("Java Thread error.");
        }

    }
}
