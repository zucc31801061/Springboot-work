package cn.edu.zucc.dao;

import cn.edu.zucc.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Long> {
    public Admin findByUsername(String username);
    Admin findById(long id);
}