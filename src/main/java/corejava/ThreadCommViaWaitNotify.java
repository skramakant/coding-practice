package corejava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThreadCommViaWaitNotify {
    LinkedList<Integer> list = new LinkedList<>();
    // wait notify and notify can be called inside object only
    final Object lock = new Object();

    public void produce() {
        int val = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() >= 10) {
                    try {
                        // wait if list size becomes 10
                        // wait for consumer to consume
                        // consumer will notify this thread once it consumes
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.add(val++);
                // notify consumer
                // wait and notify should get called inside syncronized block
                lock.notify();
            }
        }
    }


    public void consumer() {
        while (true) {
            synchronized (lock) {
                //wait for producer to produce
                while (list.size() == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(list.removeFirst());
                //notify producer
                // wait and notify should get called inside syncronized block
                lock.notify();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
