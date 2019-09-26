package com.mybatis.mybatis.sqlsession.defaults;

import com.mybatis.mybatis.cfg.Configuration;
import com.mybatis.mybatis.sqlsession.SqlSession;
import com.mybatis.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author Carlos
 * @description SqlSessionFactory接口的实现类
 * @Date 2019/9/26
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
