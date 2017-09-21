package com.example.demo.controller;

import com.example.demo.City;
import com.example.demo.mapper.CrudExampleMapperGroovy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CrudExampleController {


    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/")
    public String index() {
        return "Application Works!";
    }

    @RequestMapping("/crud")
    public String example() {
        CrudExampleMapperGroovy crudExampleMapperGroovy = sqlSession.getMapper(CrudExampleMapperGroovy.class);
        String code = UUID.randomUUID().toString();

        //Create
        crudExampleMapperGroovy.insert(City.builder().code(code).name("Tokyo").state("Minato-ku").country("Japan").build());
        System.out.println("CREATE: "+ crudExampleMapperGroovy.findByCode(code));

        //Read
        City city = crudExampleMapperGroovy.findByCode(code);
        System.out.println("READ: "+city.toString());

        //Update
        System.out.println("UPDATE Before: "+ crudExampleMapperGroovy.findByCode(code));
        crudExampleMapperGroovy.updateNameByCode(code, "Osaka");
        System.out.println("UPDATE After: "+ crudExampleMapperGroovy.findByCode(code));

        //Delete
        System.out.println("DELETE: "+ crudExampleMapperGroovy.deleteByCode(code));

        return "crud success!";
    }
}