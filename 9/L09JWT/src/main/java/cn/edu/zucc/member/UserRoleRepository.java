package cn.edu.zucc.member;

import cn.edu.zucc.entity.member.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
	UserRole findByRolename(String name);
}
