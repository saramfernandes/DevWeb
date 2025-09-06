package br.com.senai.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testelogin")
public class TesteLoginController {

    @GetMapping("/publico/hello")
    public String hello1() {
        return "Hello word publico";
    }

    @GetMapping("/user/hello")
    public String hello2() {
        return "Hello word user";
    }

    @GetMapping("/admin/hello")
    public String hello3() {
        return "Hello word admin";
    }

}
