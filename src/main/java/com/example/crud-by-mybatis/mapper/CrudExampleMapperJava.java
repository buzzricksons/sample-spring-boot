package com.example.demo.mapper;

import com.example.demo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CrudExampleMapperJava {
    @Select("" +
            "SELECT" +
            " id, name, state, country " +
            "FROM " +
            "tcity " +
            "WHERE " +
            "state = #{state}" +
            "")
    City findByState(String state);
}






