package com.neo.svc.mys;

/**
 * @author xianshuangzhang
 * @date 2019/9/17 22:50
 */
public class Heap {

    /**
     *
     * 1 2 3 4 5 6
     *
     * 123
     * 124
     * 125
     * 126
     * 134
     * 135
     * 136
     * 145
     * 146
     * 156
     * 234
     * 235
     * 236
     * 245
     * 246
     * 256
     * 345
     * 346
     * 356
     * 456
     *
     *
     *
     */
    static int [] array={5,6, 4, 3, 7, 1, 2, 9, 10};
    //                   0 01 02 13 14 25 26 37 38
    public static void main(String[] args) {

        heap(array);
    }

    public static void heap(int a[]){

        int length=0;
        int heap[]=new int[a.length];
        for(int i:a){
            heap[length]=i;
            length++;
            heapify(heap,length);
        }
    }

    public static void heapify(int a[],int length){
        int index=length-1;
        while(true){
            if(index<0){
                break;
            }
            if(a[index]>a[(index-1)/2]){
                swap(a, index, (index-1)/2);
                index=(index-1)/2;
            }else{
                break;
            }

        }

    }

    public static void swap(int a[],int i,int j){
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }
}
