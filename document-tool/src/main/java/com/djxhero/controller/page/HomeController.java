package com.djxhero.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/29 14:02
 **/

@Controller
public class HomeController {
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String page(){
        return "index";
    }


}
