package com.lzw.hrmsys.service;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.domain.UserExample;
import com.lzw.hrmsys.model.QueryModel;

import java.util.List;

public interface UserService {

	public void add(User ojb);
	
	public void delete(Integer id);
	
	public void update(User ojb);
	
	public User getOne(Integer id);

	public List<User> getMore(UserExample obj);

	public List<User> list();

	public User getOneByName(String name);

	public PageInfo getModels(QueryModel<User> queryModel);

}
