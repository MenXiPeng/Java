package com.mxp.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR:mxp
 * @DATE: 2019/1/7
 * @TIME: 14:33
 */
public class Test03 {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Test03 test03 = new Test03();
        Future<String> result = pool.submit(new Thread(test03::run1), "6666");
        result.get();
        pool.shutdown();
    }

    private void run1(){
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void run2(){

    }

    private void run3(){

    }
}
