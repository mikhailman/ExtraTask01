package by.htp.verishko.task1.service;

import by.htp.verishko.task1.bean.Catalog;

public interface IJAXBService {

    Catalog xmlReader() throws ServiceException;

    void xmlWriter(Catalog catalog) throws ServiceException;
}
