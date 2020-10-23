package com.jk.service;

import com.jk.entity.Emp;
import com.jk.entity.EmpDept;

import java.util.List;

public interface EmpService {
    List<Emp> empList();

    void saveEmp(Emp emp);

    Emp findEmpOne(Integer empId);

    void deleteEmpByIds(String[] empIds);

    List<EmpDept> deptList();
}
