package org.example.springvulapp.ssrf.spring_resttemplate_sink;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/SSRF")
public class FetchUrl01Controller {
    @GetMapping("/fetch")
    public String fetchUrl(@RequestParam String url) {
        RestTemplate restTemplate = new RestTemplate();


        String response = restTemplate.getForObject(url, String.class);

        return "Fetched content: " + response;
    }
}
