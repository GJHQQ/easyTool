package com.easy.tool.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easy.tool.utils.anno.ToJsonIgnoreUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 高俊
 * @create 2021-09-2021/9/2-11:43
 */
public class JsonUtils {

    private static Logger logger = Logger.getLogger(JsonUtils.class);


    /**
     * java对象转json对象，可以根据ToJsonIgnore注解进行自定义的规则进行转换
     * @param object
     * @param groupId
     * @return
     */
    public static JSON customToJson(Object object,int groupId){
        return toJson(object,groupId);
    }

    /**
     * java对象转json对象，可以根据ToJsonIgnore注解进行自定义的规则进行转换
     * @param object
     * @return
     */
    public static JSON customToJson(Object object){
        return toJson(object,0);
    }

    private static JSON toJson(Object object,int groupId){
        Class clazz = object.getClass();
        // 获取clazz中加了注解的属性
        List<Object> list = ToJsonIgnoreUtils.getClassAnno(clazz);
        Map<Object,Object> reqMap = (Map<Object, Object>) list.get(0);
        HashMap<Object, int[]> groupMap = (HashMap<Object, int[]>) list.get(1);

        // 过滤掉require为false的属性
        HashMap<Object, Object> resultMap = ToJsonIgnoreUtils.filters(reqMap);


        // 新建json对象
        JSONObject json = new JSONObject();
        Set<Object> resultKeySet = resultMap.keySet();
        for (Object key : resultKeySet) {
            try {

                // 循环注解的require ，判断是否有自定的groupId
                int[] group = groupMap.get(key);
                if (group != null && group.length > 0){
                    for (int i : group) {
                        if (i == groupId){
                            // 获取指定属性
                            Field field = clazz.getDeclaredField(key.toString());
                            field.setAccessible(true);
                            // 获取改属性的值
                            Object val = field.get(object);
                            // 插入json对象
                            json.put(key.toString(),val);
                            // 只会有一个，有相等的就跳出循环
                            break;
                        }
                    }
                }

            }catch (Exception e){
                logger.error("找不到" + key + "属性");
            }
        }
        return json;
    }

}
