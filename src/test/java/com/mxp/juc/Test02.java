package com.mxp.juc;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR:mxp
 * @DATE: 2019/1/7
 * @TIME: 13:48
 */
public class Test02 {

    public static void main(String[] args) {

        Test02 test02 = new Test02();



        new Thread(test02::run1).start();

        new Thread(test02::run2).start();

        new Thread(test02::run3).start();

    }

    private void run1(){
        for (int i = 0 ; i < 1000; i++){
            System.out.println("run1 ===>" + i);
        }
    }

    private void run2(){
        for (int i = 0 ; i < 1000; i++){
            System.out.println("run2 ===>" + i);
        }
    }

    private void run3(){
        for (int i = 0 ; i < 1000; i++){
            System.out.println("run3 ===>" + i);
        }
    }

}
