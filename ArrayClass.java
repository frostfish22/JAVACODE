import java.util.Scanner;

public class ArrayClass{
    public int arr[];
    public void init(int n){
        arr = new int[n];
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
    }
    public int max(){
        int big=0;
        for(int x:arr){
            if(x>big){
                big = x;
            }
        }
        return big;
    }
    public boolean search(int n){
        for(int x:arr){
            if(x==n){
                return true;
            }
        }
        return false;
    }
    public int average(){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum/arr.length;
    }
    public void out(){
        for(int x:arr){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        ArrayClass arrayClass = new ArrayClass();
        arrayClass.init(5);
        arrayClass.out();
        arrayClass.search(2);
        System.out.println(arrayClass.max());
        System.out.println(arrayClass.average());
        System.out.println(arrayClass.average()*5);
    }
}