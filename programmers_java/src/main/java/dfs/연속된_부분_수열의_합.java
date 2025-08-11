package dfs;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (end < sequence.length) {
            // sum이 k보다 작거나 같을 때까지 end를 이동하며 sum에 더해줌
            while (end < sequence.length && sum < k) {
                sum += sequence[end++];
            }

            // sum이 k와 같을 때
            while (sum >= k) {
                if (sum == k) {
                    // 현재 부분 수열의 길이
                    int length = end - start;
                    // 가장 짧은 길이를 가진 부분 수열을 갱신
                    if (length < minLength) {
                        minLength = length;
                        answer[0] = start;
                        answer[1] = end - 1;
                    }
                }
                // sum이 k보다 크거나 같을 때 start를 이동하며 sum에서 빼줌
                sum -= sequence[start++];
            }
        }

        return answer;
    }
}
