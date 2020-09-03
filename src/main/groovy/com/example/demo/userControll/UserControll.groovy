package com.example.demo

import com.example.demo.userService.UserService
import com.mongodb.DB
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/user")
class User {
    @Autowired
    UserService userService
    @PostMapping("/create")
    @ResponseBody
    def createUser(@RequestBody Map params){
            String rs = this.userService.createUser(params)
            return new Response().ok(rs);
    }
    @PostMapping("/login")
    @ResponseBody
    def login(@RequestBody Map params){
            Map rs = this.userService.login(params)
            return new Response().ok("",rs);
    }
}
