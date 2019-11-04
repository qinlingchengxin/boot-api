package net.ys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("swagger")
@Api(value = "swagger", description = "车辆模块接口详情")
public class SwaggerController {

    @GetMapping
    @ApiOperation(value = "查询车辆接口", notes = "此接口描述<br/>值得庆幸的是这儿支持html标签<hr/>", response = ModelMap.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "vno", value = "车牌", dataType = "string", paramType = "query", defaultValue = "辽A12345"),
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "user_name", value = "用户名", dataType = "string", paramType = "query", defaultValue = "jack"),
            @ApiImplicitParam(name = "count", value = "数量", dataType = "int", paramType = "query", defaultValue = "10")})
    public ModelMap findVehicles(@RequestParam(value = "vno", required = false) String vno,
                                 @RequestParam(value = "user_name", required = false) String userName,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "count", required = false) Integer count) {

        log.info("http://localhost:8501/api/v1/vehicles");
        log.info("## {},{},{}", vno, page, count);
        log.info("## 请求时间：{}", new Date());
        ModelMap map = new ModelMap();
        map.addAttribute("vno", vno);
        map.addAttribute("user_name", userName);
        map.addAttribute("page", page);
        return map;
    }

    @GetMapping("vno={vno}")
    @ApiOperation(value = "根据车牌查询车辆", notes = "这种类型的查询是精确查询,其结果只有一条数据", response = ModelMap.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "vno", value = "车牌", dataType = "string", paramType = "path", defaultValue = "辽A12345")})
    public ModelMap getVno(@PathVariable(value = "vno") String vno) {

        log.info("http://localhost:8501/api/v1/vehicles/vno={}", vno);
        log.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("vno", vno);
        return map;
    }

    @GetMapping("vno={vno}/location")
    @ApiOperation(value = "车辆位置查询接口", notes = "根据车牌查询车辆位置信息", response = ModelMap.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "vno", value = "车牌", dataType = "string", paramType = "path", defaultValue = "辽A12345")})
    public ModelMap getLocation(@PathVariable(value = "vno") String vno) {
        log.info("getLocation");
        log.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("vno", vno);
        return map;
    }

    @GetMapping(value = "{id}")
    @ApiOperation(value = "根据车辆id查询", notes = "精确查询,最常规的方式,支持POST和GET方式", response = ModelMap.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "id", dataType = "string", paramType = "path", defaultValue = "12344444")})
    public ModelMap getById(@PathVariable(value = "id") String id) {
        log.info("http://localhost:8501/api/v1/vehicles/{}", id);
        log.info("## 请求时间：{}", new Date());
        ModelMap map = new ModelMap();
        map.addAttribute("{RequestMethod.GET,RequestMethod.POST}", id);
        return map;
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据车辆id查询", notes = "精确查询,最常规的方式,支持POST和GET方式", response = ModelMap.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "id", dataType = "string", paramType = "path", defaultValue = "12344444")})
    public ModelMap delById(@PathVariable(value = "id") String id) {

        log.info("http://localhost:8501/api/v1/vehicles/{}", id);
        log.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("RequestMethod.DELETE", id);
        return map;
    }

    /*@PutMapping(value = "change_rental_shop")
    @ApiOperation(value = "网点挂靠", notes = "嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻", response = PersonDto.class)
    public Person changeRentalShop(@RequestBody Person person) {
        log.info("http://localhost:8501/api/v1/vehicles/change_rentalshop | {}", person);
        log.info("## 请求时间：{}", new Date());
        return person;
    }*/
}