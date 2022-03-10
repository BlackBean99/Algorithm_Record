#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;
#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

// 부분 최솟값의 인덱스를 반환하는 함수.
int getMinIndexInRange(int data[], int n, int begin, int end){
    int minIndex = begin;
    for(int i = begin; i< end; i++){
        if(data[i] < data[minIndex]){
            minIndex = i;
        }
    }
    return minIndex;
}


void selectionSort(int data[], int n){
    for(int i =0; i < n; i++){
        // 주어진 범위내에서  가장 작은 원소를 찾는다.
        int minIndex = getMinIndexInRange(data, n,i,n);
        int temp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = temp;
    }
      // 마지막 숫자는 자동으로 정렬되기 때문에 (숫자 개수-1) 만큼 반복한다.

}
int main(){
    int n;
    int* data;
    scanf("%d", &n);
    data = new int[n];

    for(int i = 0; i<n;i++){
        scanf("%d", &data[i]);
    }

    selectionSort(data, n);

    for(int i = 0; i < n; i++){
        if(i > 0){
            printf(" ");
        }
        printf("%d",data[i]);
    }

    delete[] data;
    return 0;
}