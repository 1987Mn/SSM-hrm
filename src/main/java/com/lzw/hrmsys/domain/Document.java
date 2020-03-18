package com.lzw.hrmsys.domain;

import java.util.Arrays;
import java.util.Date;

public class Document {
    private Integer id;

    private String title;

    private String filename;

    private String filetype;

    private String remark;

    private Date createDate;

    private Integer userId;

    private User user;

    private byte[] filebytes;

    private String getfilebytes;

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", filename='" + filename + '\'' +
                ", filetype='" + filetype + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate=" + createDate +
                ", userId=" + userId +
                ", user=" + user +
                ", filebytes=" + Arrays.toString(filebytes) +
                '}';
    }

    public Document() {
    }

    public Document(Integer id, String title, String filename, String filetype, String remark, Date createDate, Integer userId, User user, byte[] filebytes) {
        this.id = id;
        this.title = title;
        this.filename = filename;
        this.filetype = filetype;
        this.remark = remark;
        this.createDate = createDate;
        this.userId = userId;
        this.user = user;
        this.filebytes = filebytes;
    }

    public String getGetfilebytes() {
        return getfilebytes;
    }

    public void setGetfilebytes(String getfilebytes) {
        this.getfilebytes = getfilebytes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getFilebytes() {
        return filebytes;
    }

    public void setFilebytes(byte[] filebytes) {
        this.filebytes = filebytes;
    }
}