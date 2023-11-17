package 순위검색;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String[] info1 = new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query1 = new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] answer1 = new int[]{1, 1, 1, 1, 2, 4};
        int[] result1 = new Solution().solution(info1, query1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Person> conditions = new LinkedList<>();
        for (String condition : query) {
            String[] con = condition.split(" and ");
            String lang = con[0];
            String job = con[1];
            String career = con[2];
            String[] lastCondition = con[3].split(" ");
            String food = lastCondition[0];
            int score;
            if(lastCondition[1].equals("-")) {
                score = -1;
            } else {
                score = Integer.parseInt(lastCondition[1]);
            }
            conditions.add(new Person(lang, job, career, food, score));
        }

        List<Person> peoples = new LinkedList<>();

        for(String a : info) {
            String[] apply = a.split(" ");
            String lang = apply[0];
            String job = apply[1];
            String career = apply[2];
            String food = apply[3];
            Integer score = Integer.parseInt(apply[4]);
            peoples.add(new Person(lang, job, career, food, score));
        }

        List<Integer> tempAnswer = new LinkedList<>();
        for (Person condition : conditions) {
            int successCount = 0;
            for(Person people: peoples){
                if(condition.lang.equals("-") || condition.lang.equals(people.lang)) {
                    if(condition.job.equals("-") || condition.job.equals(people.job)) {
                        if(condition.career.equals("-") || condition.career.equals(people.career)) {
                            if(condition.food.equals("-") || condition.food.equals(people.food)) {
                                if(condition.score == -1 || condition.score <= people.score) {
                                    successCount++;
                                }
                            }
                        }
                    }
                }
            }
            tempAnswer.add(successCount);
        }
        for (int i = 0; i < query.length; i++) {
            answer[i] = tempAnswer.get(i);
        }
        return answer;
    }
    class Person {
        String lang;
        String job;
        String career;
        String food;
        Integer score;
        public Person(String lang, String job, String career, String food, Integer score) {
            this.lang = lang;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }
}