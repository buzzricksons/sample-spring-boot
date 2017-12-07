package example.mybatis;

import example.mybatis.mapper.CrudExampleMapperJava;
import example.mybatis.mapper.data.City;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CrudExampleController {
    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/crud")
    @Transactional
    public String example() {
        CrudExampleMapperJava crudExampleMapperJava = sqlSession.getMapper(CrudExampleMapperJava.class);
        String code = UUID.randomUUID().toString();

        //Create
        crudExampleMapperJava.insert(City.builder().code(code).name("Tokyo").state("Minato-ku").country("Japan").build());
        System.out.println("CREATE: "+ crudExampleMapperJava.findByCode(code));

        //Read
        City city = crudExampleMapperJava.findByCode(code);
        System.out.println("READ: "+city.toString());

        //Update
        System.out.println("UPDATE Before: "+ crudExampleMapperJava.findByCode(code));
        crudExampleMapperJava.updateNameByCode(code, "Osaka");
        System.out.println("UPDATE After: "+ crudExampleMapperJava.findByCode(code));

        //Delete
//        System.out.println("DELETE: "+ crudExampleMapperJava.deleteByCode(code));

        return "CRUD success!";
    }
}