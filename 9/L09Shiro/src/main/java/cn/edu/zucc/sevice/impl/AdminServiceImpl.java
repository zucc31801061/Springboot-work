package cn.edu.zucc.sevice.impl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.Admin;
import cn.edu.zucc.sevice.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    //@Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入，而@Resource默认按 byName自动注入
	@Resource
    private AdminDao adminDao;

    @Override
    public Admin findByUsername(String username) {
               return adminDao.findByUsername(username);
    }
}