package JUC并发编程;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class JUCDemo2 {
    public static void main(String[] args) {
        String infos []=new String[]{"www.mldn.cn","www.mldnjava.cn","www.jixianit.com"};
        AtomicReferenceArray<String> array = new AtomicReferenceArray<String>(infos);
        //在使用compareAndSet()方法进行比较时，是通过"=="方式实现的比较操作
        System.out.println(array.compareAndSet(0,"www.mldn.cn","www.yootk.com"));//使用“==”比较，内容相同则可以替换
        System.out.println(array.get(0));//替换后的数据
    }
}
