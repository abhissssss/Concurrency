package com.abhisheksingh.producerandconsumer;

public class Message {
    private String message;
    private boolean empty = true;

    public static void main(String[] args) {
          Message message = new Message();
          new Thread(new Writer(message)).start();
          new Thread(new Reader(message)).start();
    }
    public synchronized String read() {
        while (empty) {
           try {
               wait();
           }catch (InterruptedException e) {
             e.printStackTrace();
           }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try{
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}





