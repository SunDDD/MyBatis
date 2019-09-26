package com.mybatis.mybatis.sqlsession;

import com.mybatis.mybatis.cfg.Configuration;
import com.mybatis.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.mybatis.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author Carlos
 * @description 用于创建一个SqlSessionFactory对象
 * @Date 2019/9/26
 */

public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
