#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

bool isOrdered(int data[], int n){
    int count = 0;
    for(int i =0;i<n-1;i++){
        // 하나씩 순회하면서 다음 index의 값이 이전 index보다 큰지 확인한다. ( 오름차순인지 확인한다. )
        if(data[i]>data[i+1]){
            count++;
            break;
        }
    }
    if(count>0)
        return false;
    else
        return true;
}

int main(){
    int n;
    int data;
    
    scanf("%d", &n);
    data = new int[n];

    // 데이터를 하나씩 입력받는다.
    for(int i =0;i<n;i++){
        scanf("%d",&data[i]);
    }
    
    scanf("%d",&m);

    int result = isOrdered(data, n);
    
    if(result){
        printf("YES");
    }
    else{
        printf("NO");
    }

    delete[] data;
    return 0;
}