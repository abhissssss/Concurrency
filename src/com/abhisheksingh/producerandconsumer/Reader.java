package com.abhisheksingh.producerandconsumer;

import java.util.Random;

class Reader implements Runnable {
    private final Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished");
             latestMessage = message.read()) {
            System.out.println(latestMessage);
        }
        try {
            Thread.sleep(random.nextInt(2000));
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
