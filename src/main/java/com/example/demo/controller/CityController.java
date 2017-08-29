package com.example.demo.controller;

import com.example.demo.City;
import com.example.demo.mapper.CityMapperJava;
import com.example.demo.mapper.CityMapperGroovy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityMapperJava cityMapper;

    @Autowired
    private CityMapperGroovy cityMapperGroovy;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/")
    public String index() {
        City city1 = cityMapper.findByState("CA");
        System.out.println(city1.getCountry());


        City city2 = cityMapperGroovy.findByState("CA");
        System.out.println(city2.getCountry());

        return "Greetings from Spring Boot!";
    }
}