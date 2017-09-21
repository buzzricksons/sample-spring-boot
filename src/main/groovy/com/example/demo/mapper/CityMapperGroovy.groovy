package com.example.demo.mapper

import com.example.demo.City
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.context.annotation.Bean


@Mapper
interface CityMapperGroovy {
    //CREATE
    @Insert('''
            INSERT INTO
                tcity (code, name, state, country)
                values (#{code}, #{name}, #{state}, #{country})
    ''')
    int insert(City city)


    //READ
    @Select('''
            SELECT 
                code, name, state, country 
            FROM 
                tcity
            WHERE 
                code = #{code}
    ''')
    City findByCode(@Param("code") String code)

    //UPDATE
    @Update('''
            UPDATE
                tcity
            SET
                name = #{name}
            WHERE
                code = #{code}
    ''')
    int updateNameByCode(@Param("code") String code, @Param("name") String name)


    //DELETE
    @Delete('''
            DELETE
            FROM
                tcity
            WHERE
                code = #{code}
    ''')
    int deleteByCode(@Param("code") String code)
}