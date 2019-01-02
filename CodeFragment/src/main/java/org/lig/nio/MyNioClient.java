package org.lig.nio;

import org.lig.util.InputUtil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class MyNioClient {

    public static void main(String[] args) throws Exception{

        // 打开客户端的channel
        SocketChannel clientChannel = SocketChannel.open();
        // 链接服务端
        clientChannel.connect(new InetSocketAddress(9999));

        // 开辟缓冲区buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);


        boolean flag = true;
        while (flag) {
            buffer.clear();

            java.lang.String inputData = InputUtil.getString();
            buffer.put(inputData.getBytes());
            buffer.flip();

            clientChannel.write(buffer);
            buffer.clear();

            int readCount = clientChannel.read(buffer);
            buffer.flip();

            System.out.println(new String(buffer.array(),0,readCount));

            if("byebye".equalsIgnoreCase(inputData)){
                flag=false;
            }

        }
        clientChannel.close();
    }

}
