package org.example.jvm;

/**
 * java 堆
 *
 * @author 柳敏
 * @since 2021-03-17 15:16
 */
public class Heap {

    /**
     * 初始堆大小 -Xms
     * 堆空间最大值 -Xmx
     *
     * 新生代大小 xXmn
     * 线程堆栈大小 -Xss
     *
     * 新生代和老年代比例 -XX:NewRatio
     * 新生代中Eden与Survivor的比例 -XX:SurvivorRatio(默认是8，即Eden占新生代空间80%,另外两个 Survivor 各占 10%)
     *
     * 新生代晋升到老年代的 ：-XX:MaxTenuringThreshold
     *  G1 默认15次
     * 因为在JVM中，该数值是由四个bit来表示的，所以最大值为1111，转换十进制则为15
     * CMS 默认6次
     * https://support.oracle.com/knowledge/Middleware/1283267_1.html 不可以超过15
     *
     * 永久代大小  -XX:PermSize
     * 元空间大小（1.8开始支持） –XX:MetaspaceSize
     *
     * 永久代最大值 -XX:MaxPermSize
     * 元空间最大值（1.8开始支持） -XX:MaxMetaspaceSize
     *
     * 打印GC日志 -XX:+PrintGCDetails
     * GC类型
     *  Minor GC 触发机制：
     *  Full GC（Major GC）触发机制：
     *  GC算法：
     *   Serial 收集器（单线程收集器）
     *   ParNew 收集器 （使用复制算法，Serial 多线程版本）
     *   Parallel Scavenge 收集器 （复制算法，并行执行，新生代垃圾收集器）
     *   Serial Old 收集器 （Serial 老年代版本）
     *   Parallel Old 收集器 （Parallel Scavenge 老年代垃圾收集器）
     *   CMS 收集器 并发标记清除 Concurrent Mark Sweep（追求最短回收停顿）
     *
     *
     *  默认配置：新生代Parallel Scavenge   老年代Parallel Old
     *  常用1：  新生代  老年代
     *  常用2：  新生代ParNew  老年代CMS
     *  参考：https://huzb.me/2019/02/21/CMS-G1%E5%92%8CZGC/
     *
     *
     * 关于元空间的文章 https://www.infoq.cn/article/java-permgen-removed
     * The Next Generation Low-Latency Garbage Collector 下一代低停顿的垃圾收集器
     * 关于zgc的文章 https://club.perfma.com/article/679812
     *
     * JMM
     *
     * 方法区
     * 堆
     *
     *
     */


    /*

        虚拟机栈 Virtual Machine Stack
        本地的方法栈 Stack

        程序计数器 program counter

        方法区 Method Area，存储元信息
        堆 heap

        一行收集日志
        2021-02-22T15:47:54.512+0800: 350187.985:
        [
            GC (Allocation Failure) 2021-02-22T15:47:54.512+0800: 350187.986:
            [DefNew: 284731K->2272K(315264K), 0.0166212 secs]
            465205K->182762K(1014336K), 0.0169002 secs
        ]
        [Times: user=0.02 sys=0.00, real=0.01 secs]



     */
    public static void main(String[] args) {

    }
}
