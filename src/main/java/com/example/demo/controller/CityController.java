package com.example.demo.controller;

import com.example.demo.City;
import com.example.demo.mapper.CityMapperGroovy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CityController {

    @Autowired
    private CityMapperGroovy cityMapperGroovy;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/")
    public String index() {
        return "Application  Works!";
    }

    @RequestMapping("/test")
    public String test() {
        String code = UUID.randomUUID().toString();

        //Create
        cityMapperGroovy.insert(City.builder().code(code).name("Tokyo").state("Minato-ku").country("Japan").build());
        System.out.println("CREATE: "+cityMapperGroovy.findByCode(code));


        //Read
        City city = cityMapperGroovy.findByCode(code);
        System.out.println("READ: "+city.toString());


        //Update
        System.out.println("UPDATE Before: "+cityMapperGroovy.findByCode(code));
        cityMapperGroovy.updateNameByCode(code, "Osaka");
        System.out.println("UPDATE After: "+cityMapperGroovy.findByCode(code));


        //Delete
//        cityMapperGroovy.deleteByCode(code);
        System.out.println("DELETE: "+cityMapperGroovy.deleteByCode(code));



        return "Greetings from Spring Boot!555arrr144111";
    }
}