package by.htp.verishko.task1.controller;

import by.htp.verishko.task1.bean.*;
import by.htp.verishko.task1.bean.criteria.Criteria;
import by.htp.verishko.task1.bean.criteria.SearchCriteria;
import by.htp.verishko.task1.dao.DAOException;
import by.htp.verishko.task1.dao.impl.CatalogDAOImpl;
import by.htp.verishko.task1.dao.impl.JAXB;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Controller {
    public static void main(String[] args) throws JAXBException, DAOException {
//         работа JAXB
        JAXB parser = new JAXB();
//        читать xml
        Catalog catalog = parser.xmlReader();
//        писать xml
        parser.xmlWriter(catalog);
//        System.out.println("________________________________________________________________________________________");
//        System.out.println("Operation read done!");



//        поиск по критерию
        CatalogDAOImpl catalogDAO = new CatalogDAOImpl();
        Criteria criteria = new Criteria();
        criteria.addCriteria(SearchCriteria.News.CATEGORY_NAME, "Films");

        List<News> ourSearhCriteria = catalogDAO.find(criteria);

        System.out.println(ourSearhCriteria);




    }
}
