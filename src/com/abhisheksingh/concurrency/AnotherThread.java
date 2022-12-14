package com.abhisheksingh.concurrency;

import static com.abhisheksingh.concurrency.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{

    @Override
    public void run() {

        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            System.out.println("Another thread woke me up");
            return;
        }
        System.out.println(ANSI_BLUE + "Five seconds have passed I am awake ");
    }
}
