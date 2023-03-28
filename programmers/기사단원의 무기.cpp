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
            // i 가 약수일 때
            if(num % i == 0) {
                //share : 약수
                int share = (int)(num / i);
                // share가 제곱근 약수일 때
                if((share*share) == num) {
                    count += 1;
                    cout << i << endl;
                }
                else {
                    count += 2;
                    cout << i << endl;
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
