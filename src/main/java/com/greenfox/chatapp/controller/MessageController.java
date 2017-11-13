package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.repository.LogRepo;
import com.greenfox.chatapp.repository.UserRepo;
import com.greenfox.chatapp.service.LogService;
import com.greenfox.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageController {

    @Autowired
    LogRepo logRepo;

    @Autowired
    LogService logService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    /*@RequestMapping("/")
    public String mainPage(){
        return "Peer to Peer App";
    }*/

    /*@GetMapping(value = "/main")
    public String index(){
        return "main";
    }

    @RequestMapping("/")
    public String getHomepage(Model model) {
        model.addAttribute("listUser", userRepo.findAll());
        return "main";
    }*/

    @GetMapping(value = "/main")
    public String chatLog(HttpServletRequest request) {
        logService.enviromentCheck(request);
        return "main";
    }

    @PostMapping("/update")
    public String updateEntry(@ModelAttribute ChatUser user, Model model){
        model.addAttribute("newUser", user);
        if (user.getUsername().equals("")) {
            model.addAttribute("errorMessage", "Add username plzzzz");
            return "enter";
        } else if (user.getUsername().equals("foulmouth")) {
            model.addAttribute("errorMessage2","Bad bad user");
            return "enter";
        }
        userService.saveDataBase(user);
        return "redirect:/";
    }

    @RequestMapping("/enter")
    public String getEnterPage(Model model) {
        model.addAttribute("newUser", userService.getNewUser());
        return "enter";
    }

}
