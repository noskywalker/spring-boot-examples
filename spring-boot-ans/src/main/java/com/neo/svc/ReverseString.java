package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/9/6 21:29
 */
public class ReverseString {

    public static void main(String[] args) {

        String s="abcdefgh";
        reserse(s);
    }

    public static void reserse(String string) {
        char c[] = string.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            if (i == j) {
                break;
            }
            char a = c[i];
            c[i] = c[j];
            c[j] = a;
            i++;
            j--;
        }
        String s = new String(c);
        System.out.println(s);
    }
}
