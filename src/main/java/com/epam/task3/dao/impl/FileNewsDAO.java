package com.epam.task3.dao.impl;

import com.epam.task3.bean.News;
import com.epam.task3.dao.NewsDAO;
import com.epam.task3.dao.exception.DAOException;

import java.io.*;
import java.util.ArrayList;

/**
 * Class to work with data files.
 */
public class FileNewsDAO implements NewsDAO{
    private static final String TXT_FILE_PATH = "newsCatalog.txt";

    private ArrayList<News> findNews;

    /**
     * Method to add news to file
     * @param news object containing info with news to add
     * @throws DAOException
     */
    @Override
    public void addNews(News news) throws DAOException {
        try {
            FileWriter writer = new FileWriter(TXT_FILE_PATH, true);
            writer.write(news.getCategory() + " " + news.getTitle() + " " + news.getAuthor());
            writer.append("\n");
            writer.close();
        } catch (FileNotFoundException e) {
            throw new DAOException("Not found txt file!");
        } catch (IOException e) {
            throw new DAOException();
        }
    }

    /**
     * Method to get news from file
     * @return Arraylist of news objects
     * @throws DAOException
     */
    @Override
    public ArrayList<News> getNews() throws DAOException {
        findNews = new ArrayList<>();
        try {
            FileReader reader = new FileReader(TXT_FILE_PATH);
            BufferedReader br = new BufferedReader(reader);
            String s;
            while ((s = br.readLine()) != null) {
                findNews.add(getNewsAttr(s));
            }
        } catch (FileNotFoundException e) {
            throw new DAOException("Not found txt file!");
        } catch (IOException e) {
            throw new DAOException("End file!");
        }
        return findNews;
    }

    private News getNewsAttr(String line) {
        String[] param = line.split(" ");
        return new News(param[0], param[1], param[2]);
    }
}
