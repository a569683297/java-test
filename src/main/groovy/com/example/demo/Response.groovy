package com.example.demo

class Response {
    def ok(String message){
        def result = [:];
        result.put('code',0);
        result.put('message',message);
        result.put('data',[:]);

        return result
    }
    def ok(String message,Map map){
        println(message);
        def result = [:];
        result.put('code',0);
        if(message){
            result.put('message',message);
        }else{
            result.put("message","success");
        }
        if(map){
            map = [:]
        }
        result.put('data',map);

        return result
    }
    def error(int code,String errorMessage){
        def result = [:]
        result.put("code",code);
        if(!errorMessage){
            errorMessage = ""
        }
        result.put("message",errorMessage);
        return result
    }
    def error(int code,String errorMessage,Map map){
        def result = [:]
        if(!errorMessage){
            errorMessage = ""
        }
        if(!map){
            map = [:]
        }
        result.put("code",code);
        result.put("message",errorMessage);
        result.pur("data",map);
        return result
    }
}
