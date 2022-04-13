package Java常用类;
//CharSequence是一个描述字符串标准的接口，常见子类有：String、StringBuffer、StringBuilder
public class JavaAPIDemo1 {
    public static void main(String[] args) {
        CharSequence str = "www.mldn.cn";
        CharSequence sub = str.subSequence(4,8);//截取部分字符串
        System.out.println(sub);
        System.out.println(str.length());//获取字符串长度
        System.out.println(str.charAt(5));//获取指定索引字符串
    }
}
