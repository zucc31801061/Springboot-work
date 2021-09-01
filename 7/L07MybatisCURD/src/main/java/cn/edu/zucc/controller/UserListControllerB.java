package cn.edu.zucc.controller;

import cn.edu.zucc.entity.User;
import cn.edu.zucc.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserListControllerB {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/listallB")
    public Page<User> getUserList(@RequestParam(value="pageNum",defaultValue="0")int pageNum,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User>  userList= userMapper.getUserList();
        return userList;
    }
}
