#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

bool isPrime(int N){
    // 약수가 2개인지 확인
    if(N==1) return flase;
    // 반복하면서 약수 카운트
    int cnt=0;
    for(int i=2;i*i<n;i++){
        if(N % i ==0)
            cnt++;
        if(cnt >= 3)
            break;
    }
    if(cnt==2) return true;
    return false;
}

void testcase(int caseIndex){
    int n;
    scanf("%d".&n);

    bool result = iaPrime(n);

    printf("Case %d\n",caseIndex);
    if(result){
        printf("YES\n");
    }
    else{
        printf("NO\n");
    }
}
int main(){
    int caseSize;
    
    scanf("%d", &caseSize);
    // 데이터를 하나씩 입력받는다.
    for(int caseIndex =1;caseIndex<caseSize;caseIndex+=1){
        testcase(caseIndex);    
    }

    return 0;
}