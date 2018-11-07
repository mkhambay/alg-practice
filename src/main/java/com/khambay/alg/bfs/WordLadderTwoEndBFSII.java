package com.khambay.alg.bfs;

import java.util.*;

/**
 * Bidirectional search is to run two simultaneous searches—one forward from
 * the initial state and the other backward from the goal—hoping that the two searches meet in
 * the middle
 */
public class WordLadderTwoEndBFSII {

    public static List<List<String>> findLadders(String start, String end, List<String> wordList) {

        if(!wordList.contains(end)) {
            return new ArrayList<>();
        }

        // hash set for both ends
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);

        // initial words in both ends
        beginSet.add(start);
        endSet.add(end);

        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<>();

        // build the map
        helper(dict, beginSet, endSet, map, false);

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>(Arrays.asList(start));

        // recursively build the final result
        generateList(start, end, map, temp, result);

        return result;
    }

    private static boolean helper(Set<String> dict, Set<String> beginSet, Set<String> endSet, Map<String, List<String>> map, boolean flip) {
        if (beginSet.isEmpty()) {
            return false;
        }

        //swap for better performance - bidirectional search
        if (beginSet.size() > endSet.size()) {
            return helper(dict, endSet, beginSet, map, !flip);
        }

        // remove words on current both ends from the dict
        dict.removeAll(beginSet);
        dict.removeAll(endSet);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        Set<String> temp = new HashSet<>();

        // for each string in end 1
        for (String word : beginSet) {
            char[] chs = word.toCharArray();

            for (int i = 0; i < chs.length; i++) {
                // change one character for every position
                for (char c = 'a'; c <= 'z'; c++) {
                    char old = chs[i];
                    chs[i] = c;
                    String target = String.valueOf(chs);

                    // make sure we construct the tree in the correct direction
                    String key = flip ? target : word;
                    String val = flip ? word : target;

                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();

                    if (endSet.contains(target)) {
                        done = true;

                        list.add(val);
                        map.put(key, list);
                    }

                    if (!done && dict.contains(target)) {
                        temp.add(target);

                        list.add(val);
                        map.put(key, list);
                    }
                    chs[i] = old;
                }
            }
        }

        // early terminate if done is true
        return done || helper(dict, endSet, temp, map, !flip);
    }

    private static void generateList(String start, String end, Map<String, List<String>> map, List<String> temp, List<List<String>> result) {
        if (start.equals(end)) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
            return;
        }

        for (String word : map.get(start)) {
            temp.add(word);
            generateList(word, end, map, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println("Result  = " + findLadders(beginWord, endWord, Arrays.asList(words)));
    }
}
