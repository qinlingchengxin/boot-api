package net.ys.service;

import net.ys.bean.Admin;
import net.ys.dao.AdminDao;
import net.ys.util.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;

    public Admin queryAdmin(String username, String password) {
        String pass = Tools.genMD5(password);
        return adminDao.queryAdmin(username, pass);
    }
}
