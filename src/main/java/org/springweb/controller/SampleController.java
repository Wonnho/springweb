package org.springweb.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
