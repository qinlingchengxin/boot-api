package net.ys.service;

import net.ys.bean.Person;
import net.ys.dao.PersonDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {

    @Resource
    private PersonDao personDao;

    public List<Person> queryPersons(int page, int pageSize) {
        return personDao.queryPersons(page, pageSize);
    }

    public List<Person> queryPersons(String name, int page, int pageSize) {
        return personDao.queryPersons(name, page, pageSize);
    }

    public long queryPersonCount(String name) {
        return personDao.queryPersonCount(name);
    }

    public Person queryPerson(String id) {
        return personDao.queryPerson(id);
    }

    public boolean savePerson(Person person) {
        return personDao.savePerson(person);
    }

    public Person addPerson(Person person) {
        return personDao.addPerson(person);
    }
}
