package org.lig.interview;

public class MyQueue <E>{

    private int size;
    private int headIndex;
    private int tailIndex;
    Object[] items;

    public MyQueue(int size) {
        items = new Object[size];
    }

    public synchronized void put(E item){
        if (size==items.length) {
            try {
                System.out.println("队列满，等待移除");
                wait();
                System.out.println("队列满后有消费唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("队列未满，直接方如");
        }
        items[tailIndex]=item;
        if(tailIndex+1>=items.length){
            tailIndex=0;
        }else{
            tailIndex++;
        }
        size++;
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        if(size==0){
            System.out.println("队列空，等待放入并唤醒");
            wait();
            System.out.println("take被唤醒");
        }else{
            System.out.println("队列不为空，直接处理");
        }
        Object returnItem = items[headIndex];
        if(headIndex+1>=items.length){
            headIndex=0;
        }else{
            headIndex++;
        }
        notifyAll();
        size--;
        return (E) returnItem;
    }

    public static void main(String[] args) {
        final MyQueue<String> myQueue = new MyQueue<String>(1);


        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println("放入："+"put-"+i);
                    myQueue.put("put-"+i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    String val = null;
                    try {
                        val = myQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("取出："+val);

                }
            }
        }).start();

    }
}
