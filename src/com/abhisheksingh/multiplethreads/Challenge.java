package com.abhisheksingh.multiplethreads;

import com.abhisheksingh.concurrency.ThreadColor;

public class Challenge {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
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
class CountdownThread extends Thread {
    private final Countdown threadCountdown;

    public CountdownThread(Countdown Countdown) {
        this.threadCountdown = Countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}