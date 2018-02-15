package com.khambay.alg.threads;

import java.util.concurrent.Semaphore;

public class CallInOrder {

    static public class Foo {
        Semaphore sem1, sem2;

        public Foo() {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);

            try {
                sem1.acquire();
                sem2.acquire();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void first() {
            System.out.println("In first");
            sem1.release();
            System.out.println("Done first");
        }

        public void second() {
            System.out.println("In second");
            try {
                sem1.acquire();
                sem1.release();
                sem2.release();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done second");
        }

        public void third() {
            System.out.println("In third");
            try {
                sem2.acquire();
                sem2.release();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done third");
        }
    }

    public static void main(String args[]) {
        Foo foo = new Foo();

        Thread c = new Thread(() -> {
                    System.out.println("Calling third");
                    foo.third();
                });
        c.start();

        Thread b = new Thread(() -> {
            System.out.println("Calling second");
                    foo.second();
                });
        b.start();

        Thread a = new Thread(() -> {
            System.out.println("Calling second");
            foo.first();
        });
        a.start();
    }
}
