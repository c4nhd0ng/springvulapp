package org.example.springvulapp.insecuredeserialize.objectinputstream_sink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

@Controller
@RequestMapping("/insecuredeserialize")
public class Deserialize01Controller {
    @GetMapping("/deser01")
    public String deser01() {
        return "deser";
    }
    @PostMapping("/deser01")
    public String deser01(@RequestParam("serializeData") String input, Model model) throws IOException, ClassNotFoundException {
        byte[] bytes = Base64.getDecoder().decode(input);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = ois.readObject();
        ois.close();
        bais.close();
        model.addAttribute("output", obj.toString());
        return "deser";
    }
}
