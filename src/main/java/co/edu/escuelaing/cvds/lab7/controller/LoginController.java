package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.model.UserRole;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String login() {
        return "login/login";
    }

    @GetMapping("register")
    public String register() {
        return "login/register";
    }

    @PostMapping("register")
    public String registerSubmit(@RequestParam Map<String, String> parameters) {
        User user = new User(
                parameters.get("email"),
                parameters.get("password"),
                Arrays.asList(UserRole.CLIENTE)
        );
        userRepository.save(user);
        return "redirect:/login";
    }

}
