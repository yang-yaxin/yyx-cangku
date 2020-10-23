package com.jk.service.hystrix;

import com.jk.entity.Emp;
import com.jk.entity.EmpDept;
import com.jk.service.EmpService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpServiceHystrix implements EmpService {


    @Override
    public List<Emp> empList() {
        return null;
    }

    @Override
    public void saveEmp(Emp emp) {

    }

    @Override
    public Emp findEmpOne(Integer empId) {
        return null;
    }

    @Override
    public void deleteEmpByIds(String[] empIds) {

    }

    @Override
    public List<EmpDept> deptList() {
        return null;
    }
}
