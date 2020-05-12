package cn.njxz.fitness.controller;

import cn.njxz.fitness.constants.Constants;
import cn.njxz.fitness.model.Record;
import cn.njxz.fitness.model.User;
import cn.njxz.fitness.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author yue.wu
 * @Description
 * @date 2020/4/13 18:33
 */
@Controller
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private IRecordService recordService;

    @PostMapping("/reserve")
    @ResponseBody
    public String reserve(Integer cId, Boolean flag, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user= (User)session.getAttribute("user");
        if(null!=user){
            int uid = user.getUId();
            if(cId!=null){
                //未预约，进入预约
                Record record = new Record();
                record.setrCId(cId);
                record.setrUId(uid);
                record.setrTime(LocalDateTime.now());
                if (flag==false){
                    int insertResult =recordService.addRecord(record);
                    if (insertResult > Constants.OPERATE_FAILURE) {
                        return "{\"msg\":\"ok\"}";
                    }
                }else if(flag==true){
                    //取消预约
                    Record record1 = recordService.findRecordByUidAndCid(uid,cId);
                    int deleteResult = recordService.deleteRecord(record1.getrId());
                    if (deleteResult > Constants.OPERATE_FAILURE) {
                        return "{\"msg\":\"ok\"}";
                    }
                }
            }
        }

        return "{\"msg\":\"no\"}";
    }




}
