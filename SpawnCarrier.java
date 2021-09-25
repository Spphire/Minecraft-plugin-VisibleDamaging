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



/*
        Timer timer1 =  new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                Location temp=entity.getLocation();
                temp=temp.clone();
                temp.setY(temp.getY()+0.2);
                entity.teleport(temp);
                timer1.cancel();
            }
        },100);

        Timer timer2 =  new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                Location temp=entity.getLocation();
                temp=temp.clone();
                temp.setY(temp.getY()+0.1);
                entity.teleport(temp);
                timer2.cancel();
            }
        },200);

        Timer timer3 =  new Timer();
        timer3.schedule(new TimerTask() {
            @Override
            public void run() {
                Location temp=entity.getLocation();
                temp=temp.clone();
                temp.setY(temp.getY()-0.1);
                entity.teleport(temp);
                timer3.cancel();
            }
        },300);

        Timer timer4 =  new Timer();
        timer4.schedule(new TimerTask() {
            @Override
            public void run() {
                Location temp=entity.getLocation();
                temp=temp.clone();
                temp.setY(temp.getY()-0.2);
                entity.teleport(temp);
                timer4.cancel();
            }
        },400);

        Timer timer5 =  new Timer();
        timer5.schedule(new TimerTask() {
            @Override
            public void run() {
                Location temp=entity.getLocation();
                temp=temp.clone();
                temp.setY(temp.getY()-0.3);
                entity.teleport(temp);
                timer5.cancel();
            }
        },500);

        Timer timer =  new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Location temp=entity.getLocation();
                temp=temp.clone();
                temp.setY(temp.getY()-500);
                entity.teleport(temp);
                timer.cancel();
            }
        },600);

 */

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
