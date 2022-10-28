package com.example.hello.controller;

import com.example.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample1(){
        return "Hello Post API";
    }

    @RequestMapping(value = "/domain2")
    public String postExample2(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value = "/domain3")
    public String postExample3(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
}
