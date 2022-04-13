#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>

using namespace std;


// 발열 측정을 기다리는 학생수 N, 발열 측정기의 수m, 
// 각 측정기가 한 명을 발열 측정하는데 걸리는 시간 Time
// 모든 사람이 발열 측정을 받는데 걸리는 시간의 최솟값을 구하는 프로그램

// 입력조건 첫번째줄 N, 두번째 줄 발열 측정기의수 m, 세번째 줄에 각 발열 측정기가 측정하는데 걸리는 Time 들이 주어진다.

// 출력조건 첫ㅂ너째 줄에 발열체크에 걸리는 시간의 최솟값을 출력한다.
// 두번째 줄에 입력받은 이후부터 점수 출력까지 걸린 실행시간을 초 단위로 출력한다.


int main(){
    // 실행시작 시간 측정
    int count = 0;
    int index=1;
    int start,end;
    int N,m;
 
    

    scanf("%d\n",&N);
    scanf("%d\n",&m);
    int tm[m];

    for(int i = 0; i< m;++i){
        scanf("%d",&tm[i]);
    }
    start = clock();

    // index를 하나씩 올리면서 체크한다.
    while(count == N){
        for(int i = 0; i < m; ++i){
            if(index % tm[i] == 0){
                count++;
                printf("%d\n",count);
            }
        }
        index++;
    }
    printf("최종결과%d\n",index);

    // 실행 종료 시간 측정 
    end = clock();
    // 총 실행시간 계산
    float result = (double)(end-start);
    printf("실행시간 : %f",result);
    return 0;
}
