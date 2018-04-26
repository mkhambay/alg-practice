package com.khambay.alg.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * All the operations are O(1) with the use of Array and Hash Table together
 */
public class RandomizedSet {

    ArrayList<Integer> valList;   //Needed for O(1) Access time in getRandom
    HashMap<Integer, Integer> valIndexMap;  //Has O(1) for Search, Insertion, Deletion
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valList = new ArrayList<>();
        valIndexMap = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valIndexMap.containsKey(val)) {
            return false;
        }

        valIndexMap.put(val, valList.size());
        valList.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valIndexMap.containsKey(val)) {
            return false;
        }

        int index = valIndexMap.get(val);

        //Move the val to end of list. With this list.remove will work in O(1) otherwise it can be O(n)
        if (index < valList.size() - 1 ) {
            int lastVal = valList.get(valList.size() - 1);
            valList.set(index , lastVal);  //overrides the current val with lastVal. Its like a remove.
            valIndexMap.put(lastVal, index);  //save the new lastVal index
        }

        valIndexMap.remove(val);
        valList.remove(valList.size() - 1); //this will remove the last value, it was already saved at index above
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return valList.get( rand.nextInt(valList.size()));
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }
}
