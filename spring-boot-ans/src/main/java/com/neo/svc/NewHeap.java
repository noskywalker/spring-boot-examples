package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/9/7 20:42
 */
public class NewHeap {
   static int length=0;
   static int heaps[]={0,0,0,0,0,0,0,0,0};

    public static void main(String[] args) {

    }

    public static void heapifyV2(){
        int arrays[]={1,7,6,4,5,3,9,8,2};

        int len=arrays.length;
        for(int j=len;j>=len/2;j--){

        }
    }

    public static void hhh(int a[]){

    }

    public  static void init(){
        int arrays[]={1,7,6,4,5,3,9,8,2};

        for(int i:arrays){
            heaps[length]=i;
            length++;
            heapify(heaps);
        }
    }

    public static void heapify(int a[]){
        int i=length-1;
        if(length<=1){
            return;
        }
        while(true){
            if(i<=0){
                break;
            }
            int parentIndex=(i-1)/2;
            if(a[i]>a[parentIndex]){
                swap(a,i,parentIndex);
            }
            i=(i-1)/2;
        }
    }
    private static void swap(int[] a, int i, int length) {
        int c=a[i];
        a[i]= a[length];
        a[length]=c;
    }



}
