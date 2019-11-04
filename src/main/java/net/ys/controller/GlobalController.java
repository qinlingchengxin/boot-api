package net.ys.controller;

import net.ys.constant.GenResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 处理全局请求
 */
@Controller
@RequestMapping(value = "global")
public class GlobalController {

    @ResponseBody
    @PostMapping("code/400")
    public Map<String, Object> http400() {
        return GenResult.PARAMS_ERROR.genResult();
    }

    @ResponseBody
    @PostMapping("code/405")
    public Map<String, Object> http405() {
        return GenResult.REQUEST_METHOD_ERROR.genResult();
    }

    @GetMapping("result/code")
    public String resultCode(Model model) {
        GenResult[] results = GenResult.values();
        model.addAttribute("results", results);
        return "result_code";
    }
}
