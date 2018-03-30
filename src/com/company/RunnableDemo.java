package com.company;

public class RunnableDemo implements Runnable {
    private Thread thread;
    private final String threadName;

    public RunnableDemo(String name){
        threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Running:" + threadName);
        try {
        for (int i = 0; i < 4; i++) {
            System.out.println("Thread:" + threadName + " -->" + i);
            Thread.sleep(50);

        }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread:" + threadName + "InterruptedException");

        }

        System.out.println("Thread:" + threadName + "Exiting");
    }

    public void start(){
        System.out.println("Starting:" + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
