package com.neo.svc.mys;

/**
 * @author xianshuangzhang
 * @date 2019/9/16 13:29
 */
public class Sqrt4M {

    public static void main(String[] args) {

    }

    public static void sqrt(float n) {

        float max = n;
        float min = 0;
        float middle = n / 2;

        while (Math.abs(middle * middle - n) > 0.0000001) {
            if (middle * middle < n) {
                min = middle;
            } else {
                max = middle;
            }
        }
    }
}
