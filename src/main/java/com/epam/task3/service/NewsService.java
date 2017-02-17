package com.epam.task3.service;

import com.epam.task3.bean.News;
import com.epam.task3.service.exception.ServiceException;

import java.util.LinkedList;

/**
 *
 */
public interface NewsService {
    void addNews(News news) throws ServiceException;
    LinkedList<News> getNews() throws ServiceException;
}
