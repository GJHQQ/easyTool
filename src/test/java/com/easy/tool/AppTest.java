package com.easy.tool;

import com.alibaba.fastjson.JSON;
import com.easy.tool.entity.User;
import com.easy.tool.enums.ResponseEnum;
import com.easy.tool.utils.anno.ToJsonIgnoreUtils;
import com.easy.tool.utils.enums.EnumUtils;
import com.easy.tool.utils.json.JsonUtils;
import org.junit.Test;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        User user = new User();
        user.setId(100001);
        user.setName("zhangsan");
        user.setCount(100002);
        user.setPassword("121212");


        JSON json = JsonUtils.customToJson(user,0);
        System.out.println(json);
    }

}
