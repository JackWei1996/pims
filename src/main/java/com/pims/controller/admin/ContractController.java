package com.pims.controller.admin;


import com.pims.entity.Contract;
import com.pims.entity.Word;
import com.pims.service.ContractService;
import com.pims.utils.MyUtils;
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
@Controller("AdminContractController")
@RequestMapping("/admin/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping("/xq")
    public String xq(Long id, Model model) {
        Contract contract = contractService.getById(id);
        model.addAttribute("title", contract.getTitle());
        model.addAttribute("c", contract.getContent());
        model.addAttribute("time", MyUtils.getDate2String(contract.getCreateTime()).split(" ")[0]);
        model.addAttribute("firstParty", contract.getFirstParty());
        model.addAttribute("secondParty", contract.getSecondParty());
        model.addAttribute("money", contract.getMoney());
        model.addAttribute("sign", contract.getSign());
        return "/sa/xqContract";
    }
    @RequestMapping("/list")
    public String list() {
        return "/sa/contractList";
    }
    @RequestMapping("/addContract")
    public String addContract() {
        return "/sa/contract";
    }


    @ResponseBody
    @RequestMapping("/add")
    public String addContract(Contract contract) {
        try {
            contractService.save(contract);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    @RequestMapping("/getAllByLimit")
    @ResponseBody
    public Object getAllByLimit(Contract contract) {
        return contractService.getAllByLimit(contract);
    }

    @ResponseBody
    @RequestMapping("/del")
    public String delWord(String[] ids) {
        try {
            for (String id : ids){
                contractService.delById(id);
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
