package com.xeay.controller;

import com.xeay.entity.User;
import com.xeay.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * User 的控制类
 */
@Controller
@RequestMapping("")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/searchUser")
    public String findUser(Model model) {
        int userid = 1;
        User user = this.userService.searchUserById(userid);
        model.addAttribute("user", user);
        return "index";
    }
}