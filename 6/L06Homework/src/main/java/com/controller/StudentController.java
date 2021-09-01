package com.controller;

import com.dao.StudentDao;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping("")
    public ModelAndView studentlist(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                    @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Student> page = studentDao.findAll(pageable);
        ModelAndView mav = new ModelAndView("student/list");
        mav.addObject("page", page);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView getStudent(@PathVariable("id") Integer id) throws Exception {
        Student students = studentDao.findById(id);
        ModelAndView mav = new ModelAndView("student/show");
        mav.addObject("student", students);
        return mav;
    }

    @GetMapping("/add")
    public String addStudent() throws Exception{
        return "student/add";
    }

    @PostMapping("")
    public String saveStudent(Student model) throws Exception{
        studentDao.save(model);
        return "redirect:/student/";
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") long id) throws Exception{
        studentDao.deleteById(id);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable("id") long id) throws Exception {
        Student model = studentDao.findById(id);
        ModelAndView mav = new ModelAndView("student/edit");
        mav.addObject("student", model);
        return mav;
    }

    @PutMapping("/{id}")
    public String editStudentSave(Student model, long id) throws Exception{
        model.setId(id);
        studentDao.save(model);
        return "redirect:";
    }
}
