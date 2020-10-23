package com.jk.service;

import com.jk.entity.Emp;
import com.jk.entity.EmpDept;
import com.jk.service.hystrix.EmpServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="emp-provider",fallback = EmpServiceHystrix.class)
public interface EmpService {
    @RequestMapping("empList")
    public List<Emp> empList();

    @RequestMapping("saveEmp")
    public void saveEmp(@RequestBody Emp emp);

    @RequestMapping("findEmpOne")
    public Emp findEmpOne(@RequestParam Integer empId);

    @RequestMapping("deleteEmpByIds")
    public void deleteEmpByIds(@RequestParam String[] empIds);
    @RequestMapping("deptList")
    public List<EmpDept> deptList();
}
