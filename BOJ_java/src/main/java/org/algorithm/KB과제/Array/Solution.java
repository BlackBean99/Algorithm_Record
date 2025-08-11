package org.algorithm.KB과제.Array;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println(s.solution(queue1, queue2));
    }
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        int cnt = 0;
        int sum1 = 0;
        int sum2 = 0;
        
        int maxLength = queue1.length * 2;
        Queue<Integer> stack1 = new LinkedList<>();
        Queue<Integer> stack2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i ++){
            stack1.add(queue1[i]);
            sum1+=queue1[i];
            stack2.add(queue2[i]);
            sum2+=queue2[i];
        }
        while(sum1 != sum2){
            cnt++;
            if(cnt >= maxLength) {
                return -1;
            }
            if(sum1 > sum2){
                int temp = stack1.poll();
                stack2.add(temp);
                sum1 -= temp;
                sum2 += temp;
                System.out.println("temp1 : " + temp + " : " + cnt);
            } else if (sum1 < sum2){
                int temp = stack2.poll();
                stack1.add(temp);
                sum2 -= temp;
                sum1 += temp;
                System.out.println("temp2 : " + temp + " : " + cnt);

            } else {
                return cnt;
            }
        }
        return cnt == 0 ? -1 : cnt;
    }
}