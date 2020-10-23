package com.jk.controller;

import com.jk.entity.Emp;
import com.jk.entity.EmpDept;
import com.jk.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EmpController {
    @Resource
    private EmpService empService;


    @RequestMapping("empList")
    public String empList(Model model){
        List<Emp> list=empService.empList();
        model.addAttribute("empList",list);
        return "index";
    }
    @RequestMapping("addEmp")
    public String addEmp(Model model){
        model.addAttribute("emp",new Emp());
        return "addEmp";
    }
    @RequestMapping("saveEmp")
    public String saveEmp( Emp emp){
        empService.saveEmp(emp);
        return "redirect:empList";
    }
    @RequestMapping("findEmpOne")
    public String findEmpOne(Integer empId,Model model){
        Emp emp= empService.findEmpOne(empId);
        model.addAttribute("emp",emp);
        return "addEmp";
    }
    @RequestMapping("deleteEmpByIds")
    public String deleteEmpByIds(String[] empId){
        empService.deleteEmpByIds(empId);
        return "redirect:empList";

    }
    @RequestMapping("deptList")
    public String deptList(Model model){
        List<EmpDept> list=empService.deptList();
        model.addAttribute("deptList",list);
        return "addEmp";
    }
}
