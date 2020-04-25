package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tensqureStudy
 * @author: liumq
 * @create: 2020-04-24 21:00
 **/
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Spit> all = spitService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", all);

    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.GET)
    public Result findOne(@PathVariable String spitId) {
        Spit data = spitService.findById(spitId);
        return new Result(true, StatusCode.OK, "查询成功", data);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result sava(@RequestBody Spit spit) {
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
    public Result update(@RequestBody Spit spit, @PathVariable String spitId) {
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String spitId) {
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result findByParentid(@PathVariable String parentid, @PathVariable Integer page, @PathVariable Integer size) {
        Page<Spit> pageData = spitService.findByParentid(parentid, page, size);

        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Spit>(pageData.getTotalElements(), pageData.getContent()));
    }

    @RequestMapping(value = "/thumbup/{spitId}", method = RequestMethod.PUT)
    public Result  thumbup(@PathVariable String spitId)
    {
        String userid = "111";
        //判断当前用户是否已经点赞
        if (redisTemplate.opsForValue().get("thumbup_"+userid)!=null)
        {
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        spitService.thumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_"+userid,1);
         return new Result(true, StatusCode.OK, "点赞成功");
    }


}
