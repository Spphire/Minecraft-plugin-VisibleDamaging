package apricity.damagevisualize;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class MyEventHandler implements Listener {
    private DamageVisualize p;
    public MyEventHandler(DamageVisualize p) {
        this.p = p;
    }

    /**
     *  玩家加入服务器 事件处理
     * @param event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        //当玩家进入服务器时，会在玩家身边播放音效
        Location location = player.getLocation();
        World world = location.getWorld();
        world.playSound(location, Sound.ENTITY_PLAYER_LEVELUP, .5F, .5F);

        //并且修改玩家进入服务器时的全局广播提示
        event.setJoinMessage(ChatColor.GREEN + "玩家" + player.getName() + "加入了服务器！");
    }

    /**
     * 羊毛色彩变化 事件处理
     * 当玩家想要伤害🐏的时候羊毛颜色会改变
     */
    @EventHandler
    public void onPlayerHitSheep(EntityDamageByEntityEvent event){
        Entity damager = event.getDamager();
        if (!damager.isEmpty() && damager instanceof Player){
            //damager是玩家
            if (event.getEntity() != null && event.getEntity() instanceof Sheep){
                //被害者是🐏
                Entity entity = event.getEntity();
                Sheep sheep = (Sheep) entity;

                DyeColor[] colors = DyeColor.values();
                int randomColorIndex = new Random().nextInt(colors.length-1);

                //修改羊毛颜色
                sheep.setColor(colors[randomColorIndex]);

                //取消事件
                event.setCancelled(true);
            }
        }
    }
    @EventHandler(ignoreCancelled = false, priority = EventPriority.LOWEST)
    public void onPlayerAttackEntity(EntityDamageEvent event){
        if(event.getCause() == EntityDamageEvent.DamageCause.FIRE||event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK){
            if(event.getFinalDamage()!=0){
                Bukkit.getScheduler().runTask(this.p,new TaskDamageDisplay_entity(this.p, event,(float)event.getFinalDamage(), ChatColor.RED));
            }
        }
    }

    @EventHandler(ignoreCancelled = false, priority = EventPriority.LOWEST)
    public void onPlayerAttackEntity(EntityDamageByEntityEvent event){
        Bukkit.getScheduler().runTask(this.p,new TaskDamageDisplay_entity(this.p, event,(float)event.getFinalDamage(), ChatColor.WHITE));
    }
}
