package com.mybatis.mybatis.sqlsession.defaults;

import com.mybatis.mybatis.cfg.Configuration;
import com.mybatis.mybatis.sqlsession.SqlSession;
import com.mybatis.mybatis.sqlsession.proxy.MapperProxy;
import com.mybatis.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author Carlos
 * @description SqlSession接口的实现类
 * @Date 2019/9/26
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 创建代理对象
     * @param daoInterfaceClass  dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
    }

    /**
     * 用于释放资源
     */
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
