package Lamdba;

public class try22 {
    public static void main(String[] args) {
        Runnable a = ()->System.out.println("helloworld");
        //等价于
        //Runnable a = new Runnable(){
        //   public void run(){
        //     System.out.println("helloworld");
        //  }
        //}
        Thread thread = new Thread(a);
        thread.start();
    }
}
