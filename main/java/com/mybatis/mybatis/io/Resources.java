package com.mybatis.mybatis.io;

import java.io.InputStream;

/**
 * @author Carlos
 * @description 使用类加载器读取配置文件的类
 * @Date 2019/9/26
 */

public class Resources {
    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        //1.拿到当前类的字节码
        //2.获取字节码的类加载器
        //3.根据类加载器读取配置
        return  Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
