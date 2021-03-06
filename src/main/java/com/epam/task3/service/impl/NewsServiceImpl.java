package com.epam.task3.service.impl;

import com.epam.task3.bean.News;
import com.epam.task3.dao.NewsDAO;
import com.epam.task3.dao.exception.DAOException;
import com.epam.task3.dao.factory.DAOFactory;
import com.epam.task3.service.NewsService;
import com.epam.task3.service.exception.ServiceException;

import java.util.LinkedList;

/**
 *
 */
public class NewsServiceImpl implements NewsService {

    @Override
    public void addNews(News news) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoFactory.getNewDAO();
            if (validator(news)) {
                throw new ServiceException();
            } else {
                newsDAO.addNews(news);
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public LinkedList<News> getNews() throws ServiceException {
        NewsDAO newsDAO;
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            newsDAO = daoFactory.getNewDAO();
            return newsDAO.getNews();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    private boolean validator(News news) {
        if (news.getCategory().isEmpty()
                || news.getAuthor().isEmpty()
                || news.getTitle().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
