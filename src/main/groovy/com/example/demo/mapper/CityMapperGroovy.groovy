package com.example.demo.mapper

import com.example.demo.City
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface CityMapperGroovy {
    @Select('''
            SELECT 
                id, name, state, country 
            FROM 
                city 
            WHERE 
                state = #{state}
    ''')
    City findByState(String state)

    @Select('''
            SELECT 
                id, name, state, country 
            FROM 
                city 
            WHERE 
                name = #{name}
    ''')
    City findByName(String name)

    @Select('''
            SELECT 
                id, name, state, country 
            FROM 
                city 
            WHERE 
                country = #{country}
    ''')
    City findByCountry(String country)
}