package com.lzw.hrmsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.dao.JobMapper;
import com.lzw.hrmsys.domain.Job;
import com.lzw.hrmsys.domain.JobExample;
import com.lzw.hrmsys.model.PageModel;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobMapper jobMapper;

	@Override
	public void add(Job obj) {
		jobMapper.insert(obj);
	}

	@Override
	public void delete(Integer id) {
		jobMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Job obj) {
		jobMapper.updateByPrimaryKey(obj);
	}

	@Override
	public Job getOne(Integer id) {
		return jobMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Job> getMore(Job obj) {
		return jobMapper.selectByExample(null);
	}

	@Override
	public List<Job> list() {
		return jobMapper.selectByExample(null);
	}

	@Override
	public PageInfo<Job> getModels(QueryModel<Job> queryModel) {
		PageModel<Job> deptPageModel = new PageModel<>();
		JobExample jobExample = new JobExample();
//        开始分页
		PageHelper.startPage(queryModel.getPageNum(),queryModel.getPageSize());
		Job job = queryModel.getObj();
		JobExample.Criteria criteria = jobExample.createCriteria();

//      判断是否有条件查询
		boolean flag = false;

		if(job.getName()!=null){
			criteria.andNameLike(job.getName());
			flag=true;
		}
		if(job.getRemark()!=null){
			criteria.andRemarkLike(job.getRemark());
			flag=true;
		}

		List<Job> list = null;
		if (flag){
			list = jobMapper.selectByExample(jobExample);
		}else {
			list = jobMapper.selectByExample(null);
		}
		PageInfo<Job> jobPageInfo = new PageInfo<>(list);
		return jobPageInfo;

	}
}
