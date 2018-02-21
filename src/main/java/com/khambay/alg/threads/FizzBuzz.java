package com.khambay.alg.threads;

import java.util.concurrent.Semaphore;

public class FizzBuzz {

    static public class CheckBuzz {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Semaphore sem;

        public CheckBuzz() {
            sem = new Semaphore(1);

            try {
                sem.acquire();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void checkDiv3() {
            System.out.println("In checkDiv3");
            try {
                sem.acquire();

                for (int i = 0; i < nums.length; i++) {
                    if(nums[i] % 3 == 0) {
                        System.out.println("num=" + nums[i] + " Fizz");
                    }
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                sem.release();
            }
            System.out.println("Done checkDiv3");
        }

        public void checkDiv5() {
            System.out.println("In checkDiv5");
            try {
                sem.acquire();

                for (int i = 0; i < nums.length; i++) {
                    if(nums[i] % 5 == 0) {
                        System.out.println("num=" + nums[i] + " Buzz");
                    }
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                sem.release();
            }
            System.out.println("Done checkDiv5");
        }

        public void checkDiv3and5() {
            System.out.println("In checkDiv3and5");
            try {
                sem.acquire();

                for (int i = 0; i < nums.length; i++) {
                    if(nums[i] % 3 == 0 && nums[i] % 5 == 0) {
                        System.out.println("num=" + nums[i] + " FizzBuzz");
                    }
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                sem.release();
            }
            System.out.println("Done checkDiv3and5");
        }

        public void generateNumbers() {
            System.out.println("In generateNumbers");
            sem.release();
            System.out.println("Done generateNumbers");
        }
    }

    public static void main(String[] args) {
        CheckBuzz checkBuzz = new CheckBuzz();

        Thread one = new Thread(()-> checkBuzz.checkDiv3());
        one.start();

        Thread two = new Thread(()-> checkBuzz.checkDiv5());
        two.start();

        Thread three = new Thread(()-> checkBuzz.checkDiv3and5());
        three.start();

        Thread four = new Thread(()-> checkBuzz.generateNumbers());
        four.start();
    }
}
