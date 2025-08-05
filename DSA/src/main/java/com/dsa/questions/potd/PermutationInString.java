package com.dsa.questions.potd;
// Day - 04/08/2025

public class PermutationInString { // TC = O(n*26) , SC = O(1)
    public static boolean isMapZero(int [] arr){
        for(int val: arr){
            if(val != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Freq = new int[26];

        for(char ch: s1.toCharArray()){
            s1Freq[ch-'a']--;
        }

        int l=0,r=0;
        while(r<s2.length()){
            s1Freq[s2.charAt(r) - 'a']++;

            if(r-l > s1.length()-1){
                s1Freq[s2.charAt(l) - 'a']--;
                l++;
            }

            if(r-l+1 == s1.length() && isMapZero(s1Freq)){
                return true;
            }
            r++;
        }
        return false;
    }
    public static void main(String []args){
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean ans = checkInclusion(s1,s1);
        System.out.println(ans);
    }
}
