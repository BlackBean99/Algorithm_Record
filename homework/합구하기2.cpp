#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

// 몸무게 p kg 이상은 탑승할 수 없다.
// 탑승한 승객의 몸무게는 총 Q kg 을 넘을 수 없다.
// 탑승인 인원의 제한은 없다.

// 첫줄에 세 자연수 N,P,Q가 주어진다.
// 동아리 회원수 N, 탑승 제한 하중 P, 놀이기구 최대 하중 Q


void solve(int data[], int n, int p, int q){
    // 누적 몸무게 변수 추가
    int sumWeight = 0;
    int count = 0;
    for(int i=0;i<n;i++){
        if(data[i] < p){
            count++;
            sumWeight += data[i];
            if(sumWeight > q){
                printf("NO");
                return;
            }
        }
    }
    printf("%d %d \n",count, sumWeight);
    printf("YES");
    return;
}

int main(){
    int n,p,q;
    int *data;

    scanf("%d %d %d", &n, &p, &q);
    data = new int[n];

    // 승객의 몸무게 데이터를 반복하여 입력받기
    for(int i = 0; i < n; i++){
        scanf("%d",&data[i]);
    }

    solve(data, n, p ,q);

    delete[] data;
    return 0;
}
