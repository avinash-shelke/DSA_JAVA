package com.dsa.questions.potd;
// Day - 02/08/25
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int[n];

        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=i+1; j<n;j++){
                if(temperatures[i] < temperatures[j]) {
                    ans[i] = cnt+1;
                    break;
                }
                else{
                    cnt++;
                }
            }
        }

        return ans;
    }

    public static int[] dailyTemperatureMonotonicStack(int [] temperatures){
        int n = temperatures.length;
        int [] ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stk.empty() && temperatures[i] > temperatures[stk.peek()]){
                Integer index = stk.pop();
                ans[index] = i - index;
            }
            stk.push(i);
        }

        return ans;
    }

    public static void main(String [] args){
        int [] temp = {73,74,75,71,69,72,76,73};
        int [] ans = dailyTemperaturesBruteForce(temp);
        int [] monotonicArr = dailyTemperatureMonotonicStack(temp);
        System.out.println(Arrays.toString(monotonicArr));
    }
}
