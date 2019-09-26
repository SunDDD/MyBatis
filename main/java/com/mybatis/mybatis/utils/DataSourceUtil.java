package com.mybatis.mybatis.utils;

import com.mybatis.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Carlos
 * @description 用于创建数据源的工具类
 * @Date 2019/9/26
 */

public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
