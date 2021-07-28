package org.jukeboxmc.plugin.example.task;

import org.jukeboxmc.scheduler.TaskHandler;

import java.util.HashMap;
import java.util.Map;

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
public class TaskHandlerStore implements ITaskHandlerStore {

    private final Map<String, TaskHandler> taskHandlerStore = new HashMap<String, TaskHandler>();

    public void addToStore(final String uuid, final TaskHandler taskHandler) {
        this.taskHandlerStore.put(uuid, taskHandler);
    }

    public void removeFromStoreAndCancel(final String uuid) {
        if (this.taskHandlerStore.containsKey(uuid)) {
            final TaskHandler taskHandler = this.taskHandlerStore.get(uuid);
            taskHandler.cancel();

            this.taskHandlerStore.remove(uuid);
        }
    }
}