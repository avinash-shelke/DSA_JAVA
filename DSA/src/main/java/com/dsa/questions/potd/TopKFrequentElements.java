package com.dsa.questions.potd;
// Day - 01/08/25

import java.util.*;

public class TopKFrequentElements {
    private record Pair(int first, int second) implements Comparable<Pair>{
        @Override
        public int compareTo(Pair o){
            return Integer.compare(o.first,this.first);
        }
    }

    public static int[] topKFrequent(int[] nums, int k){

        HashMap<Integer, Integer> mp = new HashMap<>();
        Arrays.stream(nums).forEach((num)->{
            Integer earlierFreq = mp.getOrDefault(num, 0);
            mp.put(num, earlierFreq+1);
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        mp.forEach((key,value)->{
            pq.add(new Pair(value, key));
        });

        int [] ans = new int[k];
        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            ans[i] = p.second;
        }

        return ans;
    }

    public static void main(String [] args){
        int [] nums={1,1,1,2,2,3};
        int k=2;
        int [] ans = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
