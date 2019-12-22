package com.zingfront.controller;

import com.zingfront.bean.ResultBean;
import com.zingfront.entity.MapHasgo;
import com.zingfront.entity.MapPlango;
import com.zingfront.service.MapHasgoService;
import com.zingfront.service.MapPlangoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MapController {

    @Autowired
    private MapHasgoService mapHasgoService;
    @Autowired
    private MapPlangoService mapPlangoService;

    @RequestMapping("/getHasGoPosition.do")
    public ResultBean getHasGoPosition(Integer userid) throws Exception {
        if (userid == null){
            return new ResultBean(ResultBean.FAIL,"用户不存在",null);
        }
        List<MapHasgo> list = mapHasgoService.selectByUserId(userid);
        return new ResultBean(list);
    }

    @RequestMapping("/getPlanGoPosition.do")
    public ResultBean getPlanGoPosition(Integer userid) throws Exception {
        if (userid == null){
            return new ResultBean(ResultBean.FAIL,"用户不存在",null);
        }
        List<MapPlango> list = mapPlangoService.selectByUserId(userid);
        return new ResultBean(list);
    }

    @RequestMapping("/savePlan.do")
    public ResultBean savePlan(MapPlango plan) throws Exception {
        if (plan == null){
            return new ResultBean(ResultBean.FAIL,"数据不能为空",null);
        }

        MapHasgo mapHasgo = mapHasgoService.selectByUserIdAndProvince(plan.getUserid(), plan.getProvince());
        if (mapHasgo != null){
            return new ResultBean(ResultBean.FAIL,"您已经去过此地了，不能再添加旅行计划",null);
        }
        MapPlango mapPlango = mapPlangoService.selectByUserIdAndProvince(plan.getUserid(), plan.getProvince());
        if (mapPlango != null){
            return new ResultBean(ResultBean.FAIL,"您已添加过该旅行计划",null);
        }

        int i = mapPlangoService.insertPlanGo(plan);
        System.out.println(i);
       if (i > 0){
            return new ResultBean("添加成功");
        }else{
            return new ResultBean(ResultBean.FAIL,"添加失败",null);
        }
    }

}
