package com.pims.controller.admin;


import com.pims.entity.Company;
import com.pims.entity.User;
import com.pims.entity.UserParameter;
import com.pims.entity.Word;
import com.pims.service.WordService;
import com.pims.service.impl.WordServiceImpl;
import com.pims.utils.MD5;
import com.pims.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
@Controller("AdminWord")
@RequestMapping("/admin/word")
public class WordController {
    private WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping("/xq")
    public String xq(Long id, Model model) {
        wordService.view(id);
        Word word = wordService.getById(id);
        System.out.println(word.getContent());
        model.addAttribute("c", word.getContent());
        model.addAttribute("title", word.getTitle());
        model.addAttribute("view", word.getViewCount());
        model.addAttribute("time", MyUtils.getDate2String(word.getCreateTime()));
        return "/sa/xqWord";
    }
    @RequestMapping("/list")
    public String list() {
        return "/sa/wordList";
    }
    @RequestMapping("/publish")
    public String delUserPage() {
        return "/sa/word";
    }

    @ResponseBody
    @RequestMapping("/addWord")
    public String addWord(Word word) {
        try {
            word.setCreateTime(new Date());
            word.setViewCount(0);
            wordService.save(word);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }

    @RequestMapping("/getAllWordByLimit")
    @ResponseBody
    public Object getAllWordByLimit(Word word) {
        return wordService.getAllWordByLimit(word);
    }

    @ResponseBody
    @RequestMapping("/delWord")
    public String delWord(String[] ids) {
        try {
            for (String id : ids){
                wordService.delById(id);
            }
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
    }
}
