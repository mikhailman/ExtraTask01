package by.htp.verishko.task1.controller;

import by.htp.verishko.task1.bean.Catalog;
import by.htp.verishko.task1.dao.DAOException;
import by.htp.verishko.task1.service.ICatalogService;
import by.htp.verishko.task1.service.IJAXBService;
import by.htp.verishko.task1.service.ServiceException;
import by.htp.verishko.task1.service.ServiceFactory;

import javax.xml.bind.JAXBException;

public class Controller {
    public static void main(String[] args) throws JAXBException, DAOException, ControllerException {
//        JAXB JAXB = new JAXB();
//        Catalog catalog = JAXB.xmlReader();
//        System.out.println(catalog.getCategory().size());
//        JAXB.xmlWriter(catalog);
        ServiceFactory factory = ServiceFactory.getInstance();
        IJAXBService jaxbService = factory.getJaxbService();
        Catalog catalog = null;
        try {
            catalog = jaxbService.xmlReader();
            jaxbService.xmlWriter(catalog);
        } catch (ServiceException e) {
            throw new ControllerException("Operation readXml/saveXml failed", e);
        }


        ICatalogService service = factory.getCatalogService();
    }
}
