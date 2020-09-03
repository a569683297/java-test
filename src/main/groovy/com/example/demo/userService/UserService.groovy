package com.example.demo.userService

import com.mongodb.DB
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    DB db
    def createUser(Map params){
        System.out.println(params);
        if(params.get("username") == ""){
            return "用户名不能为空"
        }
        if(params.get("username") == "admin"){
            return "admin是系统用户，不能创建"
        }
        if(params.get("password") == ""){
            return "密码不能为空"
        }
        if(params.get("checkPassword") == ""){
            return "确认密码不能为空"
        }
        if(params.get("password") != params.get("checkPassword")){
            return "两次输入密码不一致"
        }
        if(db.guogaibiaoge.findOne(["name":params.get("username")])){
            return "该用户已经存在"
        }
        db.guogaibiaoge.insert(["name":params.get("username"),"password":params.get("password")]);
        return "添加成功"
    }
    def login(Map params){
        if(db.guogaibiaoge.findOne(["name":params.get("username")]) == null){
            return "该用户不存在"
        }
        if(db.guogaibiaoge.findOne(["name":params.get("username"),"password":params.get("password")]) == null){
            return "用户名或密码错误"
        }
        return ['token':'123454566']
    }

}
