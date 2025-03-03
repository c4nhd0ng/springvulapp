package org.example.springvulapp.ssti.thymeleaf_urlexpression_sink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ssti/")
public class Welcome01Controller {

    @GetMapping("/welcome01")
    public String page01(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }

}
