package com.example.demo

import com.mongodb.DB
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class Test {
    @Autowired
    DB db
    @GetMapping("/sys/login")
    @ResponseBody
    def login(@RequestParam(value = "id",required = true) String id,@RequestParam(value = "name",required = true) String name){
        def testMap = ["id":"123","name":"gjy"];
        def dbMap = db.guogaibiaoge.findOne(["name":"guogai"])
        def dbMaps = []

        db.guogaibiaoge.find().each {
            v ->
//                System.out.println(v)
                dbMaps.add(v)
        }
        System.out.println(dbMaps[1])
        if(id == "" || name == ""){
            return "请检查参数"
        }
        if(name == "admin"){
            return "管理员"
        }
        if(name != "admin" && name != testMap.get("name")){
            return "用户名不存在"
        }
        if(id != testMap.get(id)){
            return "密码错误"
        }

//        Map rs = [:]
//        rs.put("id",id)
//        rs.put("name",name)
        return "请求成功"
    }
}
