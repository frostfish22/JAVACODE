package 数据结构;

public class LinkedList<T> {
    public class Node<T>{
        T data;
        Node<T> next;
    }
    private Node<T> head;//头节点
    private Node<T> tail;//尾节点
    private int size;
    public int size(){
        return this.size;
    }
    public T getFirst() throws Exception{
        if(this.size==0){
            throw new Exception("LL is empty.");
        }
        return this.head.data;
    }
    public T getLast() throws Exception{
        if(this.size==0){
            throw new Exception("LL is empty.");
        }
        return this.tail.data;
    }
    public T getAt(int idx) throws Exception{
        if(this.size==0){
            throw new Exception("LL is Empty");
        }
        if(idx<0||idx>=this.size){
            throw new Exception("Invalid Index");
        }
        Node<T> temp = this.head;
        for(int i = 0;i<=idx;i++){
            temp = temp.next;
        }
        return temp.data;
    }
}
