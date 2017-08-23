package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomRepository {
    @Select("SELECT * FROM customers ORDER BY id")
    public <E>List<E> findAll();
//    @Select("SELECT * FROM customers WHERE id = #{id}")
//    public Customer findOne(@Param("id") Integer id);
//    @Insert("INSERT INTO customers(first_name, last_name, address) VALUES(#{firstName}, #{lastName}, #{address})")
//    @SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = int.class)
//    public void insert(Customer customer);
//    @Update("UPDATE customers SET first_name = #{firstName}, last_name = #{lastName}, address = #{address} WHERE id = #{id}")
//    public void update(Customer customer);
//    @Delete("DELETE FROM customers WHERE id = #{id}")
//    public void delete(@Param("id") Integer id);
//    @Select("SELECT * FROM customers WHERE first_name LIKE '%' || #{firstName} || '%' ORDER BY id")
//    public List<Customer> findByFirstName(@Param("firstName") String firstName);
//    @Delete("DELETE FROM customers")
//    public void deleteAll();
}
