package com.khambay.alg.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockFree {

    public void run() {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        Thread a = new Thread(new WorkerA(resourceA,resourceB));
        a.start();

        Thread b = new Thread(new WorkerB(resourceB,resourceA));
        b.start();
    }

    //Resource A
    class ResourceA {
        Lock lock;

        public ResourceA() {
            lock = new ReentrantLock();
        }

        public boolean lock() {
            System.out.println("Try lock Resource A");
            return lock.tryLock();
        }

        public void unlock() {
            System.out.println("Try unlock Resource A");
            lock.unlock();
        }
    }

    //Resource B
    class ResourceB {
        Lock lock;

        public ResourceB() {
            lock = new ReentrantLock();
        }

        public boolean lock() {
            System.out.println("Try lock Resource B");
            return lock.tryLock();
        }

        public void unlock() {
            System.out.println("Try unlock Resource B");
            lock.unlock();
        }
    }

    //Thread A -> lock on Resource B and needs lock on Resource A to continue
    class WorkerA implements Runnable {
        ResourceA a;
        ResourceB b;


        public WorkerA(ResourceA a, ResourceB b) {
            this.a = a;
            this.b = b;
        }

        public void run() {
            System.out.println("In Worker A run");
            a.lock();
            b.lock();

            try {
                System.out.println("Sleeping 2 secs in Thread A");
                Thread.sleep(2000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }

            b.unlock();
            a.unlock();
        }
    }

    //Thread B -> lock on Resource A and needs lock on Resource B to continue
    class WorkerB implements Runnable {
        ResourceA a;
        ResourceB b;


        public WorkerB(ResourceB b, ResourceA a) {
            this.b = b;
            this.a = a;
        }

        public void run() {
            System.out.println("In Worker A run");
            b.lock();
            a.lock();

            try {
                System.out.println("Sleeping 2 secs in Thread A");
                Thread.sleep(2000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            a.unlock();
            b.unlock();
        }
    }

    public static void main(String args[]) {
        DeadlockFree deadlockFree = new DeadlockFree();
        deadlockFree.run();
    }
}
