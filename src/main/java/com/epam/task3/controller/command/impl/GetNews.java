package com.epam.task3.controller.command.impl;

import com.epam.task3.bean.News;
import com.epam.task3.controller.command.Command;
import com.epam.task3.service.NewsService;
import com.epam.task3.service.exception.ServiceException;
import com.epam.task3.service.factory.ServiceFactory;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;

/**
 *
 */
public class GetNews implements Command {
    @Override
    public String execute(String request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();
        try {
            ArrayList<News> newsList = newsService.getNews();
            StringBuilder stringBuilder = new StringBuilder();
            for (News news : newsList) {
                stringBuilder.append(news.getCategory() + " " + news.getTitle() + " " + news.getAuthor());
            }
            response = stringBuilder.toString();
        } catch (ServiceException e) {
            e.printStackTrace();
            // TODO: 2/2/2017
        }
        return response;
    }

    private News parseLine(String request) {
        request = request.substring(request.indexOf(' ') + 1, request.length());
        String[] paramNews = request.split(",");
        News news;
        if (paramNews.length  < 3 || paramNews.length > 3) {
            throw new IllegalArgumentException("Entered incorrect number of parameters!");
        } else {
            news = new News(paramNews[0], paramNews[1], paramNews[2]);
        }
        return news;
    }
}
