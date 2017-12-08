package example.mybatis;

import example.mybatis.mapper.CrudExampleMapperJava;
import example.mybatis.mapper.data.City;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CrudExampleDao {
    @Autowired
    private SqlSession sqlSession;

    private final CrudExampleMapperJava crudExampleMapperJava = sqlSession.getMapper(CrudExampleMapperJava.class);

    @Transactional
    public String create(String code) {
        int row = crudExampleMapperJava.insert(City.builder().code(code).name("Tokyo").state("Minato-ku").country("Japan").build());
        return Integer.toString(row);
    }

    public String read(String code) {
        City city = crudExampleMapperJava.findByCode(code);
        return city.toString();
    }

    @Transactional
    public String update(String code) {
        crudExampleMapperJava.updateNameByCode(code, "Osaka");
        City city = crudExampleMapperJava.findByCode(code);
        return city.toString();
    }

    @Transactional
    public String delete(String code) {
        System.out.println("DELETE: "+ crudExampleMapperJava.deleteByCode(code));
        return String.format("code %s is deleted.",code);
    }
}
