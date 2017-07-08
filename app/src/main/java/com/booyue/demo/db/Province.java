package com.booyue.demo.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 15272 on 2017/7/8.
 *
 * 省份 对应建立建立数据库中省份表
 *
 * litepal在gradle引入
 *
 * 创建实体类并继承datasupport
 *
 * 创建assets目录，建立litepal.xml文件
 *
 * 配置application
 */
public class Province extends DataSupport{

    private int id;//每一个实体类对应的字段
    private String provinceName;//记录省的名字
    private int proviceCode;//记录省的代号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProviceCode() {
        return proviceCode;
    }

    public void setProviceCode(int proviceCode) {
        this.proviceCode = proviceCode;
    }
}
