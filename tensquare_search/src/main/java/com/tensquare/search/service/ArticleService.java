package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * @program: tensqureStudy
 * @author: liumq
 * @create: 2020-04-27 20:42
 **/
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    public void save(Article article) {
        article.setId(idWorker.nextId() + "");
        articleDao.save(article);
    }
}
