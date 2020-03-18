package com.lzw.hrmsys.service;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Employee;
import com.lzw.hrmsys.model.QueryModel;


import java.util.List;

public interface EmployeeService {


	public void add(Employee ojb);

	public void delete(Integer id);

	public void update(Employee ojb);

	public Employee getOne(Integer id);

	public Employee getOneByObj(Integer id);

	public List<Employee> getMore(Employee obj);

	public List<Employee> list();

	public PageInfo<Employee> getModels(QueryModel queryModel) ;


	
}
