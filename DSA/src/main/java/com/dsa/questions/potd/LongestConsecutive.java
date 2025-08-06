package com.dsa.questions.potd;

import java.util.*;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) { // TC = O(n) , SC = O(n)
        Set<Integer> shet = new HashSet<>();
        Arrays.stream(nums).forEach((num)->{
            shet.add(num);
        });
        int cnt=0;
        for(int element: shet){
            if(!shet.contains(element-1)){
                int currNum = element;
                int currStreak = 1;

                while(shet.contains(currNum+1)){
                    currNum++;
                    currStreak++;
                }

                cnt = Math.max(cnt, currStreak);
            }
        }
        return cnt;
    }

    public static void main(String [] args){
        int [] nums = new int[]{100,4,200,1,3,2};
        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }
}
