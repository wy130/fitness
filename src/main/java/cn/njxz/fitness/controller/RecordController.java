package cn.njxz.fitness.controller;

import cn.njxz.fitness.constants.Constants;
import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.model.Record;
import cn.njxz.fitness.model.RecordVO;
import cn.njxz.fitness.model.User;
import cn.njxz.fitness.service.CourseService;
import cn.njxz.fitness.service.IRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    @Autowired
    private CourseService courseService;

    @PostMapping("/reserve")
    @ResponseBody
    public HashMap reserve(Integer cId, Boolean flag, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user= (User)session.getAttribute("user");
        HashMap map = new HashMap(2);
        if(null!=user){
            int uid = user.getUId();
            if(cId!=null){
                //未预约，进入预约
                Record record = new Record();
                record.setrCId(cId);
                record.setrUId(uid);
                record.setrTime(LocalDateTime.now());
                Record record1 = recordService.findRecordByUidAndCid(uid,cId);
                if (flag==false){
                    if(record1==null) {
                        int insertResult = recordService.addRecord(record);
                        if (insertResult > Constants.OPERATE_FAILURE) {
                            map.put("msg", "ok");
                            map.put("flag", true);
                            return map;
                        }
                    }
                }else if(flag==true){
                    //取消预约
                    if(record1!=null) {
                        int deleteResult = recordService.deleteRecord(record1.getrId());
                        if (deleteResult > Constants.OPERATE_FAILURE) {
                            map.put("msg", "ok");
                            map.put("flag", false);
                            return map;
                        }
                    }
                }
            }
        }

        return map;
    }

    @GetMapping("/findAllRecord")
    public String findAllRecord(HttpServletRequest request,@RequestParam(defaultValue="1")Integer pageNum) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(pageNum, 8);
        List<Record> records = recordService.findRecordByUid(user.getUId());
        List<RecordVO> recordVOList = new ArrayList<>();
        records.stream().forEach(e -> {
            RecordVO recordVO = new RecordVO();
            Course course = courseService.findCourseById(e.getrCId());
            BeanUtils.copyProperties(course,recordVO);
            recordVO.setRId(e.getrId());
            recordVOList.add(recordVO);
        });
        if (records != null) {
            PageInfo<RecordVO> pageInfo = new PageInfo<>(recordVOList);
            request.setAttribute("pageInfo", pageInfo);
        }
        return "templates/record";
    }

    @GetMapping("/cancelCourse")
    public String cancelCourse(HttpServletRequest request,@RequestParam("rId")Integer rId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Record record = new Record();
        if(rId!=null){
            record = recordService.findRecordById(rId);
        }
        if(record.getrUId().equals(user.getUId())) {
            recordService.deleteRecord(rId);
        }
        return "redirect:/record/findAllRecord";
    }


}
