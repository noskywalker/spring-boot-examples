package com.neo.svc.mys;

import org.springframework.util.StringUtils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xianshuangzhang
 * @date 2019/9/19 10:33
 */
public class StringComputing {

    static String s="123456";

    public static void main(String[] args) {
        AtomicLong atomicLong=new AtomicLong();
        ss("",s,atomicLong);
        System.out.println(atomicLong.get());
    }

    public static void ss(String pre,String last, AtomicLong atomicLong){
        if(StringUtils.isEmpty(last)){
            atomicLong.incrementAndGet();
            System.out.println(pre+last);
        }else{
            for(int i=0;i<last.length();i++){
                ss(pre+last.charAt(i),last.substring(0, i)+last.substring(i+1, last.length()),atomicLong);
            }
        }
    }

}
