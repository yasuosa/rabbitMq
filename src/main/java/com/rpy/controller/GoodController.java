package com.rpy.controller;

import com.rpy.domain.Goods;
import com.rpy.service.GoodsService;
import com.rpy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: rabbitmq-springboot-taobao
 * @description: 商品管理
 * @author: 任鹏宇
 * @create: 2020-12-06 10:20
 **/
@RestController
@RequestMapping("good")
public class GoodController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("list")
    public ResultVo list(){
        List<Goods> data = this.goodsService.list();
        return ResultVo.success("查询成功", data);
    }



}
