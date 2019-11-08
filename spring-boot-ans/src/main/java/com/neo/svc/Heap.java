package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/8/28 00:28
 */
public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity){
        a=new int[capacity+1];
        n=capacity;
        count=0;
    }

    public static void main(String[] args) {

//            Heap h=new Heap(5);
//            h.insert(3);
//            h.insert(4);
//            h.insert(2);
//            h.insert(1);
//            h.insert(5);
//            h.remove();

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public void remove(){
        a[1]=a[count];
        heapify(a,n,1);
    }

    public  void heapify(int heap[],int count,int i){
        while(true){
            int maxPos=i;
            if(i*2<=count&&heap[i]<heap[i*2]){
                maxPos=i*2;
            }
            if(i*2+1<=count&&heap[maxPos]<heap[i*2+1]){
                maxPos=i*2+1;
            }

            if(maxPos==i){
                break;
            }
            swap(heap,maxPos,i);

            i=maxPos;
        }
    }

    public void insert(int data){
        if(count>=n){
            return;
        }
        ++count;
        a[count]=data;
        int i=count;
        while (i/2>0&&a[i]>a[i/2]){
            swap(a,i,i/2);
            i=i/2;
        }
    }
    private void swap(int[] heap, int maxPos, int i) {
        int t=heap[maxPos];
        heap[maxPos]=heap[i];
        heap[i]=t;
    }
}
