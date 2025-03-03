package org.example.springvulapp.commandinjection.processbuilder_sink;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/commandinjection")
public class Ping02Controller {
    @GetMapping("/ping02")
    public String ping02(@RequestParam("ip") String ip) throws IOException {
        String pingcommand = "ping -c 4 " + ip;
        String[] command = {"/bin/sh", "-c", pingcommand};
        ProcessBuilder pb = new ProcessBuilder(command);
        Process p = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("<br>");
        }
        return sb.toString();
    }
}
