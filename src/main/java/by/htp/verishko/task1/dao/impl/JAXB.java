package by.htp.verishko.task1.dao.impl;

import by.htp.verishko.task1.bean.Catalog;
import by.htp.verishko.task1.dao.DAOException;
import by.htp.verishko.task1.dao.IJAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXB implements IJAXB {
    private final static String PATH = System.getProperty("user.dir") + "/src/main/resources/catalog.xml";

    public Catalog xmlReader() throws DAOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Catalog) unmarshaller.unmarshal(new File(PATH));
    }

    public void xmlWriter(Catalog catalog) throws DAOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(catalog, new File(PATH));
        System.out.println(catalog.getCategory().size());
    }
}