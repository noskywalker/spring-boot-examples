package com.neo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantLock;

@RestController
public class HelloController {
	
    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot 2.0!";
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock();
        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(900*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }).start();

        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(900*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }).start();

        Thread.sleep(900*1000);
    }
}