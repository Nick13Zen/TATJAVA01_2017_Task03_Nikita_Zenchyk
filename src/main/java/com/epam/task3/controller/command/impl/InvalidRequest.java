package com.epam.task3.controller.command.impl;

import com.epam.task3.controller.command.Command;

/**
 *
 */
public class InvalidRequest implements Command {
    private static final String respons = "Unknown command.";
    @Override
    public String execute(String request) {
        return respons;
    }
}
