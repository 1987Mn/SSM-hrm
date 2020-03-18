package com.lzw.hrmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Dept;
import com.lzw.hrmsys.domain.DeptExample;
import com.lzw.hrmsys.model.QueryModel;

public interface DeptService {

	public void add(Dept ojb);

	public void delete(Integer id);

	public void update(Dept ojb);

	public Dept getOne(Integer id);

	public List<Dept> getMore(DeptExample obj);

	public List<Dept> list();


	public PageInfo<Dept> getModels(QueryModel<Dept> queryModel);
}
