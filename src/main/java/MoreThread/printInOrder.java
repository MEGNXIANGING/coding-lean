package MoreThread;

public class printInOrder {
    private Object oj=new Object();
    private int flag=1;
    public printInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (oj){
            printFirst.run();
            flag=2;
            oj.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (oj){
            while (flag!=2){
                oj.wait();
            }
            printSecond.run();
            flag=3;
            oj.notifyAll();
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (oj){
            while (flag!=3){
                oj.wait();
            }
            printThird.run();
            oj.notifyAll();
        }
        // printThird.run() outputs "third". Do not change or remove this line.

    }
}
