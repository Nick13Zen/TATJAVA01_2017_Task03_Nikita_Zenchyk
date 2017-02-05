package com.epam.task3;

import com.epam.task3.controller.Controller;

/**
 *
 */
public class Main {
    private final static String ADD_NEWS = "add_news movie,long,nick";
    private final static String FIND_NEWS = "find_news long";

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.executeTask(ADD_NEWS);
        System.out.println(controller.executeTask(FIND_NEWS));
    }
}