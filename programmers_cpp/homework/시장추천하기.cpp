/**
    입력
    입력받을 문자열 수 N
    입력받을 문자 N개
5
DO
DO
HI
HI
BYE
    출력
최다 득표자 수 표수
최다 득표수 오름차순 이름.
2
DO HI


*/

#include <iostream>
#include <stdio.h>
#include <map>

using namespace std;


int main(){
    map<string, int> m;
    // map을 순회하기 위한 Iterator을 선언
    map<string,int>::iterator it;

    int n;
    cin >> n;

    int maxFrequency = 0;

    for(int i = 0 ; i < n; i++){
        string str;
        cin >> str;
        m[str]++;
        int k = m[str];
        if(k>maxFrequency){
            maxFrequency = k;
        }
    }

    for(it=m.begin();it != m.end(); it++){
        if(it->second == maxFrequency)
            cout << it->first.c_str();
    }
    
    return 0;
}