package com.example.hello.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDaoDto {
    private String id;
    private String name;
    private String password;
}
