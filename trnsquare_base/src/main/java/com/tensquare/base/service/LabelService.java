package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.tensquare
 * @author: liumq
 * @create: 2020-04-18 13:31
 **/
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label) {
        //sava可以做update 对象中有id 则update
        labelDao.save(label);
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {


        List<Label> result = labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 跟对象， 也就是要把条件封装到那个对象中。where 类名=label.getid()
             * @param criteriaQuery 封装的都是查询关键字 groupby orderby 之类的
             * @param criteriaBuilder 用来封装条件对象的
             * @return 返回null 表示不需要任何条件
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {


                ArrayList<Predicate> list = new ArrayList<>();


                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");// where labelname like '%{label.getlabelName}%'
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                // new 一个数组 作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                parr = list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        });

        return result;
    }
}
