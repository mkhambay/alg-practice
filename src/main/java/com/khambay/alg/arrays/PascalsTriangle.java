package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Time and Space - O(n^2)
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0) {
            return triangle;
        }

        //Row 0
        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        triangle.add(rowOne);

        for(int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            //first element
            row.add(1);

            for(int j = 1; j < prevRow.size(); j++) { //will not enter here for row 1
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            //last element
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(5);

        for(List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
