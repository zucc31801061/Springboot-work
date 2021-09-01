package cn.edu.zucc.dao;

import cn.edu.zucc.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleDao extends JpaRepository<SysRole,Long> {
public SysRole findByRole(String role);
        SysRole findById(long id);
}
