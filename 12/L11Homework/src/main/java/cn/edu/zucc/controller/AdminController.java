package cn.edu.zucc.controller;

import cn.edu.zucc.entity.AdminEntity;
import cn.edu.zucc.jwt.JwtUtil;
import cn.edu.zucc.mapper.AdminMapper;
import cn.edu.zucc.result.ExceptionMsg;
import cn.edu.zucc.result.Response;
import cn.edu.zucc.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @PostMapping("/enter")
    public ResponseData Stulist(@RequestBody AdminEntity admin ) {
        if(adminMapper.queryByUser(admin.getUser()) == null)
            return new ResponseData(new Response("405","账号不存在"),null);
        else if( !adminMapper.queryByUser(admin.getUser()).getPass().equals(admin.getPass()))
            return new ResponseData(new Response("405","密码错误"),null);
        else {
            String token = null;
            try {
                token = JwtUtil.createToken(adminMapper.queryByUser(admin.getUser()).getRole(),
                        adminMapper.queryByUser(admin.getUser()).getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseData(ExceptionMsg.SUCCESS,token);
        }
    }
}
