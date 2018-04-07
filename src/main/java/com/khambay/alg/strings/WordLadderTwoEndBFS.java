package com.khambay.alg.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bidirectional search is to run two simultaneous searches—one forward from
 * the initial state and the other backward from the goal—hoping that the two searches meet in
 * the middle
 */
public class WordLadderTwoEndBFS {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Edge case check
        if (!wordList.contains(endWord)) {
            return 0;
        }

        //Convert List to HashSet otherwise Time limit will be exceeded
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        //Keep track
        Set<String> visited = new HashSet<>();

        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            //swap for better performance - bidirectional search
            if(beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> temp = new HashSet<>(); //capture the new begin set to iterate

            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) { //we have reached the endWord, return
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target); //otherwise Time Limit will be exceeded
                        }
                        chs[i] = old; //put the character back
                    }
                }
            }

            beginSet = temp;
            len++;
        }
        return 0; //no transformation sequence
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println("Shortest transformation = " + ladderLength(beginWord, endWord, Arrays.asList(words)));
    }
}
