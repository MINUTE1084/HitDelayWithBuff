package com.HitDelayWithBuff;

import java.util.Collection;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class MainClass extends JavaPlugin
    implements Listener
{

    public MainClass()
    {
        isDebug = false;
        defaultTicks = 12;
        addTicks = 2;
        subTicks = 2;
        maximumTicks = 24;
        minimumTicks = 0;
    }

    public void onDisable()
    {
        Bukkit.getConsoleSender().sendMessage("2[\247aHitDelayWithBuff\2472] \2477HitDelayWithBuff 1.2 \uBE44\uD65C\uC131\uD654 \uB418\uC5C8\uC5B4\uC694.");
        System.out.println("Made by MINUTE.");
    }

    public void onEnable()
    {
        initCommand();
        Bukkit.getConsoleSender().sendMessage("\2472[\247aHitDelayWithBuff\2472] \2477HitDelayWithBuff 1.2 \uD65C\uC131\uD654 \uB418\uC5C8\uC5B4\uC694.");
        Bukkit.getConsoleSender().sendMessage("\2477Made by MINUTE.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    public void initCommand()
    {
        command = new MainCommand(this);
        getCommand("hitdelay").setExecutor(command);
    }

    public void onEntityDamage(EntityDamageByEntityEvent event)
    {
        int noDamageTicks = defaultTicks;
        if((event.getEntity() instanceof Player) || (event.getEntity() instanceof LivingEntity) || !(event.getDamager() instanceof Player) && !(event.getDamager() instanceof LivingEntity))
        {
            LivingEntity target = (LivingEntity)event.getEntity();
            LivingEntity player = (LivingEntity)event.getDamager();
            Collection<?> pe = player.getActivePotionEffects();
            if(isDebug)
                if((event.getEntity() instanceof Player) && (event.getDamager() instanceof Player))
                {
                    Player Player_D = (Player)event.getDamager();
                    Player Player_A = (Player)event.getEntity();
                    Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477")).append(Player_D.getDisplayName()).append("\2477\uB2D8\uC774 ").append(Player_A.getDisplayName()).append("\2477\uB2D8\uC744 \uACF5\uACA9\uD588\uC2B5\uB2C8\uB2E4.").toString());
                } else
                if(event.getEntity() instanceof Player)
                {
                    Player Player_A = (Player)event.getEntity();
                    Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477")).append(Player_A.getDisplayName()).append("\2477\uB2D8\uC774 ").append(target.getClass().getName()).append("\2477\uC5D0\uAC8C \uACF5\uACA9\uB2F9\uD588\uC2B5\uB2C8\uB2E4.").toString());
                } else
                if(event.getDamager() instanceof Player)
                {
                    Player Player_D = (Player)event.getDamager();
                    Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477")).append(Player_D.getDisplayName()).append("\2477\uB2D8\uC774 ").append(target.getClass().getName()).append("\2477\uB97C \uACF5\uACA9\uD588\uC2B5\uB2C8\uB2E4.").toString());
                }
            for(Iterator<?> iterator = pe.iterator(); iterator.hasNext();)
            {
                PotionEffect effect = (PotionEffect)iterator.next();
                if(effect.getType().equals(PotionEffectType.FAST_DIGGING))
                {
                    noDamageTicks -= (effect.getAmplifier() + 1) * subTicks;
                    if(isDebug)
                        Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477-")).append((effect.getAmplifier() + 1) * subTicks).append("\2477 Ticks").toString());
                }
                if(effect.getType().equals(PotionEffectType.SLOW_DIGGING))
                {
                    noDamageTicks += (effect.getAmplifier() + 1) * addTicks;
                    if(isDebug)
                        Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477+")).append((effect.getAmplifier() + 1) * addTicks).append("\2477 Ticks").toString());
                }
            }

            if(noDamageTicks < minimumTicks)
            {
                noDamageTicks = minimumTicks;
                if(isDebug)
                    Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uCD5C\uC18C \uB51C\uB808\uC774 \uBBF8\uB9CC\uC5D0 \uB3C4\uB2EC\uD558\uC5EC ")).append(minimumTicks).append("\2477\uD2F1\uC73C\uB85C \uC124\uC815\uB418\uC5C8\uC2B5\uB2C8\uB2E4.").toString());
            }
            if(noDamageTicks > maximumTicks)
            {
                noDamageTicks = maximumTicks;
                if(isDebug)
                    Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uCD5C\uB300 \uB51C\uB808\uC774 \uCD08\uACFC\uC5D0 \uB3C4\uB2EC\uD558\uC5EC ")).append(maximumTicks).append("\2477\uD2F1\uC73C\uB85C \uC124\uC815\uB418\uC5C8\uC2B5\uB2C8\uB2E4.").toString());
            }
            if(isDebug)
                Bukkit.getConsoleSender().sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uD53C\uACA9\uB41C \uC5D4\uD2F0\uD2F0\uAC00 ")).append(noDamageTicks).append("\2477\uC758 \uBB34\uC801 \uC2DC\uAC04\uC744 \uAC16\uC2B5\uB2C8\uB2E4.").toString());
            target.setMaximumNoDamageTicks(noDamageTicks);
        }
    }

    private static MainCommand command;
    public boolean isDebug;
    public int defaultTicks;
    public int addTicks;
    public int subTicks;
    public int maximumTicks;
    public int minimumTicks;
}
