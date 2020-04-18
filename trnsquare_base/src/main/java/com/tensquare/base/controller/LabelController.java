package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * @program: com.tensquare
 * @author: liumq
 * @create: 2020-04-18 10:31
 **/
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Label> all = labelService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", all);
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId) {
        Label data = labelService.findById(labelId);
        return new Result(true, StatusCode.OK, "查询成功", data);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId) {

        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }


    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> resultData=labelService.findSearch(label);
        return  new Result(true,StatusCode.OK,"查询成功",resultData);
    }

}
