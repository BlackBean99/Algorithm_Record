import java.util.*;
class Solution {
public int[] solution(String[] gems) {
    // 1. 전체 개수를 평가해야해
    int count =(int)Arrays.stream(gems).distinct().count();
    Map<String, Integer> map = new HashMap<>();
    int left = 0, right = 0;
    int[] answer = new int[2];
    int minLen = Integer.MAX_VALUE;
    //확장
    while(right < gems.length){
        map.put(gems[right], map.getOrDefault(gems[right],0) + 1);
        // 축소
        while(count == map.size()){
            if(right - left + 1  < minLen){
                answer[0] = left + 1;
                answer[1] = right + 1;
                minLen = right - left + 1;
            }
            map.put(gems[left], map.get(gems[left]) - 1);
            if(map.get(gems[left]) == 0) map.remove(gems[left]);
            
            left++;
        }
        right++;        
    }
    return answer;
    }
}