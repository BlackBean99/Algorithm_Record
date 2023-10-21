package 점찍기;

class Solution {
    public static void main(String[] args) {
        int k1 = 2;
        int d1 = 4;
        long answer1 = 6L;
        long result1 = new Solution().solution(k1, d1);
        PRINT_RESULT(1, result1, answer1);

        int k2 = 1;
        int d2 = 5;
        long answer2 = 26L;
        long result2 = new Solution().solution(k2, d2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, long result, long answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public long solution(int k, int d) {
//        0,0부터
        long answer = 0;
//          k * d(i = 0 ; i <d; i*k < d)

//         1,5
//         0,1(0 + 1*1),2(0 + 1*2),3(0+1*3),4(0 + 1*4),5(0 + 1*5)
//         0,1(0 + 1*1),2(0 + 1*2),3(0+1*3),4(0 + 1*4),5(0 + 1*5)
//         d <
        int startX = 0;
        int startY = 0;
        for (int i = 0; i <= d / k; i++) {
            for (int j = 0; j <= d / k; j++) {
                int endX = startX + i * k;
                int endY = startY + j * k;
                if (Math.sqrt(endX * endX + endY * endY) <= d) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}