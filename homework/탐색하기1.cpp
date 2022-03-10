#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

// N개의 정수로 이루어진 배열과 찾고자 하는 값 M 이 주어진다. M이 존재하는 인덱스를 출력하는 프로그램을 작성하시오.
int findIndex(int data[], int n, int m){
    // 순회하면서 찾는 m 과 비교연산을 실시 후 값을 찾으면 인덱스를 반환한다.
    for(int i = 0 ; i < n; i++){
        if(data[i] == m)
            return i;
    }
}

int main(){
    int n,m;
    int *data;
    
    scanf("%d %d", &n, &m);
    data = new int[n];
    for(int i =0;i<n;i++){
        scanf("%d",&data[i]);
    }
    int answer = findIndex(data,n,m);
    printf("%d\n", answer);
    delete[] data;
    return 0;
}