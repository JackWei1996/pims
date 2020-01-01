package com.pims.controller.company;


import com.pims.entity.Company;
import com.pims.entity.Complaint;
import com.pims.entity.User;
import com.pims.service.CompanyService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Controller("Company")
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public String list() {
        return "/user/companyList";
    }
    @RequestMapping("/addCompany")
    public String addCompany() {
        return "/user/addCompany";
    }

    @RequestMapping("/getAllCompanyByLimit")
    @ResponseBody
    public Object getAllCompanyByLimit(Company company) {
        if (company==null){
            company = new Company();
        }
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        company.setUserId(user.getId());
        return companyService.getAllCompanyByLimit(company);
    }

    @ResponseBody
    @RequestMapping("/delCompany")
    public String delWord(String[] ids) {
        try {
            for (String id : ids){
                companyService.delById(id);
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(Company company) {
        company.setStatus(0);
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        company.setUserId(user.getId());
        company.setCreateTime(new Date());
        company.setViewCount(0);
        try {
            companyService.save(company);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
