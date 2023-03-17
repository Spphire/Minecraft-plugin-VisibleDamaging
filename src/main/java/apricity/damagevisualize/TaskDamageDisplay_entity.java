package apricity.damagevisualize;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.entity.EntityDamageEvent;


public class TaskDamageDisplay_entity implements Runnable{
    //private HashMap<EntityType,double> HeightHash;
    private DamageVisualize p;
    private EntityDamageEvent e;
    private float damage;
    private ChatColor color;

    private String damageString;


    public TaskDamageDisplay_entity(DamageVisualize p, EntityDamageEvent e, float damage, ChatColor color){
        this.p=p;this.e=e;this.damage=damage;this.color=color;
        if(damage>=0){
            if(Float.isInfinite(damage)){
                damageString="seckill";
            }else{
                damageString=String.valueOf((float) Math.round(damage * 100) / 100);
            }
        }else{
            damageString="miss";
        }
    }

    @Override
    public void run() {
        //生成架子
        //double h=1.5;
        Location loc = e.getEntity().getLocation();
        double h = e.getEntity().getBoundingBox().getHeight();

        loc.setY(loc.getY()+h);
        ArmorStand as;

        as = e.getEntity().getWorld().spawn(
                loc,
                ArmorStand.class,
                t->{
                    t.setCustomNameVisible(true);
                    t.setCustomName(this.color + damageString);
                    t.setMarker(true);
                    t.setSilent(true);
                    t.setInvulnerable(true);
                    t.setInvisible(true);
                }
        );

        //模拟掉落


        Bukkit.getScheduler().runTaskAsynchronously(this.p, new Runnable() {
            //runTaskAsynchronously异步延迟
            @Override
            public void run() {
                double y0 = as.getLocation().getY();
                double x0 = as.getLocation().getX();
                double z0 = as.getLocation().getZ();
                double v0 = 5, g = -22, T = 0;
                double vH0 = 2*(Math.random());
                double angle = 2*Math.PI*(Math.random()-0.5);
                while (true) {
                    double t = T / 1000;
                    double y = y0 + v0 * t + g * t * t / 2;
                    double x = x0 + vH0 * t * Math.sin(angle);
                    double z = z0 + vH0 * t * Math.cos(angle);
                    Bukkit.getScheduler().runTask(p, new Runnable() {
                        //runTask强制主线程
                        @Override
                        public void run() {
                            Location loc = as.getLocation();
                            loc.setY(y);
                            loc.setX(x);
                            loc.setZ(z);
                            //loc.setY(Math.max(y0 - h, y));
                            as.teleport(loc);
                        }
                    });
                    if (y < y0 - h) break;
                    if (T > 650) break;
                    Utils.sleep(30);
                    T += 30;
                }
                Bukkit.getScheduler().runTask(p, new Runnable() {
                    @Override
                    public void run() {
                        as.remove();
                    }
                });
            }
        });
    }
}
