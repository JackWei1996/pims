package com.pims.controller.open;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jack魏
 * @since 2019-12-31 12:03 PM
 */
@Controller("OpenHome")
@RequestMapping()
public class HomeController {
    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }
}
