package Orchestrator;

import java.util.ArrayList;

public class Queue {
    private ArrayList<String> buffer;

    public Queue()
    {
        this.buffer = new ArrayList<String>();
    }

    public synchronized void put(String message)
    {
        buffer.add(message);
        notify();
    }

    public synchronized String get()
    {
        String message = null;

        while (buffer.size() <= 0) {
            try {
               wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(buffer.size() > 0) {
            message = buffer.get(0);
            buffer.remove(0);
        }

        return message;
    }

}
