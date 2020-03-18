package com.lzw.hrmsys.service;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Document;
import com.lzw.hrmsys.domain.DocumentExample;
import com.lzw.hrmsys.model.QueryModel;

import java.util.List;

public interface DocumentService {

	public void add(Document ojb);

	public void delete(Integer id);

	public void update(Document ojb);

	public Document getOne(Integer id);

	public List<Document> getMore(DocumentExample obj);

	public List<Document> list();

    PageInfo getModels(QueryModel<Document> queryModel);
}
