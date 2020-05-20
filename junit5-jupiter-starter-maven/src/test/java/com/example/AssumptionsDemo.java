package com.example;

import com.example.project.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * 简述：
 *
 * @author WangLipeng 1243027794@qq.com
 * @version 1.0
 * @since 2020/5/20 19:18
 */
class AssumptionsDemo {

    private final Calculator calculator = new Calculator();

    /**
     * 假设条件不成立，抛出中断测试异常
     */
    @Test
    void testOnlyOnCiServer() {
        assumeTrue("ENV".equals(System.getenv("ENV")));
        // remainder of test
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("ENV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // remainder of test
    }

//    @Test
//    void testInAllEnvironments() {
//        assumingThat("CI".equals(System.getenv("ENV")),
//                () -> {
//                    // perform these assertions only on the CI server
//                    assertEquals(2, calculator.divide(4, 2));
//                });
//
//        // perform these assertions in all environments
//        assertEquals(42, calculator.multiply(6, 7));
//    }

}