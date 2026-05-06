package org.springweb.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        log.info("Hello............");
        return "hello";
    }

    @GetMapping("/localdate")
    public void localDate(LocalDate localDate) {
        log.info("local Date is ...............");
        log.info("Local Date: " + localDate);
    }
    @GetMapping("/model")
    public void model(Model model) {
        log.info("process data by model...........");
        model.addAttribute("message","exploit Model");
    }

    @GetMapping("/redirecting")
    public String redirecting(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name","Redirecting by PRG");
        redirectAttributes.addFlashAttribute("result","flash success");

        return "redirect:/redirected";
    }

    @GetMapping("/redirected")
    public void redirected() {

    }

    @GetMapping("/except")
    public void except(String sam,int age) {
        log.info("name..." +sam);
        log.info("age ............" +age);
    }

}
