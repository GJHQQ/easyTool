package com.easy.tool.utils.sort;

import com.easy.tool.utils.other.OtherUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 高俊 on 2021/8/8.
 * @version 1.0
 */

public class SortUtils {


    private static Map<String, Object> map = new HashMap<>();


    /**
     * 排序算法，正对于数组进行排序
     * @param array
     * @type ASC:升序；DESC：降序；
     * @return  返回一个排好序的数组
     */
    public static int[] sortList(int[] array,String type){
        // 定义检查记录
        int checkRecord = 0;
        int length = array.length;

        // 校验数组
        int param = OtherUtils.checkParity(array.length);

        for (int a = 0;a>= 0;a++){
            // 定义检查码
            int checkCode = 0;
            int index = 0;

            Map<String, Object> map = checkArray(a, index, length, array, param);
            index = (int)map.get("index");
            length = (int)map.get("length");


            Map<String, Object> sc = sortCode(array, type, index, length, checkCode);
            checkRecord = (Integer)sc.get("checkCode");
            array = (int[])sc.get("array");


            // 判断是否存在交换值的情况。检查码>0检查记录+1
            if (checkCode > 0){
                checkRecord = 0;
            }else {
                checkRecord += 1;
            }
            // 当检查记码为2的时候，排序完成，跳出循环
            if (checkRecord == 2){
                break;
            }
        }
        return array;
    }

    /**
     * 执行排序代码
     * @param array
     * @param type
     * @param index
     * @param length
     * @param checkCode
     * @return
     */
    public static Map<String, Object> sortCode(int[] array, String type, int index, int length, int checkCode){
        if ("ASC".equals(type)){
            for (int i = index; i < length; i+=2) {
                // 如果存在交换值的情况就给checkCount+1

                if (array[i] > array[i+1]){
                    array[i] = array[i]^array[i+1];
                    array[i+1] =  array[i]^array[i+1];
                    array[i] =  array[i]^array[i+1];
                    checkCode += 1;
                }
            }
        }else if ("DESC".equals(type)){
            for (int i = index; i < length; i+=2) {
                // 如果存在交换值的情况就给checkCount+1

                if (array[i] < array[i+1]){
                    array[i] = array[i]^array[i+1];
                    array[i+1] =  array[i]^array[i+1];
                    array[i] =  array[i]^array[i+1];
                    checkCode += 1;
                }
            }
        }
        map.put("checkCode",checkCode);
        map.put("array",array);
        return map;
    }

    /**
     * 校验数组长度
     * @param a 最外层循环数
     * @param index 循环初始值
     * @param length 数组长度
     * @param array 数组
     * @param param 数组长度的奇偶情况 1：奇数;2：偶数；
     * @return
     */
    public static Map<String,Object> checkArray(int a, int index, int length, int[] array,int param){
        if (a%2 == 0){
            if (param == 1){
                index = 0;
                length = length -1;
            }else if (param == 2){
                index = 0;
                length = array.length;
            }
        }else {
            if (param == 1){
                index = 1;
                length = array.length;
            }else if (param == 2){

                index = 1;
                length = length -1;
            }
        }
        map.put("length",length);
        map.put("index",index);
        return map;
    }






    public static List<Integer> sortList(List<Integer> array){
        return null;
    }
}
