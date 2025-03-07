package org.example.springvulapp.insecuredeserialize.xstream_sink;

import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;

@Controller
@RequestMapping("/insecuredeserialize")
public class Deserialize03Controller {
    @GetMapping("/deser03")
    public String deser03() {
        return "deser";
    }
    @PostMapping("/deser03")
    public String deser03(@RequestParam("serializeData") String input, Model model) throws IOException, ClassNotFoundException {
        XStream xstream = new XStream();

        // 🚨 NGUY HIỂM: Cho phép tất cả các class mà không giới hạn
        xstream.addPermission(com.thoughtworks.xstream.security.AnyTypePermission.ANY);
        xstream.allowTypesByWildcard(new String[]{"*"});

        // an toàn:
        // xstream.allowTypes(new Class[]{<Safe_class>.class});
        // Deserialize XML đầu vào
        Object obj = xstream.fromXML(input);
        model.addAttribute("output", obj);
        return "deser";
    }
}
