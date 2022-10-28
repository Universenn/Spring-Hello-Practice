package com.example.hello.controller;

import com.example.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
// log 추가하는 annotation
@Slf4j
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        log.info("hello 으로 요청이 들어왔습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){
        log.info("getname 으로 요청이 들어왔습니다.");
        return "juwan";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        log.info("getVariable 으로 요청이 들어왔습니다. variable : {}",variable);
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getVariable1(@RequestParam String name,@RequestParam String email, @RequestParam String organiz) {
        return String.format("%s %s %s", name, email, organiz);
    }

    @GetMapping(value =  "/request2")
    public String getVariable2(@RequestParam Map<String, String> param){
        param.entrySet().forEach((map) ->{
            System.out.printf("key : %s value : %s \n", map.getKey(),map.getValue());
        });
        return "request2가 호출 완료 되었습니다.";
    }

    @GetMapping(value = "/request3")
    public String getVariable3(MemberDto memberDto) {
        return memberDto.toString();
    }

//    @GetMapping(value = "/request2")
//    public String getVariable1(@PathVariable String name,@PathVariable String email, @PathVariable String organiz) {
//        return String.format("%s %s %s", name, email, organiz);
//    }

//    @GetMapping(value = "/variable1/{variable}")
//    public String getVariable1(@PathVariable String variable){
//        return variable;
//    }
//
//    @GetMapping(value = "/variable2/{variable}")
//    public String getVariable2(@PathVariable String var){
//        return var;
//    }
}
