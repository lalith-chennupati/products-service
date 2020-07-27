package com.salaboy.lke;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
class ProductServiceRestController{
    @Value("${version:0.0.0}")
    private String version;

    @GetMapping("info")
    public String info(){
        return "V"+version;
    }

}

@Controller
class SiteController {
    @Value("${version:0.0.0}")
    private String version;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("version", version);
        return "index";
    }




}
