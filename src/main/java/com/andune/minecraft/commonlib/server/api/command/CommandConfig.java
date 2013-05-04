/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (c) 2013 Andune (andune.alleria@gmail.com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
package com.andune.minecraft.commonlib.server.api.command;

import java.util.Map;
import java.util.Set;

public interface CommandConfig {
    /**
     *  Check if a command is disabled.
     * 
     * @param command the command name to check
     * @return true if the command is disabled
     */
    public boolean isDisabledCommand(String command);

    /** Return a list of all commands that have been defined and have
     * command parameters.
     * 
     * @return
     */
    public Set<String> getDefinedCommands();

    /** Return command parameters for a specific command.
     * 
     * @return guaranteed to not return null
     */
    public Map<String, Object> getCommandParameters(String command);

    /** This method does the heavy lifting of processing a configuration to load
     * the configuration state. An example config state:
     * 
     * commands:
     *   disabledCommands: [home, sethome]
     *   randomspawn:
     *     class: CustomEventCommand
     *     event: randomspawn
     * 
     * @param section
     */
    public void loadConfig();
}