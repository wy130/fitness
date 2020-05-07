package cn.njxz.fitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yue.wu
 * @Description
 * @date 2020/4/13 18:33
 */
@Controller
@RequestMapping("/record")
public class RecordController {

    @RequestMapping("/addOrRemoveRecord")
    @ResponseBody
    public String addOrRemoveRecord(){
       return null;
    }




}
