package cn.edu.zucc.sevice.impl;

import cn.edu.zucc.dao.SysRoleDao;
import cn.edu.zucc.entity.SysRole;
import cn.edu.zucc.sevice.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Override
    public SysRole findByRole(String role) {
        return sysRoleDao.findByRole(role);
    }
}
