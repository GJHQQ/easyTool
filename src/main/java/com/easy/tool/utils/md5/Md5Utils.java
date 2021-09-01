package com.easy.tool.utils.md5;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

/**
 * @author 高俊
 * @create 2021-09-2021/9/1-15:00
 */
public class Md5Utils {
    /**
     * 简单加密
     * @param data 加密字符串
     * @return
     */
    public static String simpleMd5(String data){
        data = DigestUtils.md5Hex(data);
        return data;
    }
    /**
     * 带盐的简单加密
     * @param data 加密字符串
     * @param salte 盐值
     * @return
     */
    public static String simpleMd5(String data,String salte){
        data = DigestUtils.md5Hex(salte + data);
        return data;
    }
    /**
     * 带盐值集合的复杂加密
     * @param data 加密字符串
     * @param saltes 任意盐值集合
     * @return
     */
    public static String md5(String data, List<String> saltes){
        StringBuilder temp = new StringBuilder();
        for (String salte : saltes) {
            temp.append(DigestUtils.md5Hex(salte));
        }
        data = DigestUtils.md5Hex(data + temp);

        return data;
    }
    /**
     * 带盐的复杂加密
     * @param data 加密字符串
     * @param salte 盐值
     * @return
     */
    public static String md5(String data,String salte){
        salte = DigestUtils.md5Hex(salte);
        data = DigestUtils.md5Hex(data);

        String sat = data + salte;
        for (int i = 0; i < 10; i++) {
            data = DigestUtils.md5Hex(sat);
        }

        return data;
    }
}
