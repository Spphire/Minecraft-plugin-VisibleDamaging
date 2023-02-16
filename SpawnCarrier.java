package apricity.genshin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.*;

import java.util.Timer;
import java.util.TimerTask;

public class SpawnCarrier {

    public static void SpawnVisualDigit(Apricity p,ChatColor chatColor, Entity target, Integer damage){
        Location l=target.getLocation();
        l=l.clone();
        l.setY(l.getY()+0.4);
        ArmorStand entity= Bukkit.getWorld("world").spawn(
                l,
                ArmorStand.class,
                t -> {
                    t.setCustomName(chatColor+""+damage);
                    t.setCustomNameVisible(true);
                    t.setMarker(false);
                    t.setBasePlate(false);
                    t.setCustomNameVisible(true);
                    t.setInvisible(true);
                    t.setSmall(true);
                    t.setSilent(true);
                    //Bukkit.getLogger().info("Spawning.");
                });

        Bukkit.getScheduler().runTaskLaterAsynchronously(p, new Runnable() {
            //runTaskAsynchronously异步延迟
            @Override
            public void run() {
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    //runTask强制主线程
                    @Override
                    public void run() {
                        Location temp=entity.getLocation().clone();
                        temp.setY(temp.getY()+0.1);
                        entity.teleport(temp);
                    }
                });
                Tools.sleep(100);
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    //runTask强制主线程
                    @Override
                    public void run() {
                        Location temp=entity.getLocation().clone();
                        temp.setY(temp.getY()+0.2);
                        entity.teleport(temp);
                    }
                });
                Tools.sleep(100);
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    //runTask强制主线程
                    @Override
                    public void run() {
                        Location temp=entity.getLocation().clone();
                        temp.setY(temp.getY()+0.1);
                        entity.teleport(temp);
                    }
                });
                Tools.sleep(100);
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    //runTask强制主线程
                    @Override
                    public void run() {
                        Location temp=entity.getLocation().clone();
                        temp.setY(temp.getY()-0.1);
                        entity.teleport(temp);
                    }
                });
                Tools.sleep(100);
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    //runTask强制主线程
                    @Override
                    public void run() {
                        Location temp=entity.getLocation().clone();
                        temp.setY(temp.getY()-0.2);
                        entity.teleport(temp);
                    }
                });
                Tools.sleep(100);
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    //runTask强制主线程
                    @Override
                    public void run() {
                        Location temp=entity.getLocation().clone();
                        temp.setY(temp.getY()-0.3);
                        entity.teleport(temp);
                    }
                });
                Tools.sleep(100);
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    //runTask强制主线程
                    @Override
                    public void run() {
                        entity.remove();
                    }
                });
            }
        }, 1);
    }

}
