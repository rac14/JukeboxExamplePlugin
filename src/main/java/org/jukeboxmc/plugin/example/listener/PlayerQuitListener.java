package org.jukeboxmc.plugin.example.listener;

import lombok.RequiredArgsConstructor;
import org.jukeboxmc.event.EventHandler;
import org.jukeboxmc.event.Listener;
import org.jukeboxmc.event.player.PlayerQuitEvent;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.plugin.example.ExamplePlugin;

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
public class PlayerQuitListener implements Listener {

    private final ExamplePlugin plugin;

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        event.setQuitMessage("");

        this.plugin.getTaskHandlerStore().removeFromStoreAndCancel(player.getUUID().toString());
    }
}