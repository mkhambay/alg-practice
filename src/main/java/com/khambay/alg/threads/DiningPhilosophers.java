package com.khambay.alg.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public static int size = 3;

    public void start() {
        ChopStick[] chopsticks = new ChopStick[size + 1];
        for (int i = 0; i < size + 1; i++) {
            chopsticks[i] = new ChopStick();
        }

        Philosopher[] philosophers = new Philosopher[size];
        for (int i = 0; i < size; i++) {
            ChopStick left = chopsticks[leftOf(i)];
            ChopStick right = chopsticks[rightOf(i)];
            philosophers[i] = new Philosopher(i, left, right);
        }

        for (int i = 0; i < size; i++) {
            philosophers[i].start();
        }
    }

    public static int leftOf(int i) {
        return i;
    }

    public static int rightOf(int i) {
        return (i + 1) % size;
    }

    class ChopStick {
        private Lock lock;

        public ChopStick() {
            lock = new ReentrantLock();
        }

        public boolean pickUp() {
            return lock.tryLock();
        }

        public void putDown() {
            lock.unlock();
        }
    }

    class Philosopher extends Thread {
        private int bites = 10;
        private ChopStick left;
        private ChopStick right;
        private int index;

        public Philosopher(int i, ChopStick left, ChopStick right) {
            index = i;
            this.left = left;
            this.right = right;
        }

        public void eat() {
            System.out.println("Philosopher " + index + " start eating");
            if(pickUp()) {
                chew();
                putDown();
                System.out.println("Philosopher " + index + " done eating");
            }
        }

        public void chew() {
            System.out.println("Philosopher " + index + " eating");
        }

        public boolean pickUp() {
            if(!left.pickUp()) {
                return false;
            }

            if(!right.pickUp()) {
                left.putDown();
                return false;
            }
            return true;
        }

        public void putDown() {
            right.putDown();
            left.putDown();
        }

        public void run() {
            for(int i = 0; i < bites; i++) {
                System.out.println("In eat i[" + i + "]");
                eat();
            }
        }
    }

    public static void main(String args[]) {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        diningPhilosophers.start();
    }
}
