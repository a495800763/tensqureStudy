package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * @program: tensqureStudy
 * @author: liumq
 * @create: 2020-04-24 20:55
 **/
@Service
@Transactional
public class SpitService {
    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    public void save(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
        spit.setPublishtime(new Date());
        spit.setVisits(DEFAULT_COUNT);
        spit.setShare(DEFAULT_COUNT);
        spit.setThumbup(DEFAULT_COUNT);
        spit.setComment(DEFAULT_COUNT);
        spit.setState("1");

        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            // 如果存在上级id 评论
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }

        spitDao.save(spit);
    }

    public void update(Spit spit) {
        spitDao.save(spit);
    }

    public void deleteById(String id) {
        spitDao.deleteById(id);
    }


    public Page<Spit> findByParentid(String parentid, int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid, pageable);
    }

    public void thumbup(String spitId) {
        //方式一 逻辑没问题 效率有问题 与数据库交互太多次
        //Spit spit = spitDao.findById(spitId).get();
        //spit.setThumbup(spit.getThumbup() == null ? 1 : spit.getThumbup() + 1);
        //spitDao.save(spit);

        //方式二 使用原生mongodb 命令实现自增
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(spitId));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }

    private static final  Integer DEFAULT_COUNT = 0;
}
