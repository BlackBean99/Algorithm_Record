package 오픈채팅방;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] record1 = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] answer1 = new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String[] result1 = new Solution().solution(record1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, String[] result, String[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String[] solution(String[] record) {
        List<Document> documents = new LinkedList<>();
        Map<String, String> userIdMap = new HashMap<>();

        for (String sentence : record) {
            String[] splitSentence = sentence.split(" ");
            if (splitSentence[0].equals("Enter") || splitSentence[0].equals("Change")) {
                userIdMap.put(splitSentence[1], splitSentence[2]);
            }
        }

        for (String sentence : record) {
            String[] split = sentence.split(" ");
            if (split[0].equals("Enter")) {
                String chat = userIdMap.get(split[1]) + "님이 들어왔습니다.";
                documents.add(new Document(split[1], chat));
            }
            else if (split[0].equals("Leave")) {
                String chat = userIdMap.get(split[1]) + "님이 나갔습니다.";
                documents.add(new Document(split[1], chat));
            }
        }
        return documents.stream().map(Document::getSentence).toArray(String[]::new);
    }
    public static class Document{
        String uid;
        String sentence;

        public Document(String uid, String sentence) {
            this.uid = uid;
            this.sentence = sentence;
        }
        public String getSentence() {
            return this.sentence;
        }
    }
}