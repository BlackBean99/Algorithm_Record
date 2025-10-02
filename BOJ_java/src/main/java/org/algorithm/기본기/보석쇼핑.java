import java.util.*;
class Solution {
public int[] solution(String[] gems) {
    Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems));
    int totalTypes = uniqueGems.size();
    
    Map<String, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    int minLen = Integer.MAX_VALUE;
    int[] answer = new int[2];
    
    int left = 0, right = 0;
    int minLen = Integer.MAX_VALUE;
    int[] answer = new int[2];
    
    while(right < gems.length) {
        // 윈도우 확장
        window.put(gems[right], window.getOrDefault(gems[right], 0) + 1);
        while(window() == totalTypes) {
            if(right - left + 1 < minLen){
                minLen = right - left + 1;
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
            
            window.put(gems[left], window.get(gems[left]) -1);
            if(window.get(gems[left]) == 0){
                window.remove(gems[left]);
            }
            left++;
        }
        right++;
        // 윈도우 축소
    }
    
    while(right < gems.length) {
        // 윈도우 확장
        window.put(gems[right], window.getOrDefault(gems[right], 0) + 1);
        
        // 윈도우 축소 (모든 보석을 포함하면서 최소화)
        while(window.size() == totalTypes) {
            if(right - left + 1 < minLen) {
                minLen = right - left + 1;
                answer[0] = left + 1;  // 1-based index
                answer[1] = right + 1;
            }
            
            window.put(gems[left], window.get(gems[left]) - 1);
            if(window.get(gems[left]) == 0) {
                window.remove(gems[left]);
            }
            left++;
        }
        right++;
    }
    
    return answer;
    }
}