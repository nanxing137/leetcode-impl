package com.acouchis.easy.multithreading;

/**
 * Created by gaopeng09 on 2020-01-09
 */
public class OrderPrint {
    public OrderPrint() {

    }

    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private volatile boolean f1 = false;
    private volatile boolean f2 = false;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock1) {
            printFirst.run();

            lock1.notifyAll();
            f1 = true;
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock1) {
            if (!f1) {
                lock1.wait();
            }
            printSecond.run();
            synchronized (lock2) {
                f2 = true;
                lock2.notifyAll();
            }

        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock2) {
            if (!f2) {
                lock2.wait();
            }
            printThird.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OrderPrint orderPrint = new OrderPrint();
        new Thread(() -> {
            try {
                orderPrint.first(() -> {
                    System.out.println(1);
                });
            } catch (InterruptedException e) {
            }
        }).start();
        new Thread(() -> {
            try {
                orderPrint.second(() -> {
                    System.out.println(2);
                });
            } catch (InterruptedException e) {
            }
        }).start();
        new Thread(() -> {
            try {
                orderPrint.third(() -> {
                    System.out.println(3);
                });
            } catch (InterruptedException e) {
            }
        }).start();
    }
}
