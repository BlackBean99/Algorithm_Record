package 타겟넘버;

class Solution {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{1, 1, 1, 1, 1};
        int target1 = 3;
        int answer1 = 5;
        int result1 = new Solution().solution(numbers1, target1);
        PRINT_RESULT(1, result1, answer1);

        int[] numbers2 = new int[]{4, 1, 2, 1};
        int target2 = 4;
        int answer2 = 2;
        int result2 = new Solution().solution(numbers2, target2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    static boolean[] visited;
    static int count = 0;
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
//        주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
//        각 숫자는 1 이상 50 이하인 자연수입니다.
//        타겟 넘버는 1 이상 1000 이하인 자연수입니다.
        dfs(numbers,0, target,0);
        // 4,1,2,1
        // 4
//        answer = 2
        //

        return count;
    }
    public void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){ //마지막 노드까지 진행했을 때
            if (target == result){ //target값과 합계가 같다면
                count++;
            }
            return;
        }

        int plus = result + numbers[depth]; //양수를 더한 값
        int minus = result - numbers[depth]; //음수를 더한 값

        dfs(numbers, depth+1, target, plus);
        dfs(numbers, depth+1, target, minus);

    }
}