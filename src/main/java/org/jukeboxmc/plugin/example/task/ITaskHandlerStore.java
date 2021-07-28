package org.jukeboxmc.plugin.example.task;

import org.jukeboxmc.scheduler.TaskHandler;

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
public interface ITaskHandlerStore {

    /**
     * Adds a new {@link org.jukeboxmc.scheduler.TaskHandler} to this
     * {@link org.jukeboxmc.plugin.example.task.ITaskHandlerStore}
     *
     * @param uuid        which is the holder of the {@link org.jukeboxmc.scheduler.TaskHandler}
     * @param taskHandler which represents the object to store
     */
    void addToStore(final String uuid, final TaskHandler taskHandler);

    /**
     * Removes an already existing {@link org.jukeboxmc.scheduler.TaskHandler} by their holder
     *
     * @param uuid which holds the {@link org.jukeboxmc.scheduler.TaskHandler}
     */
    void removeFromStoreAndCancel(final String uuid);
}