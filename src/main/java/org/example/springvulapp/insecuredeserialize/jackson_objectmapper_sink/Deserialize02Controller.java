package org.example.springvulapp.insecuredeserialize.jackson_objectmapper_sink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/insecuredeserialize/")
public class Deserialize02Controller {
    @GetMapping("/deser02")
    public String deser02() {
        return "deser";
    }
    @PostMapping("/deser02")
    public String deser02(@RequestParam("serializeData") String input, Model model, Map map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        Object obj = mapper.readValue(input, Object.class);
        // default constructor duoc goi va setter cua thuoc tinh duoc cung cap duoc goi
        model.addAttribute("output", obj.toString());
        return "deser";
    }

}
