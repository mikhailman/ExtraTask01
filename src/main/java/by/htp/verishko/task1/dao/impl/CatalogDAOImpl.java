package by.htp.verishko.task1.dao.impl;


import by.htp.verishko.task1.bean.*;
import by.htp.verishko.task1.bean.criteria.Criteria;
import by.htp.verishko.task1.bean.criteria.SearchCriteria;
import by.htp.verishko.task1.dao.CatalogDAO;
import by.htp.verishko.task1.dao.DAOException;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CatalogDAOImpl implements CatalogDAO {
    @Override
    public List<News> find(Criteria criteria) throws DAOException, JAXBException {
        JAXB jaxb = new JAXB();
        Catalog catalog = jaxb.xmlReader();
        List<News> resultFind = new ArrayList<>();

        for (Category category : catalog.getCategory()) {
//            if (!category.getName().equals(SearchCriteria.News.CATEGORY_NAME)) {
            if (!SC(category, criteria, SearchCriteria.News.CATEGORY_NAME))
                continue;
            for (SubCategory subCategory : category.getSubcategory()) {
                if (!SC(subCategory, criteria, SearchCriteria.News.SUBCATEGORY_NAME))
//                if (!category.getName().equals(SearchCriteria.News.SUBCATEGORY_NAME))
                    continue;
                for (News item : subCategory.getNews()) {
                    if (findNews(item, criteria)) {
                        resultFind.add(item);
                    }
                }
            }
        }
        return resultFind;
    }

    private boolean SC(IBaseEntity item, Criteria criteria, SearchCriteria.News nameValue) {
        if (criteria.getCriteria().containsKey(nameValue)) {
            Object value = criteria.getCriteria().get(nameValue);
            return item.getName().equals(value);
        }
        return true;
    }


    private boolean findNews(News news, Criteria criteria) {
        for (Map.Entry<SearchCriteria.News, Object> entry : criteria.getCriteria().entrySet()) {
            switch (entry.getKey()) {
                case NAME:
                    if (!news.getName().equals(entry.getValue())) {
                        return false;
                    }
                    break;
                case PROVIDER:
                    if (!news.getProvider().equals(entry.getValue())) {
                        return false;
                    }
                    break;
                case NEWS_BODY:
                    if (!news.getNewsBody().equals(entry.getValue())) {
                        return false;
                    }
                    break;
                case DATE_OF_ISSUE:
                    if (!news.getDateOfIssue().equals(entry.getValue())) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    @Override
    public News add(Criteria criteria) throws DAOException, JAXBException {
        JAXB jaxb = new JAXB();
        Catalog catalog = jaxb.xmlReader();
        News addNews = new News();
//        CatalogDAOImpl catalogDAO = new CatalogDAOImpl();

        for (Category category : catalog.getCategory()) {
            if (!category.getName().equals(SearchCriteria.News.CATEGORY_NAME)) {
                return null;
            }
            for (SubCategory subCategory : category.getSubcategory()) {
                if (category.getName().equals(SearchCriteria.News.SUBCATEGORY_NAME)) {
                    addNews = addParamNews(addNews, criteria);
                }
            }
        }
        return addNews;
    }

    private News addParamNews(News news, Criteria criteria) {
        for (Map.Entry<SearchCriteria.News, Object> item : criteria.getCriteria().entrySet()) {
            switch (item.getKey()) {
                case NAME:
                    news.setName("name");
                    break;
                case PROVIDER:
                    news.setProvider("Vasya");
                    break;
                case DATE_OF_ISSUE:
                    news.setDateOfIssue("12.43.77");
                    break;
                case NEWS_BODY:
                    news.setNewsBody("Vasya lubit Mashkere");
                    break;
            }
        }
        return news;
    }
}