package com.abhisheksingh.adddatatobuffer;

import java.util.List;

import static com.abhisheksingh.adddatatobuffer.NewChallenge.EOF;

public class MyConsumer implements Runnable {

    private final List<String> buffer;
    private final String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {

                if (buffer.isEmpty()){
                    continue;
                }
                if (buffer.get(0).equals(EOF)){
                    System.out.println(color + "Exiting");
                    break;
                }
                else{
                    System.out.println(color + "Removed" + buffer.remove(0));
                }
            }
        }
    }
}
