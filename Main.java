import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class process {
    String name;//进程名
    int arriveTime;//到达时间
    int serveTime;//服务时间
    int beginTime;//开始时间
    int finishTime;//结束时间
    int roundTime;//周转时间
    int waitTime;//等待时间
    double aveRoundTime;//带权周转时间
    double clock=0;//已经服务运行的时间
    boolean firstTimeTag=false;//在RR算法中标识开始时间是否第一次计算
    public process(){}
    public process(String name,int arriveTime,int serveTime){
        super();
        this.name=name;
        this.arriveTime=arriveTime;
        this.serveTime=serveTime;
        this.waitTime=0;
    }
    public String toString(){
        String info = new String("进程名:P"+this.name);
        return info;
    }
}
class processMenu{
    public ArrayList<process> pro= new ArrayList<process>();//存放所有进程
    public LinkedList<process> link = new LinkedList<process>();;//存放已经进入队列的进程
    public ArrayList<process> new_pro = new ArrayList<process>();;//存放指定调度算法排序后的进程
    public process nowProess;//当前执行进程
    public void init(){//初始化
        process p1 = new process("A",0,5);
        process p2 = new process("B",1,5);
        process p3 = new process("C",2,2);
        process p4 = new process("D",5,1);
        pro.add(p1);
        pro.add(p2);
        pro.add(p3);
        pro.add(p4);
    }
    public void FCFS(){//先来先服务算法
        ProcessQueue pq = new ProcessQueue();
        pq.EnqueueLast();//进程入队
        System.out.println("******************************************");
        while(!link.isEmpty()){
            pq.DisplayQueue();//打印当前队列中的进程
            pq.Dequeue();//出队
            pq.EnqueueLast();//进程入队
            Collections.sort(link,new compareAt_St());
        }
    }
    public void SJF(){
        ProcessQueue pq = new ProcessQueue();
        pq.EnqueueLast();
        System.out.println("******************************************");
        while(!link.isEmpty()){
            pq.DisplayQueue();
            pq.Dequeue();
            pq.EnqueueLast();
            Collections.sort(link,new compareSt());
        }
    }
    public void HRRN(){
        ProcessQueue pq = new ProcessQueue();
        pq.EnqueueLast();
        System.out.println("******************************************");
        while (!link.isEmpty()) {
            pq.DisplayQueue();
            pq.Dequeue();
            pq.EnqueueLast();
            Collections.sort(link, new compareRt());
        }
    }
    public void RR(){
        ProcessQueue pq = new ProcessQueue();
        pq.EnqueueLast();
        System.out.println("******************************************");
        while (!link.isEmpty()) {
            pq.DisplayQueue();
            pq.Dequeue(1);
        }
    }
    class ProcessQueue{
        int k=0;//pro中的进程遍历时的下标
        int nowTime = 0;//当前时间
        int i=0;//记录当前出入队列的次数
        public void EnqueueLast(){
            while(k<pro.size()){
                if(pro.get(k).arriveTime<=nowTime){//已经到达的进程按到达时间先后进入队列
                    link.addLast(pro.get(k));
                    k++;
                }else{
                    break;
                }
            }
        }
        public void EnqueueFirst(){//进程入队
            while(k<pro.size()){//遍历pro
                if(pro.get(k).arriveTime<=nowTime){// 已经到达的进程按到达时间先后进入队列
                    link.addFirst(pro.get(k));
                    k++;
                }else{
                    break;//如果该进程还未入队，即先结束遍历，保留当前k值！！
                }
            }
        }
        public void Dequeue(){//进程出队，一次只出一个
            nowProess = link.removeFirst();//移除队列的队首元素并且返回该对象元素
            nowProess.beginTime = nowTime;//计算开始时间，即为上一个进程的结束时间
            nowProess.finishTime = nowProess.beginTime+nowProess.serveTime;//计算结束时间，该进程开始时间+服务时间
            nowProess.roundTime = nowProess.finishTime;//计算周转时间
            nowProess.aveRoundTime = (double)nowProess.roundTime/nowProess.serveTime;//计算平均周转时间
            nowTime = nowProess.finishTime;//获得结束时间，即当前时间，方便判断剩下的进程是否已到达
            new_pro.add(nowProess);//经处理过数据后加入new_pro容器
            for(int i=0;i<link.size();++i){
                link.get(i).waitTime++;//所有进入等待队列的进程等待时间+1
            }
        }

        public void Dequeue(double sliceTime){//重载Dequeue方法，实现轮转调度算法的出队
            nowProess = link.removeFirst();//取出队首元素
            if(nowProess.firstTimeTag==false){
                nowProess.beginTime = nowTime;//进程开始执行的时间
                nowProess.firstTimeTag=true;//计算第一次即可，下次无需更新计算
            }
            nowTime+=sliceTime;//用掉一个时间片
            nowProess.clock+=sliceTime;//更新clock
            if(nowProess.clock>=nowProess.serveTime){
                nowProess.finishTime = nowTime;//计算该进程完成时间
                nowProess.roundTime = nowProess.finishTime - nowProess.arriveTime;//计算周转时间
                nowProess.aveRoundTime = (double)nowProess.roundTime/nowProess.serveTime;//计算平均周转时间
                new_pro.add(nowProess);
                EnqueueFirst();//已到达的进程先入队
            }else{
                EnqueueFirst();//已到达的进程先入队
                link.addLast(nowProess);//上一轮出的再紧接着进入队尾
            }
        }
        public void DisplayQueue(){//打印队列中等候的进程
            i++;
            System.out.println("第"+i+"次队列中排队的进程："+link);
        }
        
    }
    public void printProcess(){
        System.out.println("进程名\t到达时间\t服务时间\t开始时间\t完成时间\t周转时间\t带权周转时间");
        for(int i = 0;i<new_pro.size();++i){
            System.out.println("P"+new_pro.get(i).name + "\t" + new_pro.get(i).arriveTime + "\t" +
		new_pro.get(i).serveTime+ "\t" + new_pro.get(i).beginTime + "\t" + new_pro.get(i).finishTime +
		"\t"+ new_pro.get(i).roundTime + "\t" + new_pro.get(i).aveRoundTime);
        }
        new_pro.clear();
    }
}

class compareAt_St implements Comparator<process> {// 按到达时间升序，若到达时间相同，按服务时间升序
    public int compare(process o1, process o2) {
        int a = o1.arriveTime - o2.arriveTime;
        if (a > 0)
            return 1;
        else if (a == 0) {
            return o1.serveTime > o2.serveTime ? 1 : -1;
        } else
            return -1;
    }
}

class compareSt implements Comparator<process> {

    @Override
    public int compare(process o1, process o2){
        // TODO 自动生成的方法存根
        return o1.serveTime >= o2.serveTime ? 1 : -1;
    }

}

class compareRt implements Comparator<process> {

    @Override
	public int compare(process o1, process o2) {
		// TODO 自动生成的方法存根
		double r1=(double) (o1.waitTime+o1.serveTime)/o1.serveTime;
		double r2=(double) (o2.waitTime+o2.serveTime)/o2.serveTime;
		return r1<r2?1:-1;
	}
}

public class Main{
    public static void main(String[] args) {
        processMenu pm=new processMenu();
		pm.init();//初始化容器
		pm.FCFS();
		pm.printProcess();
		pm.SJF();
		pm.printProcess();
		pm.HRRN();
		pm.printProcess();
		pm.RR();
		pm.printProcess();
    }
}