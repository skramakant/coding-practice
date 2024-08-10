package corejava;

import java.util.concurrent.BlockingQueue;

public class ThreadCommunicationViaQueue {

    BlockingQueue<Integer> in;
    BlockingQueue<Integer> out;

    public ThreadCommunicationViaQueue(BlockingQueue<Integer> in, BlockingQueue<Integer> out) {
        this.in = in;
        this.out = out;
    }

    public void passMessage(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            int x = in.take();
                            if(x == 0) {
                                out.add(0);
                                break;
                            }
                            out.add(x);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();
    }

    public void consumeMessage() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            int x = out.take();
                            System.out.println(x);
                            if(x == 0) {
                                break;
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();
        }
}
