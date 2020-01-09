package com.acouchis.easy.multithreading;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean s = false;

    private final Object lock = new Object();

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.

            synchronized (lock) {
                lock.notifyAll();
                printFoo.run();
                s = true;
                if (i != n - 1) {
                    lock.wait();
                }

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.

            while (true){
                if (s){
                    break;
                }
            }
            synchronized (lock) {
                lock.notifyAll();
                printBar.run();
                if (i != n - 1) {
                    lock.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(100);

        new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
            }
        }).start();
    }
}