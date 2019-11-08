package com.neo.svc.mys;

/**
 * @author xianshuangzhang
 * @date 2019/9/17 09:09
 */
public class Jinzhi62 {
    static char c[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                       'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                       'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                       'u', 'v', 'w', 'x', 'y', 'z','A', 'B', 'C', 'D',
                       'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N',
                       'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                       'Y', 'Z'};

    public static void main(String[] args) {

        long v = 769876544444L;
        exchange(v);
    }

    public static void exchange(long seq) {
        String full = "";
        while (true) {
            int index = (int) seq % 62;
            char cc = c[Math.abs(index)];
            full = cc + full;
            seq = (int) seq / 62;
            if (seq <= 0) {
                break;
            }
        }
        System.out.println(full);

    }
}
