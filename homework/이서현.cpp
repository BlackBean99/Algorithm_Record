#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

// mHn을 계산한다.
void Combi_Repitiion(int index,int cnt,int m, int n){

    // K-NM 개를 뽑았을 때 
	if(count == m){
		return;
	}
	// N개를 뽑기 위해 실행되는 부분 
	for(int i = start ; i < n ; i++){
		count++;
		Combi_Repetition(i, count+1, m, n);
	}
    cout << count << endl;
}

int main(){
    int n,m,k;
    
    // 데이터를 하나씩 입력받는다.
    scanf("%d %d %d", &n, &m, &k);

    // 초콜릿을 공평하게 m개씩 n명에게 일단 나눠주면 K-NM개가 남는다.
    // 남은 개수를 중복을 허용하여 n명에게 나눠주는 중복 조합의 문제이다.
    int result = Combi_Repitition(0, 0, n, k-n*m);
    
    return 0;
}