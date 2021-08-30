package com.easy.tool.utils.enums;

import com.easy.tool.enums.CommonEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 高俊
 * @create 2021-08-2021/8/30-21:40
 */
public class EnumUtils {

    /**
     * 获取指定枚举类型的所有键值
     * @param clazz
     * @return
     */
    public static Map<Object, Object> getAllEnum(Class clazz){
        try {
            // 获取枚举构造方法
            Object[] enumConstants = clazz.getEnumConstants();
            if (enumConstants.length > 0){
                Map<Object, Object> map = new HashMap<>();
                // 获取getCode
                Method getCode = clazz.getMethod("getCode");
                // 获取getCodeName
                Method getCodeName = clazz.getMethod("getCodeName");
                // 循环所有对象
                for (Object constant : enumConstants) {
                    // 拿到当前对象的code和codeName
                    map.put(getCode.invoke(constant),getCodeName.invoke(constant));
                }
                return map;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
