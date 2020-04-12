package com.examly.gst_billing_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index.html";
    }

    @RequestMapping("/product")
    public String product(){
        return "product.jsp";
    }

}
