package com.example.hello.domain.dto;

public class MemberDto {
    private String name;
    private String email;
    private String organization;

//    private int age;


//    public MemberDto(String name, String email, String organization, Integer age) {
//        this.name = name;
//        this.email = email;
//        this.organization = organization;
//        this.age = age;
//    }

    public MemberDto(String name, String email, String organization) {
        this.name = name;
        this.email = email;
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

//    public Integer getAge() {
//        return age;
//    }

//    @Override
//    public String toString() {
//        return String.format("%s %s %s %d", this.name, this.email, this.organization, this.age);
//    }
    @Override
    public String toString() {
        return String.format("%s %s %s", this.name, this.email, this.organization);
    }

}
