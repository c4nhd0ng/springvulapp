package org.example.springvulapp.commandinjection.runtime_sink;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/commandinjection")
public class Ping01Controller {
    @GetMapping("/ping01")
    public String ping01(@RequestParam("ip") String ip) throws IOException {
        String pingcommand = "ping -c 4 " + ip;
        String[] command = {"/bin/sh", "-c", pingcommand};
        Process process = Runtime.getRuntime().exec(command);

        // Đọc kết quả từ terminal
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line).append("<br>");
        }
        return output.toString();
    }
}
