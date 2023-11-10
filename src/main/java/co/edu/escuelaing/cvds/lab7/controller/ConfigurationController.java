package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ConfigurationController {

    @Autowired
    ConfigurationService configurationService;

    @GetMapping("/example")
    public String example(Model model) {
        model.addAttribute("premio", configurationService.getPremio());
        return "example";
    }

    @GetMapping("/example/api")
    public String exampleApi() {
        return "example-api";
    }

    @GetMapping("/example/api/configurations")
    @ResponseBody
    public List<Configuration> exampleApiConfigurations() {
        return configurationService.getAllConfigurations();
    }

    @PostMapping("/example/api/configurations")
    @ResponseBody
    public List<Configuration> exampleApiConfigurations(@RequestBody Configuration configuration) {
        configurationService.addConfiguration(configuration);
        return configurationService.getAllConfigurations();
    }
}
