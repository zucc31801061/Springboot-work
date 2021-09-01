package cn.edu.zucc.controller;

import cn.edu.zucc.entity.Log;
import cn.edu.zucc.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LogController {

    @Autowired
    LogRepository logRepository;

    @GetMapping(value = "/log")
    public ArrayList<Log> findlog(@RequestParam("admin") String admin){
        ArrayList<Log> re= (ArrayList<Log>) logRepository.findAllByAdmin(admin);
        return re;
    }
}
