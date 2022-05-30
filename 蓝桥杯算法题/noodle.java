package 蓝桥杯算法题;
// 一根高筋拉面，中间切一刀，可以得到2根面条。如果先对折1次，中间切一刀，可以得到3根面条。如果连续对折2次，中间切一刀，可以得到5根面条。那么，连续对折10次，中间切一刀，会得到多少面条呢？
public class noodle {
    public int noodles(int i){
        if(i==0){
            return 1;
        }if(i==1){
            return 2;
        }
        return noodles(i-1)+noodles(i-2);
    }
}
