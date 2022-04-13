package Java常用类;

public class JavaAPIDemo2 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();//获取Runtime实例化对象
        System.out.println(runtime.availableProcessors());//获取处理器数量

        System.out.println("MAX_MEMORY:"+runtime.maxMemory());//获取最大可用内存
        System.out.println("TOTAL_MEMORY:"+runtime.totalMemory());//获取可用内存
        System.out.println("FREE_MEMORY:"+runtime.freeMemory());//获取空闲内存

        System.out.println("【1】TOTAL_MEMORY:"+runtime.totalMemory());
        System.out.println("【1】FREE_MEMORY:"+runtime.freeMemory());
        String str = "";
        for(int x = 0;x<3000;x++){
            str += x;//产生垃圾空间
        }
        System.out.println("【2】TOTAL_MEMORY:" + runtime.totalMemory());
        System.out.println("【2】FREE_MEMORY:" + runtime.freeMemory());
        runtime.gc();//内存释放
        System.out.println("【3】TOTAL_MEMORY:" + runtime.totalMemory());
        System.out.println("【3】FREE_MEMORY:" + runtime.freeMemory());
        System.out.println("");
    }
}
