package com.example.demo.mapper

import com.example.demo.City
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
public interface CityMapperGroovy {
    @Select('''
            SELECT 
                id, name, state, country 
            FROM 
                city 
            WHERE 
                state = #{state}
            ''')
    City findByState(String state);
}