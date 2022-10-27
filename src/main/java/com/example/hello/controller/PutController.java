package com.example.hello.controller;

import com.example.hello.domain.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PostMapping(value = "/domain4")
    public ResponseEntity<MemberDto> putExample(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
