package com.easy.tool;

import static org.junit.Assert.assertTrue;

import com.easy.tool.utils.pinyin.PingYinUtil;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String code = "转拼音";

        String pingYin = PingYinUtil.getPingYin(code);
        System.out.println(pingYin);
    }
}
