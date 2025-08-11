/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>

using namespace std;

// mHn을 계산한다.
int Combi_Repitition(int index,int cnt,int n, int m, int ref){
//     // K-NM 개를 뽑았을 때 
	if(cnt == m){
		return ref;
	}
	// N개를 뽑기 위해 실행되는 부분
	for(int i = 0 ; i < n ; i++){
		Combi_Repitition(i, ++cnt, n, m, ++ref);
	}
    return ref;
}

int main(){
    int n,m,k;
    // 실행시작 시간 측정
    start = clock();
    // 데이터를 하나씩 입력받는다.
    scanf("%d %d %d", &n, &m, &k);

    // 초콜릿을 공평하게 m개씩 n명에게 일단 나눠주면 K-NM개가 남는다.
    // 남은 개수를 중복을 허용하여 n명에게 나눠주는 중복 조합의 문제이다.
    int result = Combi_Repitition(0, 0, n, k-n*m, 0);
    
    printf("%d", result);

    // 실행 종료 시간 측정 
    end = clock();
    // 총 실행시간 계산
    result = (double)(end-start);
    printf("실행시간 : %f",result);
    return 0;
}
