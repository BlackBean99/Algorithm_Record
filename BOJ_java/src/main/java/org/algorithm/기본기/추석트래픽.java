import java.util.*;

class Solution {
    // 결과 코드
    
    public static int getRequestCountDuringOneSecond(double time, List<double[]> startAndEndTimes) {
        int requestCount = 0;
        double start = time;
        double end = time + 1000;
        for (double[] startAndEndTime : startAndEndTimes) {
            if (startAndEndTime[1] >= start && startAndEndTime[0] < end) {
                requestCount += 1;
            }
        }
        return requestCount;
    }
    
    
    public static int solution(String[] lines) {
        int answer = 0;
        List<double[]> startAndEndTimes = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            String time = parts[1];
            String duration = parts[2];
            
            String[] timeParts = time.split(":");
            double durationMs = Double.parseDouble(duration.replace("s", "")) * 1000;
            double end = (Integer.parseInt(timeParts[0]) * 3600 + Integer.parseInt(timeParts[1]) * 60 + Double.parseDouble(timeParts[2])) * 1000;
            double start = end - durationMs + 1;
            startAndEndTimes.add(new double[]{start, end});
        }
        
        for (double[] startAndEndTime : startAndEndTimes) {
            answer = Math.max(answer, Math.max(
                getRequestCountDuringOneSecond(startAndEndTime[0], startAndEndTimes),
                getRequestCountDuringOneSecond(startAndEndTime[1], startAndEndTimes)
            ));
        }
        return answer;
    }
    
    public static void main(String[] args) {
        // 테스트 케이스
        String[] lines1 = {
            "2016-09-15 01:00:04.001 2.0s",
            "2016-09-15 01:00:07.000 2s"
        };
        System.out.println("Result: " + solution(lines1)); // Expected: 1
        
        String[] lines2 = {
            "2016-09-15 01:00:04.002 2.0s",
            "2016-09-15 01:00:07.000 2s"
        };
        System.out.println("Result: " + solution(lines2)); // Expected: 2
        
        String[] lines3 = {
            "2016-09-15 20:59:57.421 0.351s",
            "2016-09-15 20:59:58.233 1.181s",
            "2016-09-15 20:59:58.299 0.8s",
            "2016-09-15 20:59:58.688 1.041s",
            "2016-09-15 20:59:59.591 1.412s",
            "2016-09-15 21:00:00.464 1.466s",
            "2016-09-15 21:00:00.741 1.581s",
            "2016-09-15 21:00:00.748 2.31s",
            "2016-09-15 21:00:00.966 0.381s",
            "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println("Result: " + solution(lines3)); // Expected: 7
    }
}