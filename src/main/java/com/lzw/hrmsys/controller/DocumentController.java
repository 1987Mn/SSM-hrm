package com.lzw.hrmsys.controller;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Document;
import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.DocumentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.github.pagehelper.util.StringUtil.isEmpty;

@Controller
public class DocumentController  {

    @Autowired
    DocumentService documentService;

    @RequestMapping("/documentlist")
    public ModelAndView documentlist(String title, String pageNum, String pageSize){
        QueryModel< Document> queryModel = new QueryModel<>();
        Document document = new  Document();

//        封装参数
        document.setTitle(title);
        queryModel.setObj(document);

        queryModel.setPageNum(isEmpty(pageNum)?1:Integer.valueOf(pageNum));
        queryModel.setPageSize(isEmpty(pageSize)?3:Integer.valueOf(pageSize));

//        查询数据库
        PageInfo pageInfo = documentService.getModels(queryModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("documentlist",pageInfo.getList());
        modelAndView.addObject("pageModel",pageInfo);
        modelAndView.addObject("queryDocument",document);
        modelAndView.setViewName("document/documentlist");

        return modelAndView;
    }

    @RequestMapping("/documentedit/{id}")
    public ModelAndView documentedit(@PathVariable(name = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Document one = documentService.getOne(id);
        modelAndView.addObject("document",one);
        modelAndView.setViewName("document/documentadd");
        return modelAndView;
    }

    @RequestMapping("/documentadd")
    public String documentadd(Document document){
        return "document/documentadd";
    }

    @RequestMapping("/documentsave")
    public String documentsave(String title,String remark,HttpServletRequest request){

        Document document = new Document();
        document.setRemark(remark);
        document.setTitle(title);

//        检查请求:是否为POST，编码enctype是否为multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart){
            request.setAttribute("message","文件上传失败！");
            return "document/documentadd";
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item:items) {
                if (item.isFormField()){
                    if("title".equals(item.getFieldName())){
                        document.setTitle(item.getString("utf-8"));
                    }
                    if("remark".equals(item.getFieldName())) {
                        document.setRemark(item.getString("utf-8"));
                    }
                    continue;
                }
                //文件名

                document.setFilename(FilenameUtils.getBaseName(item.getName()));
                document.setFiletype(FilenameUtils.getExtension(item.getName()));
                document.setFilebytes(item.get());
                upload.setSizeMax(1024*1024*2);
            }
            if (document.getId()==null){
                Subject subject = SecurityUtils.getSubject();
                User loginUser = (User)subject.getSession().getAttribute("loginUser");
                document.setUserId(loginUser.getId());
                document.setCreateDate(new Date());
                documentService.add(document);
            }else{
                documentService.update(document);
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/documentlist";
    }

    @RequestMapping("/documentdelete")
    public String documentdelete(String[] userIds){
        for (String id:userIds) {
            if(!isEmpty(id)){
                documentService.delete(Integer.valueOf(id));
            }
        }
        return "redirect:/documentlist";
    }

    @RequestMapping("/documentdownload")
    public String documentdownload(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        if(isEmpty(id)){
            Document one = documentService.getOne(Integer.valueOf(id));
            String fileName = one.getFilename()+"."+one.getFiletype();
            String mime = request.getServletContext().getMimeType(fileName);
            response.setHeader("Content-Type",mime);
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            String  data = one.getGetfilebytes();
            try {
                response.getOutputStream().write(data.getBytes("UTF-8"));
            } catch (IOException e) {
                request.setAttribute("mssage","下载失败");
            }
        }
        return "redirect:/documentlist";
    }

}