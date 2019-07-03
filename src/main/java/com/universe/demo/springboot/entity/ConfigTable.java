package com.universe.demo.springboot.entity;

import java.util.Date;

/**
 * Created by jsliu on 2019/1/13.
 */
public class ConfigTable {
    private Integer id;
    private String tableName;
    private String columnCode;
    private String columnName;
    private Integer descNo;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getDescNo() {
        return descNo;
    }

    public void setDescNo(Integer descNo) {
        this.descNo = descNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
