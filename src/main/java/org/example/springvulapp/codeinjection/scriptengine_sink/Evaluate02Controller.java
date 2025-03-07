package org.example.springvulapp.codeinjection.scriptengine_sink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Controller
@RequestMapping("/codeinjection/")
public class Evaluate02Controller {
    @GetMapping("/evaluate02")
    public String evaluate02(@RequestParam(name="expression", required = false) String input, Model mode) throws ScriptException {
        if (input == null) {
            return "evaluate";
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn"); // Dùng Rhino hoặc Nashorn ngoài ra còn các kiểu khác như jython..

        // 🚨 NGUY HIỂM: Đầu vào từ user không được kiểm soát

        Object result = engine.eval(input);
        System.out.println(result);
        mode.addAttribute("greet", result);
        return "evaluate";
    }
}
