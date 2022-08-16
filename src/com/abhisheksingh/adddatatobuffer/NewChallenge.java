package com.abhisheksingh.adddatatobuffer;

import com.abhisheksingh.concurrency.ThreadColor;

import java.util.ArrayList;
import java.util.List;

public class NewChallenge {
    public static final String EOF = "EOF";
    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>(); //It will cause a problem as we know that ArrayList is not thread safe
        MyProducer producer = new MyProducer(buffer,ThreadColor.ANSI_PURPLE);
        MyConsumer consumer1 = new MyConsumer(buffer,ThreadColor.ANSI_GREEN);
        MyConsumer consumer2 =  new MyConsumer(buffer,ThreadColor.ANSI_RED);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
     }

}
