package com.abhisheksingh.multiplethreads;

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
