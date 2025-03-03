package org.example.springvulapp.codeinjection.spel_sink;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/codeinjection/")
public class Evaluate01Controller {
    @GetMapping("/evaluate01")
    public String greet01(@RequestParam(name="expression", required = false) String input, Model model) {
        ExpressionParser parser = new SpelExpressionParser();
        String greet = parser.parseExpression(input).getValue(String.class);
        model.addAttribute("greet", greet);
        return "evaluate";
    }
}
