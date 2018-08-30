package jaxb;

import bean.Catalog;

public interface IJAXB {
    void xmlWriter(Catalog catalog);

    Catalog xmlReader();
}
