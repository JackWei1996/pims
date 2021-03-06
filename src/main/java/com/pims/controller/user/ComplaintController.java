package com.pims.controller.user;


import com.pims.entity.Complaint;
import com.pims.entity.User;
import com.pims.service.ComplaintService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Controller("UserComplaint")
@RequestMapping("/user/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("/addComplaint")
    public String addComplaint() {
        return "/user/addComplaint";
    }
    @RequestMapping("/list")
    public String list() {
        return "/user/complaintList";
    }

    @RequestMapping("/getAllCompanyByLimit")
    @ResponseBody
    public Object getAllCompanyByLimit(Complaint complaint) {
        if (complaint==null){
            complaint = new Complaint();
            complaint.setType(2);
        }
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        complaint.setUserId(user.getId());
        return complaintService.getAllComplaintByLimit(complaint);
    }

    @ResponseBody
    @RequestMapping("/delComplaint")
    public String delComplaint(String[] ids) {
        try {
            for (String id : ids){
                complaintService.delById(id);
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    @ResponseBody
    @RequestMapping("/add")
    public String update(Complaint complaint) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        complaint.setUserId(user.getId());
        complaint.setStatus(0);
        complaint.setCreateTime(new Date());
        complaint.setUserName(user.getName());
        complaint.setType(2);
        try {
            complaintService.save(complaint);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

}
