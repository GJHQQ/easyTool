package com.easy.tool;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSONObject;
import com.easy.tool.enums.ResponseEnum;
import com.easy.tool.utils.ajax.RestResult;
import com.easy.tool.utils.http.HttpClient;
import com.easy.tool.utils.pinyin.PingYinUtil;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(54);
        list.add(96);
        list.add(100);


        RestResult rest = RestResult.otherCode(500).msg("你好").data(list);
        System.out.println(rest);
    }

}
