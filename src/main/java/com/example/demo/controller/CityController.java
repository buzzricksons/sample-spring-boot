package com.example.demo.controller;

import com.example.demo.City;
import com.example.demo.mapper.CityMapperGroovy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@RestController
public class CityController {

    @Autowired
    private CityMapperGroovy cityMapperGroovy;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/test")
    public String index() {
        String id = UUID.randomUUID().toString();

        //Create
        cityMapperGroovy.insert(City.builder().id(id).name("Tokyo").state("Minato-ku").country("Japan").build());
//        System.out.println("CREATE: "+cityMapperGroovy.findByCode(id));
//
//
//        //Read
//        City city = cityMapperGroovy.findByCode(id);
//        System.out.println("READ: "+city.toString());
//
//
//        //Update
//        System.out.println("UPDATE: "+cityMapperGroovy.findByCode(id));
//        cityMapperGroovy.updateNamebyCode(id, "luke");
//        System.out.println("UPDATE: "+cityMapperGroovy.findByCode(id));
//
//
//        //Delete
//        cityMapperGroovy.deleteByCode(id);
//        System.out.println("DELETE: "+cityMapperGroovy.findByCode(id));



        return "Greetings from Spring Boot!";
    }
}