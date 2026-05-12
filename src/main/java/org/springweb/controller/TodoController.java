package org.springweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springweb.dto.PageRequestDTO;
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

//    @RequestMapping("/list")
//    public void list(Model model) {
//        log.info("todo list ..........");
//        model.addAttribute("dtoList",todoService.getAll());
//    }

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO,BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()) {
            pageRequestDTO=PageRequestDTO.builder().build();

        }
        model.addAttribute("responseDTO",todoService.getList(pageRequestDTO));

    }

    @GetMapping({"/read","/modify"})
    public void read(Long tno,PageRequestDTO pageRequestDTO,Model model) {
        TodoDTO todoDTO=todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto",todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno,RedirectAttributes redirectAttributes) {
        log.info("==========remove==========");
        log.info("tno: " + tno);

        todoService.remove(tno);

        return "redirect:/todo/list";

    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                        BindingResult bindingResult,
                         RedirectAttributes redirectAttributes)
     {
         if(bindingResult.hasErrors()) {
             log.info("has errors............");
             redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
             redirectAttributes.addAttribute("tno",todoDTO.getTno());
             return "redirect:/todo/modify";
         }
         log.info(todoDTO);
         todoService.modify(todoDTO);
         return "redirect:/todo/list";

    }


}
