package by.htp.verishko.task1.controller;

import by.htp.verishko.task1.bean.*;
import by.htp.verishko.task1.dao.DAOException;
import by.htp.verishko.task1.dao.impl.JAXB;

import javax.xml.bind.JAXBException;

public class Controller {
    public static void main(String[] args) throws JAXBException, DAOException {
        // работа JAXB
        JAXB parser = new JAXB();
        Catalog catalog = parser.xmlReader();
        parser.xmlWriter(catalog);
        System.out.println("________________________________________________________________________________________");

        System.out.println("Operation read done!");
    }
}
