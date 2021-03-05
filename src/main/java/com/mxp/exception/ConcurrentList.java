package com.mxp.exception;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 *
 * @author menxipeng by 2021/1/28
 */
class VolatileColumn {

    int x = 0;
    volatile boolean v = false;

    public void write(){
        x = 42;
        v = true;
    }

    public void read(){
        if (v){
            System.out.println("-----" + x);
        }
    }

}
public class ConcurrentList {


    public static void main(String[] args) throws InterruptedException {
        VolatileColumn v = new VolatileColumn();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.write();

        },"t1").start();
        new Thread(() -> {
            for (;;){
                v.read();
            }
        },"t2").start();

        TimeUnit.SECONDS.sleep(1000);

        //
        // List<String> list = new Vector<>(32);
        // List<String> list1 = Collections.synchronizedList(new ArrayList<>(32));
        // List<String> list2 = new CopyOnWriteArrayList<>();
        //
        // Set<String> set = new HashSet<>();
        // set.add("1");
        //
        // for (int i = 0; i < 3; i++) {
        //
        // }
        // new ReentrantLock(true).lock();
    }




}
