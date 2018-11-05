package com.light.pointoffer.item2;

/**
 * 单例模式
  	对于singleton = new Singleton()，这不是一个原子操作，在 JVM 中包含的三个过程。

	1>给 singleton 分配内存
	2>调用 Singleton 的构造函数来初始化成员变量，形成实例
	3>将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
	
	但是，由于JVM会进行指令重排序，所以上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是 1-3-2，则在 3 执行完毕、2 未执行之前，被l另一个线程抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以这个线程会直接返回 instance，然后使用，那肯定就会报错了。
	针对这种情况，我们有什么解决方法呢？那就是把singleton声明成 volatile ，改进后的懒汉式线程安全（双重检查锁）
 
 */
public class Singleton {
	
	private volatile static Singleton instance = null;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(instance ==null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
}
