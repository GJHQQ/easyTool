package com.easy.tool.utils.uuid;

import com.easy.tool.constant.DateConstant;
import com.easy.tool.utils.date.DateUtils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author 高俊
 * @create 2021-08-2021/8/27-9:58
 */
public class UUIDUtils {

    /**
     * 添获取自定义随机数id
     * @param digit 位数
     * @param bool  是否加上时间标识
     * @return
     */
    public static String getRandom(int digit,boolean bool){
        String id = "";
        // 如果传入为0 则默认为10位数
        if (digit == 0){
            digit = 10;
        }
        if (bool){
            id += DateUtils.dateFormat(new Date(), DateConstant.getStringShortTime);
        }
        Random random = new Random();
        for (int i=0;i<digit;i++){
            int a = random.nextInt(10);
            id += a;
        }
        return id;

    }

    /**
     * 随机UUID
     * @param digit uuid位数 0:不截取
     * @param bool  是否携带 “-” true：携带：false：不携带
     * @return  String类型UUID
     */
    public static String getUUIDString(int digit,boolean bool){
        String uuid = UUID.randomUUID().toString();
        if (digit > 0 && digit <= uuid.length()){
            uuid.substring(0,digit);
        }
        if (!bool){
            uuid.replaceAll("-", "");
        }
        return uuid;
    }
}
