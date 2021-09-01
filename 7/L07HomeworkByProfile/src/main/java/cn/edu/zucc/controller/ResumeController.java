package cn.edu.zucc.controller;

import cn.edu.zucc.entity.Resume;
import cn.edu.zucc.mapper.ResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    ResumeMapper resumeMapper;

    @RequestMapping("/add")
    public String add(Resume resume){
        return resumeMapper.addResume(resume) == 1 ? "success" : "failed";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        return resumeMapper.deleteResume(id) == 1 ? "success" : "failed";
    }

    @RequestMapping("/find")
    public Resume find(Integer id){
        return resumeMapper.findResume(id);
    }

    @RequestMapping("/update")
    public String update(Resume resume){
        return resumeMapper.updateResume(resume) == 1 ? "success" : "failed";
    }
}
