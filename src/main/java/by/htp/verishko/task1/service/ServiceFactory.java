package by.htp.verishko.task1.service;

import by.htp.verishko.task1.service.impl.CatalogServiceImpl;
import by.htp.verishko.task1.service.impl.JAXBServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    private final IJAXBService jaxbService = new JAXBServiceImpl();

    public IJAXBService getJaxbService() {
        return jaxbService;
    }

    private final CatalogServiceImpl catalogService = new CatalogServiceImpl();

    public CatalogServiceImpl getCatalogService() {
        return catalogService;
    }
}
