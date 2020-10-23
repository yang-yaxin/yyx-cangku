package com.jk.controller;

import com.jk.entity.Emp;
import com.jk.entity.EmpDept;
import com.jk.service.EmpService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmpController {
    @Resource
    private EmpService empService;

    @RequestMapping("empList")
    public List<Emp> empList(){
        return empService.empList();
    }
    @RequestMapping("saveEmp")
    public void saveEmp(@RequestBody Emp emp){
        empService.saveEmp(emp);
    }
    @RequestMapping("findEmpOne")
    public Emp findEmpOne(@RequestParam Integer empId){
        return empService.findEmpOne(empId);
    }
    @RequestMapping("deleteEmpByIds")
    public void deleteEmpByIds(@RequestParam String[] empIds){
        empService.deleteEmpByIds(empIds);

    }
    @RequestMapping("deptList")
    public List<EmpDept> deptList(){
        return empService.deptList();
    }

}
