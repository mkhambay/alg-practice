package com.khambay.alg.strings;

/**
 * Time - O(n)
 * Space - (1)
 */
public class OneAway {

    boolean oneEditAway(String first, String second) {
        if(first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        else if(first.length() + 1 == second.length()) { //first is smaller
            return oneEditInsert(first, second);
        }
        else if(first.length() - 1 == second.length()) { //second is smaller
            return oneEditInsert(second, first);
        }
        return false; //more than one char away ex. pale, palent
    }

    boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;

        //look for only one difference in the chars between s1 and s2
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    boolean oneEditInsert(String small, String big) {
        int i = 0;
        int j = 0;
        boolean foundDifference = false;

        while(i < small.length() && j < big.length()) {

            //checks for only 1 difference and moves only pointer j++. If the rest of the string does
            //not match remaining small, it returns false.
            if(small.charAt(i) != big.charAt(j)) {
                if(foundDifference) {
                    return false;
                }
                foundDifference = true;
                j++; //skip one char in the bigger string
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        OneAway oneAway = new OneAway();

        String a = "pale";
        String b = "ple";

        String c = "pale";
        String d = "bake";

        String e = "pale";
        String f = "leap";

        String g = "pales";
        String h = "pale";

        System.out.println("Is One Away String 1=" + a + " String 2=" + b + " " + oneAway.oneEditAway(a, b));
        System.out.println("Is One Away String 1=" + c + " String 2=" + d + " " + oneAway.oneEditAway(c, d));
        System.out.println("Is One Away String 1=" + e + " String 2=" + f + " " + oneAway.oneEditAway(e, f));
        System.out.println("Is One Away String 1=" + g + " String 2=" + h + " " + oneAway.oneEditAway(g, h));
    }
}
