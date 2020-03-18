package com.lzw.hrmsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.dao.EmployeeMapper;
import com.lzw.hrmsys.domain.Employee;
import com.lzw.hrmsys.domain.EmployeeExample;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void add(Employee obj) {
        employeeMapper.insert(obj);
    }

    @Override
    public void delete(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Employee obj) {
        employeeMapper.updateByPrimaryKey(obj);
    }

    @Override
    public Employee getOne(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Employee getOneByObj(Integer id) {
        return employeeMapper.selectByObj(id==null?1:id);
    }

    @Override
    public List<Employee> getMore(Employee obj) {

        return employeeMapper.selectByExample(null);
    }


    @Override
    public List<Employee> list() {
        return employeeMapper.selectByExample(null);
    }

    @Override
    public PageInfo<Employee> getModels(QueryModel queryModel) {
        EmployeeExample employeeExample = new EmployeeExample();
        PageHelper.startPage(queryModel.getPageNum(),queryModel.getPageSize());
        Employee employee = (Employee) queryModel.getObj();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();

        boolean flag = false;

        if(employee.getDeptId()!=null){
            criteria.andDeptIdEqualTo(employee.getDeptId());
            flag=true;
        }
        if(employee.getJobId()!=null){
            criteria.andJobIdEqualTo(employee.getJobId());
            flag=true;
        }
        if(employee.getCardId()!=null){
            criteria.andCardIdLike(employee.getCardId());
            flag=true;
        }
//        if(employee.getName()!=null){
//            criteria.andNameLike(employee.getName());
//            flag=true;
//        }
        if(employee.getPhone()!=null){
            criteria.andPhoneLike(employee.getPhone());
            flag=true;
        }
        if(employee.getSex()!=null){
            criteria.andSexEqualTo(employee.getSex());
            flag=true;
        }

        List<Employee> list = null;
        if (flag){
            list = employeeMapper.selectByExample(employeeExample);
        }else {
            list = employeeMapper.selectByExample(null);
        }
        System.out.println(flag);

        PageInfo<Employee> employeePageInfo = new PageInfo<>(list);
        return employeePageInfo;

    }
}
