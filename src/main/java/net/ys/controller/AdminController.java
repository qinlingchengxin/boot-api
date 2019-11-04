package net.ys.controller;

import net.ys.bean.Admin;
import net.ys.constant.GenResult;
import net.ys.service.AdminService;
import net.ys.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "web/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping("login")
    public String doGet() {
        return "login";
    }

    @PostMapping("login")
    public String doPost(HttpSession session, String username, String password) {
        try {
            Admin admin = adminService.queryAdmin(username, password);
            if (admin != null) {
                session.setAttribute("admin", admin);
            }
        } catch (Exception e) {
            LogUtil.error(e);
        }
        return "redirect:main";
    }

    @GetMapping("main")
    public String main() {
        return "main";
    }

    @GetMapping("left")
    public String left() {
        return "left";
    }

    @GetMapping("top")
    public String top(Model model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String now = simpleDateFormat.format(new Date());
        model.addAttribute("now", now);
        return "top";
    }

    @GetMapping("footer")
    public String footer() {
        return "footer";
    }

    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    @ResponseBody
    @GetMapping("logout")
    public Map<String, Object> logout(HttpSession session) {
        session.removeAttribute("admin");
        return GenResult.SUCCESS.genResult();
    }
}
