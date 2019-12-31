package com.pims.controller.admin;


import com.pims.entity.User;
import com.pims.entity.Word;
import com.pims.service.WordService;
import com.pims.service.impl.WordServiceImpl;
import com.pims.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
}
