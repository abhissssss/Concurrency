package com.abhisheksingh.producerandconsumer;

import java.util.Random;

class Writer implements Runnable {
    private final Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String [] sentText = {"Hey you Coming",
                "When will you be there",
                "Did you prepare for the speech",
                "5 minutes to go"
        };
        Random random = new Random();
        for (String s : sentText) {
            message.write(s);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        message.write("Finished");
    }
}
