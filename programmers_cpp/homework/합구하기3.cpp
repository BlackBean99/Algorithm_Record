#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;
#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

/**
// 1부터 인덱스 i 까지의 부분합을 구하는 함수
int getRangeSumFromOne(int i){
    int sum = 0;
    for(int j =1; j < i+1; j++){
        sum += j;
    }
    return sum;
}

// 부분합 함수를 1부터 n까지 호출
// 각 반환 값을 totalSum 에 누적합 하고 반환한다.
long long getAnswer(int n){
    int totalSum = 0;
    for(int i =1; i < n+1; i++){
        totalSum += getRangeSumFromOne(i);
    }
    return totalSum;
}

*/
int getReculsiveSum(int n){
    if(n==1){
        return 1;
    }else{
        return n += getReculsiveSum(n-1);
    }
}

int getAnswer(int end){
    int sum = 0;
    
    for(int i = 1 ; i < end+1; i++){
        sum += getReculsiveSum(i);
    }
    return sum;
}
int main(){
    int n;
    scanf("%d", &n);
    int answer = getAnswer(n);
    printf("%lld\n",answer);
    return 0;
}