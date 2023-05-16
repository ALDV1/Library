package com.library.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloController(HttpServletRequest request,
                                  Model model){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        model.addAttribute("message", "name: " + name + ", " + age);
        return "first/hello";
    }

    /*@GetMapping("/hello")
    public String helloController(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "age", required = false) Integer age){
        System.out.println("name: " + name + "\name: " + age );
        return "first/hello";
    }*/

    @GetMapping("/goodBye")
    public String goodByeController(){
        return "first/goodBye";
    }
}
