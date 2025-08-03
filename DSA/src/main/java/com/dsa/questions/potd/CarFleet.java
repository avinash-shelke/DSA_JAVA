package com.dsa.questions.potd;

import java.util.*;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [][] cars = new double[n][2];
        for(int i=0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target-position[i]) / speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        int fleets=0;
        double currTime=0;

        for(int i=0;i<n;i++){
            double time = cars[i][1];
            if(time>currTime){
                fleets++;
                currTime = time;
            }
            //else,car join the current fleet
        }
        return fleets;
    }

    public static void main(String [] args){
        int target = 12;
        int [] position = new int[]{10,8,0,5,3};
        int [] speed  = new int[]{2,4,1,1,3};
        int ans = carFleet(target, position, speed);
        System.out.println(ans);
    }
}
