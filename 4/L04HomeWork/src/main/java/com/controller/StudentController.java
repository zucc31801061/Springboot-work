package com.controller;

import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/show")
    public ModelAndView listData(int page){
        ModelAndView mav = new ModelAndView("show");

        ArrayList<Student> list = studentService.findAll();

        int flag=0;
        List<Student> students;
        if(page * 3+3 < list.size()) {
            flag = 0;
            students = list.subList(page * 3, page * 3 + 3);
        }
        else {
            flag = 1;
            students =  list.subList(page * 3,list.size());
        }
        mav.addObject("flag",flag);
        mav.addObject("students",students);
        mav.addObject("sum",(list.size()-1)/3);
        mav.addObject("index",page);
        return mav;
    }

    @GetMapping(value = "/add")
    public String add(Student student){
        return "add";
    }

    @PostMapping(value = "/add")
    public String addData(@Valid Student student, BindingResult bindingResult, RedirectAttributes attr){
        if(bindingResult.hasErrors()){
            return "add";
        }
        studentService.addData(student);
        attr.addFlashAttribute("student",student);
        return "index";
    }

    @GetMapping(value = "/delete")
    String deleteData(String id){
        studentService.removeData(id);
        return "index";
    }

    @GetMapping(value = "/modify")
    ModelAndView change(String id){
        ModelAndView mav = new ModelAndView("modify");
        Student student = studentService.findById(id);
        mav.addObject("student",student);
        return mav;
    }

    @PostMapping(value = "/modify")
    String modifyData(@Valid Student student, BindingResult bindingResult, RedirectAttributes attr){

        if(bindingResult.hasErrors()){
            return "modify";
        }

        studentService.updateData(student);
        attr.addFlashAttribute("student",student);
        return "index";
    }
}
