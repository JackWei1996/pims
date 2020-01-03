package com.pims.controller.open;


import com.pims.entity.Attract;
import com.pims.entity.Project;
import com.pims.entity.User;
import com.pims.service.AttractService;
import com.pims.service.ProjectService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Controller("UserProjectController")
@RequestMapping("/user/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private AttractService attractService;

    @RequestMapping("/list")
    public String list() {
        return "/user/projectList";
    }

    @RequestMapping("/applyList")
    public String applyList() {
        return "/user/applyList";
    }

    @RequestMapping("/applyProject")
    public String applyProject(Long id, Model model) {
        model.addAttribute("cId", id);
        return "/user/applyProject";
    }

    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(Project project) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        project.setCompanyId(user.getId());
        return projectService.getAllByLimit(project);
    }

    @RequestMapping("/getApplyList")
    @ResponseBody
    public Object getApplyList(Project project) {
        return projectService.getApplyList(project);
    }

    @RequestMapping("/apply")
    @ResponseBody
    public String apply(Attract attract) {
        try {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();
            List<Attract> list = attractService.getByUserIdAndProId(user.getId(), attract.getProjectId());
            if (list.size()>0){
                return "CCC";
            }
            attract.setUserId(user.getId());
            attract.setCreateTime(new Date());
            attract.setStatus(0+"");
            projectService.apply(attract.getProjectId());
            attractService.apply(attract);
            return "SUCCESS";
        }catch (Exception e){
            return "ERR";
        }

    }
}
