package JUC并发编程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
//
public class JUCDemo1 {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong num = new AtomicLong(100L);//实现原子操作类
        num.addAndGet(200);//增加数据并取得
        long curr = num.getAndIncrement();//先获取而再自增
        System.out.println(curr);//自增前的内容
        System.out.println(num.get());//自增后的内容
        //使用AtomicLong进行原子性操作

        //利用多线程操作数据
        AtomicLong num1 = new AtomicLong(100);
        for(int i=0;i<10;i++){
            new Thread(()->{
                num1.addAndGet(200);//增加数据并取得
            }).start();;
        }
        TimeUnit.SECONDS.sleep(2);//休眠2秒，等待执行结果
        System.out.println(num1.get());//自增后的内容

        //判断并设置新内容
        AtomicLong num2 = new AtomicLong(100L);
        System.out.println(num2.compareAndSet(100L, 300L));//内容相同，返回true
        System.out.println(num2.get());//内容为300
    }
}