package com.pims.controller.admin;


import com.pims.entity.Company;
import com.pims.entity.Project;
import com.pims.entity.User;
import com.pims.service.CompanyService;
import com.pims.service.ProjectService;
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
@Controller("CompanyProject")
@RequestMapping("/admin/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/addProject")
    public String addProject() {
        return "/user/addProject";
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(Project project) {
        project.setStatus(0+"");
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        project.setCompanyId(user.getId());
        project.setCreateTime(new Date());
        project.setViewCount(0);
        project.setApplyCount(0);
        try {
            projectService.save(project);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    @RequestMapping("/xq")
    public String xq(Long id, Model model) {
        Project project = projectService.getById(id);
        projectService.view(id);
        model.addAttribute("item", project);
        return "/sa/xqProject";
    }

    @RequestMapping("/list")
    public String list() {
        return "/sa/projectList";
    }

    @RequestMapping("/doProject")
    public String doComplaint(Long id, Model model) {
        model.addAttribute("cId", id);
        return "/sa/doProject";
    }

    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(Project project) {
        return projectService.getAllByLimit(project);
    }

    @ResponseBody
    @RequestMapping("/del")
    public String delWord(String[] ids) {
        try {
            for (String id : ids){
                projectService.delById(id);
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(Project project) {
        try {
            projectService.updateById(project);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
