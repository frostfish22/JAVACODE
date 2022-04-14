package JUC并发编程;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
//TimeUnit是一个描述时间单元的枚举类。
//利用此类可以方便实现各个时间单元数据的转换，也可以更加方便实现线程的休眠时间控制。
public class JUCDemo {
    public static void main(String[] args) {
        long hour =1;
        long second = TimeUnit.SECONDS.convert(hour,TimeUnit.HOURS);
        System.out.println(second);
        //时间单元转换

        //获取18天后的日期
        long current = System.currentTimeMillis();
        long after = current+TimeUnit.MILLISECONDS.convert(18,TimeUnit.DAYS);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(after)));

        //使用TimeUnit休眠线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x=0;x<10;x++){
                    try {//可以直接利用具体时间单位设置具体的休眠时长
                        TimeUnit.MINUTES.sleep(1);//休眠1分钟
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("【"+Thread.currentThread().getName()+"】x = "+x);
                }
            }
        }).start();

    }
}
