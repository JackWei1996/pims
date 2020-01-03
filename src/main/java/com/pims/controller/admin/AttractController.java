package com.pims.controller.admin;


import com.pims.entity.Attract;
import com.pims.entity.Project;
import com.pims.entity.User;
import com.pims.service.AttractService;
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
 *  招商信息
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Controller("AdminAttract")
@RequestMapping("/admin/attract")
public class AttractController {
    @Autowired
    private AttractService attractService;

    @RequestMapping("/xq")
    public String xq(Long id, Model model) {
        Attract attract = attractService.getById(id);
        model.addAttribute("item", attract);
        return "/sa/xqAttract";
    }

    @RequestMapping("/list")
    public String list() {
        return "/sa/attractList";
    }

    @RequestMapping("/doAttract")
    public String doComplaint(Long id, Model model) {
        model.addAttribute("cId", id);
        return "/sa/doAttract";
    }

    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(Attract attract) {
        return attractService.getAllByLimit(attract);
    }

    @ResponseBody
    @RequestMapping("/del")
    public String delWord(String[] ids) {
        try {
            for (String id : ids){
                attractService.delById(id);
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(Attract attract) {
        try {
            attractService.updateById(attract);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
