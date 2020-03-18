package com.lzw.hrmsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.dao.UserMapper;
import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.domain.UserExample;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void add(User obj) {
		userMapper.insert(obj);
	}

	@Override
	public void delete(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(User obj) {
		userMapper.updateByPrimaryKey(obj);
	}

	@Override
	public User getOne(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getMore(UserExample obj) {

		UserExample userExample = new UserExample();

		UserExample.Criteria criteria = userExample.createCriteria();

		return userMapper.selectByExample(userExample);
	}

	@Override
	public List<User> list() {
		return userMapper.selectByExample(null);
	}


	@Override
	public User getOneByName(String name) {
		User user = userMapper.selectByName(name);
		return user ;
	}

	@Override
	public PageInfo getModels(QueryModel<User> queryModel) {
		UserExample userExample = new UserExample();
		PageHelper.startPage(queryModel.getPageNum(),queryModel.getPageSize());
		User user = queryModel.getObj();
		UserExample.Criteria criteria = userExample.createCriteria();

		boolean flag = false;

		if(user.getLoginname()!=null){
			criteria.andLoginnameLike(user.getLoginname());
			flag=true;
		}
		if(user.getUsername()!=null){
			criteria.andUsernameLike(user.getUsername());
			flag=true;
		}
		if(user.getStatus()!=null){
			criteria.andStatusEqualTo(user.getStatus());
			flag=true;
		}
		List<User> list = null;
		if (flag){
			list = userMapper.selectByExample(userExample);
		}else {
			list = userMapper.selectByExample(null);
		}

		PageInfo<User> userPageInfo = new PageInfo<>(list);
		return userPageInfo;

	}

}
