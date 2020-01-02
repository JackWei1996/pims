package com.pims.controller.open;

import com.pims.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jack魏
 * @since 2019-12-31 12:03 PM
 */
@Controller("OpenHome")
@RequestMapping()
public class HomeController {
    @RequestMapping(value = "/yqjs")
    public String yqjs(Model model) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("uname", user.getName());
        return "yqjs";
    }
}
