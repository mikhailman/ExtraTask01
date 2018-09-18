package by.htp.verishko.task1.dao;

import by.htp.verishko.task1.dao.impl.CatalogDAOImpl;
import by.htp.verishko.task1.dao.impl.JAXB;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    private final CatalogDAO catalogDAO = new CatalogDAOImpl();

    public CatalogDAO getCatalogDAO() {
        return catalogDAO;
    }

    private final IJAXB jaxbParser = new JAXB();

    public IJAXB getJaxbParser() {
        return jaxbParser;
    }
}
