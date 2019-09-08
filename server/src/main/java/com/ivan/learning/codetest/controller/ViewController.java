package com.ivan.learning.codetest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ViewController {

    @RequestMapping({ "/home", "/weather"})
    public String index() {
        return "forward:/index.html";
    }
}