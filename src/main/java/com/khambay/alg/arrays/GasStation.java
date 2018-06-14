package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0,total = 0,tank = 0;

        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1; //move starting position forward
                total += tank; //add the negative tank value to total
                tank = 0; //reset tank
            }
        }
        //negative total + positive tank should be 0 or more, if so we can do a round trip and return start
        return (total+tank < 0)? -1: start;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println("Result = " + canCompleteCircuit(gas, cost));

        int[] gas1 = {2,3,4};
        int[] cost1 = {3,4,3};
        System.out.println("Result 1 = " + canCompleteCircuit(gas1, cost1));
    }
}
