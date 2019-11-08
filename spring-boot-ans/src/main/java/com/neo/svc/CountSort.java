package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/8/28 15:25
 */
public class CountSort {

    public static void main(String[] args) {

        int a[]={3,3,2,5,6,4,3,5,4,3,2,0,1};
        count(a);
    }


    public static void count(int a[]){

        int max=0;
        for(int i:a){
           if (max<i){
               max=i;
           }
        }
        int meta[]=new int[max+1];

        for(int i:a){
            meta[i]++;
        }

        for(int i=0;i<max;i++){
            meta[i+1]=meta[i]+meta[i+1];
        }

        int fina[] =new int[a.length];
        for(int i:a){
            int index=meta[i];
            meta[i]--;
            fina[index-1]=i;
        }

        System.out.println("");

    }
}
