package com.zingfront.controller;

import com.zingfront.bean.ResultBean;
import com.zingfront.service.MapHasgoService;
import com.zingfront.service.MapPlangoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;

@Controller
public class ResumeController {

    @Autowired
    private MapHasgoService mapHasgoService;
    @Autowired
    private MapPlangoService mapPlangoService;

    @RequestMapping(value = "/getResume.do")
    public ResultBean getResume(Integer userid) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/static/myresume.doc");
        return new ResultBean();
    }

}
