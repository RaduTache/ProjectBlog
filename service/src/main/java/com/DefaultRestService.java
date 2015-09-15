package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by root on 9/10/15.
 */
@Controller
public class DefaultRestService {

    @RequestMapping("/")
    public String handleRequest(){
        return "index.jsp";
    }
}
