package com.neo.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author xianshuangzhang
 * @date 2019/10/29 14:22
 */
public class Streams {

    public static void main(String[] args) {
        String s[]={"abcedf","ghijklmn"};
//        Arrays.stream(s).map(i->i.split("")).flatMap(Arrays::stream).forEach(System.out::println);
        Arrays.stream(s).map(i->i.split("")).collect(Collectors.toList()).stream().forEach(System.out::print);
    }
}
