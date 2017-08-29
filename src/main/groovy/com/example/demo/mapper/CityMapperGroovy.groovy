package com.example.demo.mapper

import com.example.demo.City
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface CityMapperGroovy {
    @Select('''
            SELECT 
                id, name, state, country 
            FROM 
                tcity 
            WHERE 
                state = #{state}
    ''')
    City findByState(String state)

    @Select('''
            SELECT 
                id, name, state, country 
            FROM 
                tcity 
            WHERE 
                name = #{name}
    ''')
    City findByName(String name)

    @Select('''
            SELECT 
                id, name, state, country 
            FROM 
                tcity 
            WHERE 
                country = #{country}
    ''')
    City findByCountry(String country)

    @Insert('''
            INSERT INTO
                tcity (name, state, country)
                values (#{name}, #{state}, #{country})
    ''')
    int insert(City city)
}