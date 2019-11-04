package net.ys.controller;

import net.ys.bean.Person;
import net.ys.constant.GenResult;
import net.ys.service.PersonService;
import net.ys.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApiIgnore
@Controller
@RequestMapping(value = "web")
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping(value = "persons")
    public String list(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "1") int page, @RequestParam(value = "page_size", defaultValue = "10") int pageSize, Model model) {

        if (page < 1) {
            page = 1;
        }

        long count = personService.queryPersonCount(name);

        long t = count / pageSize;
        int k = count % pageSize == 0 ? 0 : 1;
        int totalPage = (int) (t + k);

        if (page > totalPage && count > 0) {
            page = totalPage;
        }

        List<Person> persons;
        if ((page - 1) * pageSize < count) {
            persons = personService.queryPersons(name, page, pageSize);
        } else {
            persons = new ArrayList<>();
        }

        model.addAttribute("count", count);
        model.addAttribute("curr_page", page);
        model.addAttribute("total_page", totalPage);
        model.addAttribute("persons", persons);
        model.addAttribute("name", name);
        return "person/list";
    }

    @GetMapping(value = "person/edit")
    public String edit(@RequestParam(defaultValue = "") String id, Model model) {
        Person person;
        if ("".equals(id)) {//新增
            person = new Person();
        } else {
            person = personService.queryPerson(id);
        }

        model.addAttribute("person", person);
        return "person/edit";
    }

    @RequestMapping(value = "person/save")
    @ResponseBody
    public Map<String, Object> save(Person person) {

        boolean flag = personService.savePerson(person);

        if (!flag) {
            return GenResult.FAILED.genResult();
        }
        return GenResult.SUCCESS.genResult();
    }

    @RequestMapping(value = "person/add")
    @ResponseBody
    public Map<String, Object> add(Person person) {
        try {
            person = personService.addPerson(person);
            if (person == null) {
                return GenResult.FAILED.genResult();
            }
            return GenResult.SUCCESS.genResult(person);
        } catch (Exception e) {
            LogUtil.error(e);
            return GenResult.UNKNOWN_ERROR.genResult();
        }
    }
}
