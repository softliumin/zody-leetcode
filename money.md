## 备忘录

```java
/**
 *  Thread 对象中有一个属性：threadLocals，定义如下：
 *  ThreadLocal.ThreadLocalMap threadLocals = null;
 *
 *
 *  ThreadLocalMap 是ThreadLocal的静态内部类
 *
 *
 *  ThreadLocalMap 中有一个属性 private Entry[] table;
 *
 *  Entry 的定义如下：(继承弱引用)
 *  static class Entry extends WeakReference<ThreadLocal<?>>
 *  ThreadLocal --->  ThreadLocalMap ---> Entry
 *
 *  强引用
 *  软引用
 *  弱引用
 *  虚引用
 *
 */

```

```java
// jvm 参数  -Xms20M -Xmx20M -Xmn10M
// 模拟内存泄漏
// 是否调用remove方法
boolean doRemove=false;
// 加锁，让多个线程串行执行，避免多个线程同时占用内存导致的内存溢出问题
        Object lockObj=new Object();
// 开启20个线程
        ExecutorService executorService=Executors.newFixedThreadPool(20);
// 为了不重复使用线程，用Map标记一下已经已使用过的线程，
        Map<Long, Integer> threadIdMap=new ConcurrentHashMap<>();
// 循环向线程变量中设置数据 1024 * 1024 = 1M
        for(int i=0;i< 20;i++){
        executorService.execute(()->{
synchronized (lockObj){
        Integer num=threadIdMap.putIfAbsent(Thread.currentThread().getId(),1);
        if(num==null){
        ThreadLocal<Byte[]>threadLocal=new ThreadLocal<>();
        threadLocal.set(new Byte[1024*1024]);
        if(doRemove){
        // 解决内存泄露关键
        threadLocal.remove();
        }
        // 将threadLocal置为空引用，利于回收
        threadLocal=null;
        // 手工回收
        System.gc();
        try{
        // 调用GC后不一定会马上回收
        Thread.sleep(2000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
        }

        System.out.println(Thread.currentThread().getName());
        }
        });
        // System.out.println(i);
        }

```
