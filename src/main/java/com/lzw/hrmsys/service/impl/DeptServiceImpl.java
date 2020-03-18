package com.lzw.hrmsys.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.dao.DeptMapper;
import com.lzw.hrmsys.domain.Dept;
import com.lzw.hrmsys.domain.DeptExample;
import com.lzw.hrmsys.model.PageModel;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void add(Dept obj) {
        deptMapper.insert(obj);
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Dept obj) {
        deptMapper.updateByPrimaryKey(obj);
    }

    @Override
    public Dept getOne(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> getMore(DeptExample obj) {

        return deptMapper.selectByExample(null);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.selectByExample(null);
    }

    @Override
    public PageInfo<Dept> getModels(QueryModel<Dept> queryModel) {
        PageModel<Dept> deptPageModel = new PageModel<>();
        DeptExample deptExample = new DeptExample();
//        开始分页
        PageHelper.startPage(queryModel.getPageNum(),queryModel.getPageSize());
        Dept dept = queryModel.getObj();
        DeptExample.Criteria criteria = deptExample.createCriteria();
//      判断是否有条件查询
        boolean flag = false;
        if(dept.getName()!=null){
            criteria.andNameLike(dept.getName());
            flag=true;
        }
        if(dept.getRemark()!=null){
            criteria.andRemarkLike(dept.getRemark());
            flag=true;
        }
        List<Dept> list = null;
        if (flag){
            list = deptMapper.selectByExample(deptExample);
        }else {
            list = deptMapper.selectByExample(null);
        }
        PageInfo<Dept> deptPageInfo = new PageInfo<>(list);
        return deptPageInfo;
    }
}
