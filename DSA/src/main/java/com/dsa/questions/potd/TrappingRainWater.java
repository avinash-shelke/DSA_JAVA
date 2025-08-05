package com.dsa.questions.potd;
// Day - 04/08/25

public class TrappingRainWater { //TC=O(n) , SC=O(n)

    public enum AffixType {
        PREFIX,
        SUFFIX
    }

    public static int[] calculateMax(int[] height, AffixType traverse) {
        int n = height.length;
        int[] arr = new int[n];
        switch (traverse) {
            case PREFIX -> {
                int max = -1;
                for (int i = 0; i < n; i++) {
                    if (height[i] > max) {
                        arr[i] = height[i];
                        max = height[i];
                    } else {
                        arr[i] = max;
                    }
                }
                return arr;
            }
            case SUFFIX -> {
                int max = -1;
                for (int i = n - 1; i >= 0; i--) {
                    if (height[i] > max) {
                        arr[i] = height[i];
                        max = height[i];
                    } else {
                        arr[i] = max;
                    }
                }
                return arr;
            }
        }
        return null;
    }

    public static int trap(int[] height) {

        int[] prefixMax = calculateMax(height, AffixType.PREFIX);
        int[] suffixMax = calculateMax(height, AffixType.SUFFIX);

        int n = height.length;
        int ans=0;
        for (int i = 1; i < n - 1; i++) {
            int mini = StrictMath.min(prefixMax[i], suffixMax[i]);
            ans += (mini - height[i]);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = trap(height);
        System.out.println(ans);
    }
}
