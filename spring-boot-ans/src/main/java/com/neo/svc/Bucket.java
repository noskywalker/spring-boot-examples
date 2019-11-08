package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/8/28 13:09
 */
public class Bucket {

    public static void main(String[] args) {
        int a[]={0,3,1,0,3};
    }

    public static int calculateVolume(int arrays[],int length){
        //先求出数组中的最大值，第一次遍历
        int max=0;//最大值
        int max_pos=0;//最大值对于数组的下标
        for (int i=0;i<length;i++)
        {
            if (max<arrays[i])
            {
                max=arrays[i];
                max_pos=i;
            }
        }

        int max_left=0;//从左边开始遍历时的极大值
        int max_right=0;//从右边开始遍历时的极大值
        int volume=0;//容积

        //从左边开始向右遍历到最大值处
        for(int i=0;i<max_pos;i++){
            //不断更新左边的极大值
            if (max_left<arrays[i])
            {
                max_left=arrays[i];
            }
            //否则，加上新增加的容积
            else{
                volume+=(max_left-arrays[i]);
            }
        }

        //从最右边开始向左遍历到最大值处
        for(int j=length-1;j>max_pos;j--){
            //不断更新右边的极大值
            if (max_right<arrays[j])
            {
                max_right=arrays[j];
            }
            //否则，加上新增加的容积
            else{
                volume+=(max_right-arrays[j]);
            }
        }

        return volume;
    }
}
