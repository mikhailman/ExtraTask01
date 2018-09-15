package by.htp.verishko.task1.dao;

import by.htp.verishko.task1.bean.News;
import by.htp.verishko.task1.bean.criteria.Criteria;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface CatalogDAO {
    List<News> find(Criteria criteria) throws DAOException, JAXBException;
    News add(News news) throws DAOException, JAXBException;
}
