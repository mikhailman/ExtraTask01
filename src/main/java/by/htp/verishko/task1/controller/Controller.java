package by.htp.verishko.task1.controller;

import by.htp.verishko.task1.bean.Catalog;
import by.htp.verishko.task1.dao.DAOException;
import by.htp.verishko.task1.service.IJAXBService;
import by.htp.verishko.task1.service.ServiceException;
import by.htp.verishko.task1.service.ServiceFactory;
import by.htp.verishko.task1.service.impl.CatalogServiceImpl;

import javax.xml.bind.JAXBException;

public class Controller {
    public static void main(String[] args) throws JAXBException, DAOException, ControllerException {
        ServiceFactory factory = ServiceFactory.getInstance();
        IJAXBService jaxbService = factory.getJaxbService();
        Catalog catalog = null;
        try {
            catalog = jaxbService.xmlReader();
            jaxbService.xmlWriter(catalog);
        } catch (ServiceException e) {
            throw new ControllerException("Operation xmlRead/xmlWrite failed", e);
        }

        CatalogServiceImpl service = factory.getCatalogService();
        System.out.println("Operation read done!");
    }
}
