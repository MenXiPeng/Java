package com.mxp.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/19
 */
public class NIODemo {
    public static void main(String[] args) throws IOException {
        // FileInputStream fis = new FileInputStream("/Users/menxipeng/Downloads/文稿.txt");
        // // 获取通道
        // FileChannel fc = fis.getChannel();
        // // 创建缓冲区
        // ByteBuffer buffer = ByteBuffer.allocate(1024);
        // // 数据读取到通道中
        // fc.read(buffer);
        //
        // buffer.flip();
        //
        // byte[] dst = new byte[buffer.limit()];
        // buffer.get(dst);
        //
        // System.out.println(new String(dst,0,dst.length, "GBK"));

        BigDecimal b1 = new BigDecimal(100);

        BigDecimal b2 = new BigDecimal(1);

        System.out.println(b1.multiply(b2));
        for (int i = 0; i < 10; i++) {
            b1 = b1.add(new BigDecimal(2));
        }
        System.out.println(b1);

        //SocketChannel sc =
    }
}
