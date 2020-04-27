package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @program: tensqureStudy
 * @author: liumq
 * @create: 2020-04-27 20:41
 **/
public interface ArticleDao extends ElasticsearchRepository<Article,String> {
}
