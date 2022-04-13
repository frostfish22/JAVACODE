package Java常用类;

class JavaAPIDemo{
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer("www.");//实例化StringBuffer
        buf.append("mldn").append(".cn");// StringBuffer添加操作，修改buf中的内容
        String data = buf.toString();//将StringBuffer变为String实例
        System.out.println(data);//输出数据

        buf = new StringBuffer();
        buf.append(".cn").insert(0,"www.").insert(4,"mldn");//插入数据
        System.out.println(buf);

        buf = new StringBuffer();
        buf.append("Hello, world!").delete(6,12).insert(6, "MLDN");//删除指定范围中的内容
        System.out.println(buf);

        buf = new StringBuffer();
        buf.append("Hello, world!");
        System.out.println(buf.reverse());//反转输出
    }
}
