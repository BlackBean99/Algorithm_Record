import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = normalize(m);

        int maxPlay = -1;

        for (String info : musicinfos) {
            String[] arr = info.split(",");
            int playTime = convertTime(arr[1]) - convertTime(arr[0]);
            String title = arr[2];
            String melody = normalize(arr[3]);

            // 실제 재생된 멜로디 만들기
            StringBuilder played = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                played.append(melody.charAt(i % melody.length()));
            }

            // 멜로디 포함 여부 확인
            // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            if (played.toString().contains(m)) {
                if (playTime > maxPlay) {
                    maxPlay = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }

    private int convertTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    // # 포함 음을 한 글자로 치환
    private String normalize(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
}
