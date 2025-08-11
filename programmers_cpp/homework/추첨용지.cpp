#include <stdio.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <time.h>

using namespace std;

// 기울기를 이용하여 각 칸마다 몇칸을 차지하는지 계산해서 반환한다.
int answer(int ret,int start,int W, float inclination){
    // 종료 조건 : 마지막 W 번째 좌표를 탐색하고 나면 최종 값을 반환하고 종료한다.
    if(start == W){
        return ((inclination*start) - (inclination*(start-1)))+1;
    }
    int current_count = ((inclination*start) - (inclination*(start-1)))+1;
    // start+1로 인덱스를 올리면서 재귀호출한다.
    return ret + answer(current_count, start+1,W, inclination);
}

int main(){
    int W, H;
    int start,end;
    scanf("%d %d", &W, &H);
    int total_ret = H*W;
    // 실행시작 시간 측정
    start = clock();

    int ret = answer(0, 0, W, H/W);
    int result = total_ret - ret;
    printf("%d",result);

    // 실행 종료 시간 측정 
    end = clock();
    // 총 실행시간 계산
    int result = (end-start);
    printf("실행시간 : %d초",result);

    return 0;
}