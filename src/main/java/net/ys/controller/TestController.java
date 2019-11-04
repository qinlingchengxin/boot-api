package net.ys.controller;

import io.swagger.annotations.Api;
import net.ys.bean.Person;
import net.ys.bean.User;
import net.ys.constant.CacheKey;
import net.ys.constant.GenResult;
import net.ys.service.PersonService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("api/test")
@Api(value = "test-api", description = "测试接口")
public class TestController {

    @Resource
    private PersonService personService;

    @Resource
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @GetMapping("test")
    public Object test() {
        Person person = new Person(1, "jack", 34, 0);
        redisCacheTemplate.opsForValue().set(CacheKey.KEY_PERSON + person.getId(), person);
        Serializable serializable = redisCacheTemplate.opsForValue().get(CacheKey.KEY_PERSON + person.getId());
        System.out.println(serializable);
        redisCacheTemplate.opsForValue().set(CacheKey.KEY_CODE, 123412);
        Serializable code = redisCacheTemplate.opsForValue().get(CacheKey.KEY_CODE);
        return code;
    }

    @GetMapping("user")
    public User user(String id, String username) {
        System.out.println(id);
        System.out.println(username);
        return new User(1, "jack", 34);
    }

    @GetMapping("persons")
    public List<Person> persons() {
        return personService.queryPersons(1, 15);
    }

    @GetMapping("header")
    public Object header(@RequestHeader(name = "X-Authorization-access-token", defaultValue = "") String accessToken) {
        if ("".equals(accessToken)) {
            return GenResult.REQUEST_INVALID.genResult();
        }
        return accessToken;
    }
}