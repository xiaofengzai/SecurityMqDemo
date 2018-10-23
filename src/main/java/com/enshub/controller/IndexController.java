package com.enshub.controller;

import com.enshub.model.User;
import com.enshub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ResponseBody
    @RequestMapping("/index")
    public void login(HttpServletRequest request) {
        System.out.println("登录成功");
    }

    @ResponseBody
    @PostMapping("/registry")
    public void registry(User user) {
        userRepository.save(new User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword())));
    }

    @GetMapping("/registry")
    public String  registryForm() {
        return "registry";
    }

    @GetMapping("/login")
    public String  loginForm() {
        return "login";
    }
}
