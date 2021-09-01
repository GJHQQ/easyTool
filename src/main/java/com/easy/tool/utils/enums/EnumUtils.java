package com.easy.tool.utils.enums;

import com.easy.tool.enums.CommonEnum;
import org.apache.log4j.Logger;

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

    private static Logger log = Logger.getLogger(EnumUtils.class);

    /**
     * 获取指定枚举类型的所有键值
     * @param clazz
     * @return
     */
    public static Map<Object, Object> getAllEnum(Class clazz) {
        Map<Object, Object> enumMap = getEnumMap(clazz);
        return enumMap;
    }


    /**
     * 获取指定code的codeName
     * @param clazz
     * @param code
     * @return
     */
    public static Object getCodeNameByCode(Class clazz, Object code){
        Map<Object, Object> enumMap = getEnumMap(clazz);
        Object codeName = enumMap.get(code);
        return codeName;
    }

    /**
     * 将枚举类型转化为Map<Object,Object>类型
     * @param clazz
     * @return
     */
    private static Map<Object,Object> getEnumMap(Class clazz){
        // 获取枚举构造方法
        Object[] enumConstants = clazz.getEnumConstants();
        if (enumConstants.length > 0) {
            Map<Object, Object> map = new HashMap<>();
            Method getCode = null;
            Method getCodeName = null;
            try {
                // 获取getCode
                getCode = clazz.getMethod("getCode");
            } catch (Exception e) {
                log.error("getCode方法未找到");
            }
            try {
                // 获取getCodeName
                getCodeName = clazz.getMethod("getCodeName");
            } catch (Exception e) {
                log.error("getCodeName方法未找到");
            }

            // 循环所有对象
            for (Object constant : enumConstants) {
                try {
                    // 拿到当前对象的code和codeName
                    map.put(getCode.invoke(constant), getCodeName.invoke(constant));
                } catch (Exception e) {
                    log.error("方法执行异常");
                }
            }
            return map;
        }
        return null;
    }



}
