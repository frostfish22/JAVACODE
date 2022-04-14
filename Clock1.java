import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Clock1{
    public static void main(String[] args) {
        new Clock1();
    }
    public Clock1() {
        JFrame frame = new JFrame("时钟");
        //设置窗口图标
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("blue.jpg");
        frame.setIconImage(icon);
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea();
        frame.setVisible(true);
        frame.setSize(100, 200);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    Date date = new Date();
                    SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
                    textArea.setText(s.format(date));
                    panel.add(textArea);
                    frame.add(panel);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}