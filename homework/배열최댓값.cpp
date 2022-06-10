#include <stdio.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <time.h>

using namespace std;

int get_max(int N,int arr[]){
    int ret = 0;
    for(int i = 0 ; i < N-1; ++i){
        if(arr[i] < arr[i+1]){
            ret = arr[i+1];
        }
    }
    return ret;
}

// 배열의 최댓값 구하기
int main(){
    int N;
    cin >> N;
    int arr[N];
    int ret;

    for( int n = 0; n < N; n++){
        int tmp;
        cin >> tmp;
        arr[n] = tmp;
    }

    ret = get_max(N, arr);
    cout << ret;
    return 0;
}