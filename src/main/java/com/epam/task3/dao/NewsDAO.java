package com.epam.task3.dao;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.util.ArrayList;

/**
 *
 */
public interface NewsDAO {
    void addNews(News news) throws DAOException;
    ArrayList<News> getNews() throws DAOException;
}
