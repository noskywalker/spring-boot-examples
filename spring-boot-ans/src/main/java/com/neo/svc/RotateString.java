package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/9/6 10:09
 */
public class RotateString {
    public static void main(String[] args) {

        String s="abcdcdcdcba";
        rotate(s);
    }

    public static void rotate(String str) {
        char[] chars = str.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        boolean ret=true;
        while (i<=j) {
            if(i==j){
                break;
            }
            if (chars[i] == chars[j]) {
                i++;
                j--;
            }else{
                ret=false;
                break;
            }
        }

        System.out.println("ret is:"+ret);
    }
}
