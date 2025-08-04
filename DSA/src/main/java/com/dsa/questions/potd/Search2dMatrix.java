package com.dsa.questions.potd;

public class Search2dMatrix {
    // TC: O(log(rows*cols))
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols -1;

        while(left<=right){
            int mid = left + (right-left)/2;
            int val = matrix[mid/cols][mid%cols];

            if(val == target){
                return true;
            } else if (val < target) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;

    }
    public static void main(String [] args){
        int [][] matrix = new int [][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean ans = searchMatrix(matrix, target);
        System.out.println(ans);
    }
}
