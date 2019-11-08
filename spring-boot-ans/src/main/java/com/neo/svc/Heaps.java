package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/8/26 14:10
 */
public class Heaps {

    static int heap[]={9,8,6,1,2,4,3,5,7};
    static int count=heap.length;

    public static void main(String[] args) {

        for(int i=count/2;i>=0;i--){
            heapify(heap, count, i);
        }
        System.out.println("");
    }

    public static void heapify(int heap[],int count,int i){
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

    private static void swap(int[] heap, int maxPos, int i) {
        int t=heap[maxPos];
        heap[maxPos]=heap[i];
        heap[i]=t;
    }


}
