package com.easy.tool;

import com.easy.tool.enums.ResponseEnum;
import com.easy.tool.utils.enums.EnumUtils;
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

        String codeName = (String) EnumUtils.getCodeNameByCode(ResponseEnum.class, 200);
        System.out.println(codeName);
    }

}
