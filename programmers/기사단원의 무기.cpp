#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int number, int limit, int power) {
    int answer = 0;

    for(int num = 1; num <= number; num++) {
        // number별 약수 개수 구하기
        int count = 0;
        for(int i = 1; (i*i) <= num; i++) {
            if(num % i == 0) {
                int share = (int)(num / i);
                if((share*share) == num) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }

        // 약수 개수가 limit 넘는지 비교
        if(count > limit) {
            answer += power;
        } else {
            answer += count;
        }
    }

    return answer;
}
