package com.epam.task3.service;

import com.epam.task3.bean.News;
import com.epam.task3.service.exception.ServiceException;

import java.util.ArrayList;

/**
 *
 */
public interface NewsService {
    void addNews(News news) throws ServiceException;
    ArrayList<News> getNews() throws ServiceException;
}
