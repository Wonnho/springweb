package org.springweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springweb.dto.TodoDTO;
import org.springweb.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;


//    @RequestMapping("/list")
//    public void list() {
//        log.info("todo list......");
//
//    }


//    @RequestMapping(value="/register",method= RequestMethod.GET)
//    public void register() {
//        log.info("todo register....");
//    }

    @GetMapping("/register")
    public void registerGET() {
        log.info("Get todo register...........");
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST todo register............");

        if(bindingResult.hasErrors()) {
            log.info("has errors happens....");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping("/paramAuto2")
    public void paramAuto2(@RequestParam(name="name",defaultValue = "Guest") String name,
                           @RequestParam(name="age",defaultValue = "22") int age) {
        log.info("collect parameter by default");
        log.info("name: " +name);
        log.info("age: " +age);

    }

    @RequestMapping("/list")
    public void list(Model model) {
        log.info("todo list ..........");
        model.addAttribute("dtoList",todoService.getAll());
    }

    @GetMapping("/read")
    public void read(Long tno,Model model) {
        TodoDTO todoDTO=todoService.getOne(tno);
        log.info(("read a record.............."));
        model.addAttribute("dto",todoDTO);
    }
}
