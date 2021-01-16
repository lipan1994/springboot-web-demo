package com.demo.springboot.springbootwebdemo.controller;

import com.demo.springboot.springbootwebdemo.dao.DepartmentDao;
import com.demo.springboot.springbootwebdemo.dao.EmployeeDao;
import com.demo.springboot.springbootwebdemo.entities.Department;
import com.demo.springboot.springbootwebdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author: lipan
 * @date: 2021/1/16 10:45
 */
@Controller
public class EmployeeController {


    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    /**
     *   查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String emps(HttpSession session){
        Collection<Employee> all = employeeDao.getAll();
        session.setAttribute("epms",all);
        return "emp/list";
    }


    @GetMapping("/emp")
    public String toAdd(HttpSession session){
        //查询部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        session.setAttribute("depts",departments);
        return "emp/add";
    }


    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @PutMapping("/emp")
    public String edit(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model,HttpSession session){
        model.addAttribute("emp",employeeDao.get(id));
        session.setAttribute("depts",departmentDao.getDepartments());
        return "emp/add";
    }

    @DeleteMapping("/emp/{id}")
    public String del(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
