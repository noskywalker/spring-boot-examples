package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/9/7 21:58
 */
public class Sqrt {
    public static void main(String[] args) {

        sqrt(10);
    }
    //二分法求平方根
    public static void sqrt(float x){
        float low=0;

        /**中间值**/
        float mid=x/2;

        /**上限**/
        float high=x;
        while(Math.abs(mid*mid-x)>0.0001){
            if((mid*mid)<x){
                low=mid;
            }else{
                high=mid;
            }
            mid=(low+high)/2;
            System.out.println(mid);

        }
        System.out.println(mid);
    }
}
