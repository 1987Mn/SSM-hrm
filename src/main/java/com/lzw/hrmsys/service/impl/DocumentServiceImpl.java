package com.lzw.hrmsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.dao.DocumentMapper;
import com.lzw.hrmsys.domain.Document;
import com.lzw.hrmsys.domain.DocumentExample;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public void add(Document obj) {
        documentMapper.insert(obj);
    }

    @Override
    public void delete(Integer id) {
        documentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Document obj) {
        documentMapper.updateByPrimaryKey(obj);
    }

    @Override
    public Document getOne(Integer id) {
        return documentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Document> getMore(DocumentExample obj) {
        return documentMapper.selectByExample(null);
    }

    @Override
    public List<Document> list() {
        return documentMapper.selectByExample(null);
    }

    @Override
    public PageInfo getModels(QueryModel<Document> queryModel) {
        DocumentExample documentExample = new DocumentExample();
        PageHelper.startPage(queryModel.getPageNum(),queryModel.getPageSize());
        Document document = queryModel.getObj();
        DocumentExample.Criteria criteria = documentExample.createCriteria();

        boolean flag = false;

        if(document.getTitle()!=null){
            criteria.andTitleLike(document.getTitle());
            flag=true;
        }

        List<Document> list = null;
        if (flag){
            list = documentMapper.selectByExampleObj(documentExample);
        }else {
            list = documentMapper.selectByExampleObj(null);
        }
        PageInfo<Document> userPageInfo = new PageInfo<>(list);
        return userPageInfo;

    }
}
