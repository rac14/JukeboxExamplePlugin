package org.jukeboxmc.plugin.example;

import lombok.Getter;
import org.jukeboxmc.plugin.Plugin;
import org.jukeboxmc.plugin.example.listener.PlayerJoinListener;
import org.jukeboxmc.plugin.example.listener.PlayerQuitListener;
import org.jukeboxmc.plugin.example.task.TaskHandlerStore;

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
@Getter
public class ExamplePlugin extends Plugin {

    private TaskHandlerStore taskHandlerStore;

    @Override
    public void onStartup() {
        this.getLogger().info("Plugin loaded");
    }

    @Override
    public void onEnable() {
        this.taskHandlerStore = new TaskHandlerStore();

        this.getLogger().info("Plugin enabled");

        this.getServer().getPluginManager().registerListener(new PlayerJoinListener(this));
        this.getServer().getPluginManager().registerListener(new PlayerQuitListener(this));
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Plugin disabled");
    }
}