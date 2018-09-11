package by.htp.verishko.task1.service;

import by.htp.verishko.task1.bean.News;
import by.htp.verishko.task1.bean.criteria.Criteria;

import java.util.List;

public interface ICatalogService {

    List<News> find(Criteria criteria) throws ServiceException;

    News add(Criteria criteria) throws ServiceException;
}
