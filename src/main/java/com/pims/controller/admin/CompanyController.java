package com.pims.controller.admin;


import com.pims.entity.Company;
import com.pims.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Controller("AdminCompany")
@RequestMapping("/admin/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public String list() {
        return "/sa/companyList";
    }

    @RequestMapping("/getAllCompanyByLimit")
    @ResponseBody
    public Object getAllCompanyByLimit(Company company) {
        return companyService.getAllCompanyByLimit(company);
    }

    @ResponseBody
    @RequestMapping("/delWord")
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
}
