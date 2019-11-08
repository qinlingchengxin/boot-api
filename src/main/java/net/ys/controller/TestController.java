package net.ys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping("cache")
    public Object cache() {
        Person person = new Person(1, "jack", 34, 0);
        redisCacheTemplate.opsForValue().set(CacheKey.KEY_PERSON + person.getId(), person);
        Serializable serializable = redisCacheTemplate.opsForValue().get(CacheKey.KEY_PERSON + person.getId());
        System.out.println(serializable);
        redisCacheTemplate.opsForValue().set(CacheKey.KEY_CODE, 123412);
        Serializable code = redisCacheTemplate.opsForValue().get(CacheKey.KEY_CODE);
        return code;
    }

    @GetMapping("user")
    @ApiOperation(value = "测试对象", notes = "此接口描述<br/>值得庆幸的是这儿支持html标签<hr/>", response = User.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "标识", dataType = "int", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", paramType = "query", defaultValue = "jack")})
    public User user(long id, String username) {
        return new User(id, username, 34);
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