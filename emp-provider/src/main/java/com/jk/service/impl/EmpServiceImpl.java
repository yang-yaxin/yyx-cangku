package com.jk.service.impl;

import com.jk.dao.EmpMapper;
import com.jk.entity.Emp;
import com.jk.entity.EmpDept;
import com.jk.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;
    @Override
    public List<Emp> empList() {
        return empMapper.empList();
    }

    @Override
    public void saveEmp(Emp emp) {
        if(emp.getEmpId()!=null){
            empMapper.updateByPrimaryKeySelective(emp);
        }else{
            empMapper.insertSelective(emp);
        }
    }

    @Override
    public Emp findEmpOne(Integer empId) {
        return empMapper.selectByPrimaryKey(empId);
    }

    @Override
    public void deleteEmpByIds(String[] empIds) {
        for (int i = 0; i < empIds.length; i++) {
            empMapper.deleteByPrimaryKey(Integer.parseInt(empIds[i]));
        }
    }

    @Override
    public List<EmpDept> deptList() {
        return empMapper.deptLsit();
    }
}
