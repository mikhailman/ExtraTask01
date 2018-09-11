package by.htp.verishko.task1.dao;

import by.htp.verishko.task1.bean.Catalog;

import javax.xml.bind.JAXBException;

public interface IJAXB {

    void xmlWriter(Catalog catalog) throws DAOException, JAXBException;

    Catalog xmlReader() throws DAOException, JAXBException;
}
