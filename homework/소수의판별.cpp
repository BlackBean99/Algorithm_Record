#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

bool isPrime(int N){
    int cnt = 0;
    for(int i = 2 ; i*i < N; i++){
        if(N % i == 0){
            cnt++;
        }
        if(cnt > 2){
            return false;
        }
    }
    if(cnt == 2){
        return true;
    }
    return false;

}

void testcase(int caseIndex){
    int n;
    scanf("%d",&n);

    bool result = isPrime(n);

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
    for(int caseIndex =1;caseIndex<caseSize+1;caseIndex+=1){
        testcase(caseIndex);    
    }

    return 0;
}