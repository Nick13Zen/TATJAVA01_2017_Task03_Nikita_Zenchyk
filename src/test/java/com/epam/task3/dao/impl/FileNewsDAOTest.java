package com.epam.task3.dao.impl;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 *
 */
class FileReadNewsDAOTest {
    FileNewsDAO fileRead;


    @BeforeMethod
    public void setUp() {
        fileRead = new FileNewsDAO();

    }

    @DataProvider(name = "positiveTestArgs")
    public Object[][] getNews() {
        return new Object[][]{
                {new News("book", "long_book", "nick")},
                {new News("movie", "long_book", "nick")},
                {new News("disk", "long_disk", "nick")}
        };
    }

    @DataProvider(name = "negativeTestArgs")
    public Object[][] geTillegalArg() {
        return new Object[][]{
                {null}
        };
    }

    @Test(dataProvider = "positiveTestArgs")
    public void positiveTestForAddNews(News news) throws DAOException {
        fileRead.addNews(news);
    }

    @Test(dataProvider = "positiveTestArgs")
    public void positiveTestForFindNews(News news) throws DAOException {
        fileRead.getNews();
    }

    @Test(dataProvider = "negativeTestArgs", expectedExceptions = DAOException.class)
    public void negativeTestForAddNews(News news) throws DAOException {
        fileRead.addNews(news);
    }

    @Test(dataProvider = "negativeTestArgs", expectedExceptions = DAOException.class)
    public void negativeTestForFindNews(News news) throws DAOException {
        fileRead.getNews();
    }

}
