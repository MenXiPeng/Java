package com.mxp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/19
 */
public class SocketChannelServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 打开 socket 通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 非阻塞
        serverSocketChannel.configureBlocking(false);
        // socket 地址
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",1111));
        SocketChannel sc = null;
        // 等待连接
        while ((sc = serverSocketChannel.accept()) == null){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("try to accept again...");
        }
        System.out.println("accept connection from:" + sc.getRemoteAddress());
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (sc.read(buffer) != -1){
            // 切换读取模式，将 limit 指到数据读取处，将 position 值到写前
            buffer.flip();
            byte[] b = new byte[buffer.remaining()];
            buffer.get(b);
            System.out.println(new String(b,0,b.length, StandardCharsets.UTF_8));
            // 清理缓冲区
            buffer.clear();
        }
        serverSocketChannel.close();
        sc.close();
    }

}
