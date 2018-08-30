package jaxb;

import bean.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXB implements IJAXB {
    final static String PATH = System.getProperty("user.dir") + "/src/main/resources/catalog.xml";

    public Catalog xmlReader() {
        try {
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Catalog) unmarshaller.unmarshal(new File(PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void xmlWriter(Catalog catalog) {
        try {
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = context.createMarshaller();

            //for format xml file
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(catalog, new File(PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
