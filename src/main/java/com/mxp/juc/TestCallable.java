package com.mxp.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR: mxp
 * @DATE: 2018/12/24
 * @TIME: 18:49
 */

/*
 * 一、创建执行线程方式三：实现 Callable 接口
 *      相较于 Runnable 接口方式，该方法有返回值，需要抛异常
 *
 */
public class TestCallable {

    public static void main(String[] args) {

        TheadDemo td = new TheadDemo();

        // 1.执行 Callable 方式，需要 FutureTask 实现类，用于接受运算结果。
        FutureTask<Integer> result = new FutureTask<>(td);

        for (int i = 0; i < 5; i++) {
            new Thread(result).start();

            // 2.接受线程运算后结果

            try {
                Integer sum = result.get(); // 运算完结果才会执行下面的程序
                System.out.println(sum);
                System.out.println("------------------------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class TheadDemo implements Callable<Integer> {

    @Override
    public Integer call() {

        int sum = 0;

        for (int i = 0; i <= 1000; i++) {
            sum++;
        }

        return sum;
    }
}