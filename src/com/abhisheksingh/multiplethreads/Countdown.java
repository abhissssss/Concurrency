package com.abhisheksingh.multiplethreads;

import com.abhisheksingh.concurrency.ThreadColor;

class Countdown {
    private int i ;
    public  void doCountdown () {

        String color = switch (Thread.currentThread().getName()) {
            case "Thread 1" -> ThreadColor.ANSI_CYAN;
            case "Thread 2" -> ThreadColor.ANSI_PURPLE;
            default -> ThreadColor.ANSI_GREEN;
        };
        synchronized (this){
            for ( i = 10; i >0 ; i--) {
                System.out.println(color + Thread.currentThread().getName() + " : i= " + i);

            }
        }

    }

}
