package com.easy.tool.utils.anno;

import com.easy.tool.anno.ToJsonIgnore;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author 高俊
 * @create 2021-09-2021/9/2-11:26
 * ToJsonIgnore注解解析
 */
public class ToJsonIgnoreUtils {

    private static Logger logger = Logger.getLogger(ToJsonIgnoreUtils.class);

    /**
     * 解析 ToJsonIgnore 注解
     * @param clazz  指定对象的class
     * @return
     */
    public static List<Object> getClassAnno(Class clazz){
        List<Object> list = new ArrayList<>();

        // require map
        HashMap<Object, Object> reqMap = new HashMap<>(30);
        // 分组group
        HashMap<Object, int[]> groupMap = new HashMap<>(30);
        try {
            // 获取所有属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 判断当前属性是否有注解
                boolean bool = field.isAnnotationPresent(ToJsonIgnore.class);
                if (bool){
                    String key = field.getName();
                    ToJsonIgnore toJsonIgnore = field.getAnnotation(ToJsonIgnore.class);
                    reqMap.put(field.getName(),toJsonIgnore.require());

                    groupMap.put(field.getName(),toJsonIgnore.group());

                }else {
                    // 没有注解的 require默认为false
                    reqMap.put(field.getName(),false);
                }
            }
        }catch (Exception e){
            logger.error("获取注解内容出错！！！",e);
        }
        list.add(reqMap);
        list.add(groupMap);
        return list;
    }

    /**
     * 过滤require为false的属性
     * @param map
     * @return 返回require为true的属性
     */
    public static HashMap<Object, Object> filters(Map<Object, Object> map){
        // 新建一个map
        HashMap<Object, Object> resultMap = new HashMap<>();

        Set<Object> keySet = map.keySet();
        for (Object key : keySet) {
            // 判断当前map的require是否为true
            if ((boolean) map.get(key)){
                resultMap.put(key,map.get(key));
            }
        }
        return resultMap;
    }


}
