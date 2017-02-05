package com.epam.task3.controller;

import com.epam.task3.controller.command.Command;
import com.epam.task3.controller.command.CommandName;
import com.epam.task3.controller.command.impl.AddNews;
import com.epam.task3.controller.command.impl.FindNews;
import com.epam.task3.controller.command.impl.InvalidRequest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD_NEWS, new AddNews());
        repository.put(CommandName.FIND_NEWS, new FindNews());
        repository.put(CommandName.INVALID_REQUEST, new InvalidRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.INVALID_REQUEST);
        }
        return command;
    }
}
