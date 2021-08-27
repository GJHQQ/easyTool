package com.easy.tool.utils.other;

/**
 * @author 高俊
 * @create 2021-08-2021/8/27-9:58
 */
public class OtherUtils {
    /**
     * 判断奇偶
     * @param param
     * @return  1：奇数；2：偶数
     */
    public static int checkParity(int param){
        if (param%2 == 0){
            return 2;
        }
        return 1;
    }
}
