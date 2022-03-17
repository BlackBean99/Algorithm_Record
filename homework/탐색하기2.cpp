#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

// AJOU 단어를 찾아서 처음 등장한 index 와 마지막에 등장한 index를 반환한다.
// 마지막에 등장한 index는 뒤쪽에 위치할 거란 가정하에 last 인덱스는 뒤부터 찾게 알고리즘을 작성했다.
int printIndexes(string school[], int n){
    int first = -1; //존재하지 않으면 -1
    int last = -1; //존재하지 않으면 -1

    for(int i = 0; i < n ; i++){
        if(school[i] == "AJOU"){
            first = i;
            break;
        }
    }
    for(int i = n-1; i > first; i--){
        if(school[i] == "AJOU") last = i;
    }
    printf("%d %d \n", first, last);
}

int main(){
    int n;
    char buff[11];
    string* school;

    scanf("%d",&n);
    school = new string[n];

    for(int i = 0; i < n; i++){
        scanf("%s", buff);
        school[i] = buff;
    }
    printIndexes(school, n);

    delete[] school;
    return 0;
}