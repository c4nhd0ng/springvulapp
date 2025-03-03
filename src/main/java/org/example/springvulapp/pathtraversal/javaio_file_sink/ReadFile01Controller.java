package org.example.springvulapp.pathtraversal.javaio_file_sink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;


@Controller
@RequestMapping("/pathtraversal/")
public class ReadFile01Controller {
    @GetMapping("/readfile01")
    public String readFile01(@RequestParam(name = "filename", required = false) String filename, Model model) throws IOException {
        if (filename == null || filename.isEmpty()) {
            model.addAttribute("result", "No file specified.");
            return "readfile";
        }
        File file = new File(System.getProperty("user.dir")  + "/public/"+ filename);

        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null){
            content.append(line).append("\n");
        }
        reader.close();
        model.addAttribute("result", content.toString());
        return "readfile";

    }
}
