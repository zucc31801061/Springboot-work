package com.controller;

import com.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    ArrayList<Student> stuList= new ArrayList<Student>();

    @RequestMapping(value = "/")
    public String index(){
        if(stuList.size()==0) {
            stuList.add(new Student("test", "31801061","女", "330682200010074426","31801061@Stu.zucc.edu.cn"));
            stuList.add(new Student("test", "31801061","女", "330682200010074426","31801061@Stu.zucc.edu.cn"));
        }
        return "index";
    }
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ModelAndView listData(int page){
        ModelAndView mav = new ModelAndView("show");

        int flag=0;
        List<Student> students;
        if(page * 3+3 < stuList.size()) {
            flag = 0;
            students = stuList.subList(page * 3, page * 3 + 3);
        }
        else {
            flag = 1;
            students =  stuList.subList(page * 3,stuList.size());
        }
        mav.addObject("flag",flag);
        mav.addObject("students",students);
        mav.addObject("sum",(stuList.size()-1)/3);
        mav.addObject("index",page);
        return mav;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Student student){
        return "add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addData(@Valid Student student, BindingResult bindingResult, RedirectAttributes attr){
        if(bindingResult.hasErrors()){
            return "add";
        }
        stuList.add(student);
        attr.addFlashAttribute("student",student);
        return "index";
    }
}
