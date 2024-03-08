#include<stdio.h>
#include<string>
#include<iostream>

void swap(int a, int b){
    int temp=0;
    temp = a;
    a = b;
    b= temp;
}

// 오름차순으로 정렬.
void bubbleSort(int data[],int N){
    for(int i=0;i<n;i++){
        for(int j = i;j<n;j++){
            if(data[i] > data[j])
                swap(data[i],data[j]);
        }
    }
}

}
int main(){
    int n;
    int* data;
    
    // 데이터를 입력받는다.
    scanf("%d", &n);

    for(int i= 0; i < n ; i++){
        scanf("%d", &data[i]);    
    }


    return 0;
}