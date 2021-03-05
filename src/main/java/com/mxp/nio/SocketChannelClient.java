package com.mxp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/19
 */
public class SocketChannelClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 打开 socket 通道
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("127.0.0.1", 1111));
        while (!sc.finishConnect()){
            System.out.println("connection has not finished,wait...");
            TimeUnit.SECONDS.sleep(1);
        }
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        writeString(buffer, sc,"hello");
        writeString(buffer, sc,"world");
        writeString(buffer, sc,"exit");
        sc.close();

    }

    private static void writeString(ByteBuffer buffer, SocketChannel sc,String str) {
        buffer.clear();
        buffer.put(str.getBytes()).flip();
        try {
            sc.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
