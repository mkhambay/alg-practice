package com.khambay.alg.strings;

public class OneAway {

    boolean oneEditAway(String first, String second) {
        if(first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        else if(first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        }
        else if(first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
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

    boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while(index2 < s2.length() && index1 < s1.length()) {

            //checks for only 1 difference and moves only pointer index2++ Line 45. If the rest of the string does
            //not match remaining index1, it returns false.
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if(index1 != index2) {
                    return false;
                }
                index2++;
            }
            else {
                index1++;
                index2++;
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
