package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Time and Space - O(n^2)
 */
public class PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) {
            return new ArrayList();
        }

        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        rows.add(rowOne);

        if(rowIndex == 0) {
            return rowOne;
        }

        for(int rowNum = 1; rowNum <= rowIndex; rowNum++) {
            List<Integer> prevRow = rows.get(rowNum - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j = 1; j < prevRow.size(); j++) {
                row.add(prevRow.get(j) + prevRow.get(j-1));
            }

            row.add(1);
            rows.add(row);
        }
        return rows.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println("Result row 3 = " + getRow(3));
    }
}
