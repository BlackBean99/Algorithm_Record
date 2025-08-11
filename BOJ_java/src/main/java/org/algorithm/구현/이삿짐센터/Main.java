package org.algorithm.구현.이삿짐센터;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buckets = new int[5];
        for (int i = 0; i < 5; i++) {
            buckets[i] = Integer.parseInt(st.nextToken());
        }
        int answer = buckets[4];

        // 1키로 4키로 조합 집어넣기
        buckets[0] -= buckets[3];
        answer += buckets[3];

        // 2키로 3키로 조합 집어넣기
        int temp = Math.min(buckets[1], buckets[2]);
        answer += temp;
        buckets[2] -= temp;
        buckets[1] -= temp;
        // 2키로가 남는 경우 - 1키로와 2키로로 조합해야함 ( 2,1,1,1 ) ( 2,2,1 )
        if (buckets[1] > 0) {
            while (buckets[1] > 0) {
                if (buckets[1] >= 2) {
                    buckets[1] -= 2;
                    buckets[0] -= 1;
                    answer++;
                } else {
                    if (buckets[1] == 1) {
                        buckets[1] -= 1;
                        buckets[0] -= 3;
                        answer++;
                    }
                }
            }
        }
        if (buckets[2] > 0) {
            answer += buckets[2];
            buckets[0] -= buckets[2] * 2;
        }
        // 1키로만 남은 경우
        if (buckets[0] > 0) {
            if (buckets[0] % 5 > 0) {
                answer += (buckets[0] / 5 + 1);
            } else {
                answer += buckets[0] / 5;
            }
        }
        System.out.println(answer);
    }
}
