package example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CrudExampleController {
    @Autowired
    private CrudExampleDao crudExampleDao;

    @RequestMapping("/crud")
    public String example() {
        String code = UUID.randomUUID().toString();

        //Create
        System.out.println("CREATE: "+ crudExampleDao.create(code));

        //Read
        System.out.println("READ: "+crudExampleDao.read(code));

        //Update
        System.out.println("UPDATE Before: "+ crudExampleDao.read(code));
        crudExampleDao.update(code);
        System.out.println("UPDATE After: "+ crudExampleDao.read(code));

        //Delete
//        System.out.println("DELETE: "+ crudExampleDao.delete(code));

        return "CRUD success!";
    }
}