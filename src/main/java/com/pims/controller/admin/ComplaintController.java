package com.pims.controller.admin;


import com.pims.entity.Company;
import com.pims.entity.Complaint;
import com.pims.entity.ComplaintExample;
import com.pims.mapper.ComplaintMapper;
import com.pims.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Controller("AdminComplaint")
@RequestMapping("/admin/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("/xq")
    public String xq(Long id, Model model) {
        Complaint complaint = complaintService.getById(id);
        model.addAttribute("item", complaint);
        return "/sa/xqComplaint";
    }

    @RequestMapping("/list")
    public String list() {
        return "/sa/complaintList";
    }

    @RequestMapping("/doComplaint")
    public String doComplaint(Long id, Model model) {
        model.addAttribute("cId", id);
        return "/sa/doComplaint";
    }

    @RequestMapping("/getAllCompanyByLimit")
    @ResponseBody
    public Object getAllCompanyByLimit(Complaint complaint) {
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
    @RequestMapping("/update")
    public String update(Complaint complaint) {
        try {
            complaintService.updateById(complaint);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
