package com.lig.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyNioServer {

    public static class ECHOClientHandler implements  Runnable{

        private SocketChannel clientChannel;
        private boolean flag = true;

        public ECHOClientHandler(SocketChannel clientChannel){
            System.out.println("客户端链接。。。");
            this.clientChannel=clientChannel;
        }
        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(50);//50个缓冲区
            try{
                while (this.flag){
                    buffer.clear();//清空缓冲区
                    int readCount = this.clientChannel.read(buffer);//向缓冲区中度数据
                    String readMessage = new String(buffer.array(),0,readCount).trim();
                    System.out.println("收到客户端数据："+readMessage);
                    String writeMessage = "[echo]"+readMessage;
                    if("byebye".equalsIgnoreCase(readMessage)){
                        writeMessage="再见";
                        this.flag=false;
                    }
                    //数据需要写入缓冲区
                    buffer.clear();
                    buffer.put(writeMessage.getBytes());
                    buffer.flip();//重置缓冲区
                    this.clientChannel.write(buffer);
                }
                clientChannel.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{

        //1、任务处理的线程池控制
        ExecutorService pool = Executors.newFixedThreadPool(10);

        //2、NIO的处理是基于channel的，所以又一个Selector负责管理所有的cahnnel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //3、//非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 4、绑定服务器端端口
        serverSocketChannel.bind(new InetSocketAddress(9999));

        //5、 打开一个selector,用来管理所有的channel
        Selector selector = Selector.open();

        //6 把channel注册到selector上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务启动");

        int keySelect = 0;//

        while((keySelect=selector.select())>0){
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iters = selectionKeySet.iterator();
            while (iters.hasNext()) {
                SelectionKey selectionKey=iters.next();
                if (selectionKey.isAcceptable()) {//为链接模式
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    if (clientChannel != null) {
                        pool.submit(new ECHOClientHandler(clientChannel));
                    }

                }else{
                    System.out.println(selectionKey);
                }
                iters.remove();
            }
        }
        pool.shutdown();
        serverSocketChannel.close();

    }
    public void start() throws  Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();

        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


    }
}
