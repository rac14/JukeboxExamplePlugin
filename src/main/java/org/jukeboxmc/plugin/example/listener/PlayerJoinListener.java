package org.jukeboxmc.plugin.example.listener;

import lombok.RequiredArgsConstructor;
import org.jukeboxmc.Server;
import org.jukeboxmc.event.EventHandler;
import org.jukeboxmc.event.Listener;
import org.jukeboxmc.event.player.PlayerJoinEvent;
import org.jukeboxmc.math.Location;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.plugin.example.ExamplePlugin;
import org.jukeboxmc.world.World;

/**
 * Copyright (c) 2021, Kaooot
 * All rights reserved.
 * <p>
 * This project is licensed under the BSD 3-Clause License which can be found
 * in the root directory of this source tree.
 *
 * @author Kaooot
 * @version 1.0
 */
@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final ExamplePlugin plugin;

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        event.setJoinMessage("");

        player.sendMessage("§bDeveloper-Mode §2enabled");

        this.plugin.getTaskHandlerStore().addToStore(player.getUUID().toString(), Server.getInstance().getScheduler().scheduleRepeating(new Runnable() {
            public void run() {
                final Location location = player.getLocation();
                final World world = player.getWorld();

                final String tip = "§3GameMode§7: §e" + player.getGameMode().getGamemode() + "\n" +
                        "§3Health§7: §e" + player.getHealth() + "\n" +
                        "§3Hunger§7: §e" + player.getHunger() + "\n" +
                        "§3World§7: §e" + world.getName() + "\n" +
                        "§3Location§7: §e" + location.getFloorX() + "§8, §e" + location.getFloorY() + "§8, §e" +
                        location.getFloorZ() + "\n" +
                        "§3HeadYaw§7: §e" + Integer.parseInt(String.valueOf(location.getHeadYaw()).split("\\.")[0]) + "\n" +
                        "§3Yaw§7: §e" + Integer.parseInt(String.valueOf(location.getYaw()).split("\\.")[0]) + "\n" +
                        "§3Pitch§7: §e" + Integer.parseInt(String.valueOf(location.getPitch()).split("\\.")[0]) + "\n" +
                        "§3ItemInHand§7: §e" + player.getInventory().getItemInHand().getItemType().name() + "\n" +
                        "§3Block§7: §e" + world.getBlock(location.subtract(0, 1, 0)).getBlockType().name() + "\n" +
                        "§3Block (down)§7: §e" + world.getBlock(location.subtract(0, 2, 0)).getBlockType().name();

                player.sendTip(tip);
            }
        }, 1));
    }
}