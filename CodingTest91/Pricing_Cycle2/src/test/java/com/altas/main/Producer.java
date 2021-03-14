package com.altas.main;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    @SuppressWarnings("rawtypes")
	protected BlockingQueue queue = null;

    public Producer(@SuppressWarnings("rawtypes") BlockingQueue queue) {
        this.queue = queue;
    }

    @SuppressWarnings("unchecked")
	public void run() {
        try {
            queue.put("1");
            Thread.sleep(5000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}