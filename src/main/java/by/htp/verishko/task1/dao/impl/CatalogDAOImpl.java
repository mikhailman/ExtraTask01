package by.htp.verishko.task1.dao.impl;

import by.htp.verishko.task1.bean.Catalog;
import by.htp.verishko.task1.bean.Category;
import by.htp.verishko.task1.bean.News;
import by.htp.verishko.task1.bean.SubCategory;
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
            if (category.getName().equals(SearchCriteria.News.CATEGORY_NAME))
                continue;
            for (SubCategory subCategory : category.getSubCategory()) {
                if (category.getName().equals(SearchCriteria.News.SUBCATEGORY_NAME))
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
    public News add(News news) throws DAOException, JAXBException {
//        JAXB jaxb = new JAXB();
//        Catalog catalog = jaxb.xmlReader();
//        News addNews = new News();
//
//
//        for (Category category : catalog.getCategory()) {
//            if (category.getName().equals(SearchCriteria.News.CATEGORY_NAME))
//                continue;
//            for (SubCategory subCategory : category.getSubCategory()) {
//                if (category.getName().equals(SearchCriteria.News.SUBCATEGORY_NAME))
//
//
//            }
//        }
        return null;
    }
}