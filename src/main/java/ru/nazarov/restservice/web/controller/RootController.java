package ru.nazarov.restservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/")
    String dispatcher() {
        return "dispatcher";
    }

    @RequestMapping("/courier")
    String courier() {
        return "courier";
    }
}
