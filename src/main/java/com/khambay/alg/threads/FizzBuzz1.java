package com.khambay.alg.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz1 {

    static public class CheckBuzz {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock lock3 = new ReentrantLock();
        Lock lock4 = new ReentrantLock();

        public CheckBuzz() {
        }

        public void checkDiv3(int[] nums) {
            System.out.println("In checkDiv3");
            lock1.lock();

            try {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 3 == 0) {
                        System.out.println("num=" + nums[i] + " Fizz");
                    }
                }
            }
            finally {
                lock1.unlock();
            }
            System.out.println("Done checkDiv3");
        }

        public void checkDiv5(int[] nums) {
            System.out.println("In checkDiv5");
            lock2.lock();

            try {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 5 == 0) {
                        System.out.println("num=" + nums[i] + " Fizz");
                    }
                }
            }
            finally {
                lock2.unlock();
            }
            System.out.println("Done checkDiv5");
        }

        public void checkDiv3and5(int[] nums) {
            System.out.println("In checkDiv3and5");
            lock3.lock();

            try {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 3 == 0 && nums[i] % 5 == 0) {
                        System.out.println("num=" + nums[i] + " Fizz");
                    }
                }
            }
            finally {
                lock3.unlock();
            }
            System.out.println("Done checkDiv3and5");
        }

        public void getNumbers(int[] nums) {
            System.out.println("In getNumbers");
            lock4.lock();

            try {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 3 != 0 && nums[i] % 5 != 0) {
                        System.out.println("num=" + nums[i] + " Fizz");
                    }
                }
            }
            finally {
                lock4.unlock();
            }
            System.out.println("Done getNumbers");
        }
    }

    public static void main(String[] args) {
        CheckBuzz checkBuzz = new CheckBuzz();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Thread one = new Thread(()-> checkBuzz.checkDiv3(nums));
        one.start();

        Thread two = new Thread(()-> checkBuzz.checkDiv5(nums));
        two.start();

        Thread three = new Thread(()-> checkBuzz.checkDiv3and5(nums));
        three.start();

        Thread four = new Thread(()-> checkBuzz.getNumbers(nums));
        four.start();
    }
}
