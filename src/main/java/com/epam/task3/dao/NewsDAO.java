package com.epam.task3.dao;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.util.LinkedList;

/**
 *
 */
public interface NewsDAO {
    void addNews(News news) throws DAOException;
    LinkedList<News> getNews() throws DAOException;
}
