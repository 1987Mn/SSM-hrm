package com.lzw.hrmsys.service;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Job;
import com.lzw.hrmsys.model.QueryModel;

import java.util.List;

public interface JobService {

	public void add(Job ojb);

	public void delete(Integer id);

	public void update(Job ojb);

	public Job getOne(Integer id);

	public List<Job> getMore(Job obj);

	public List<Job> list();


    PageInfo<Job> getModels(QueryModel<Job> queryModel);
}
