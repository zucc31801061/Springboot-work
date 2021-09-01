package cn.edu.zucc.sevice;

import cn.edu.zucc.entity.Admin;

public interface AdminService {
    public Admin findByUsername(String username);
}