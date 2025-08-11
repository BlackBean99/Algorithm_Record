package dfs;

import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int temp = storey % 10;
            int next = (storey / 10) % 10; // 다음 자리수
            
            if (temp > 5 || (temp == 5 && next >= 5)) {
                answer += (10 - temp);
                storey += (10 - temp);
            } else {
                answer += temp;
                storey -= temp;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
