#include<set>
#include<vector>
#include<iostream>
#include<stdlib.h>
#include<stdio.h>

using namespace std;

// @param s : 중복되면 안되는 데이터를 저장한 set
set<int> getPresetData(){
    set<int> s;
    s.insert(13);
    s.insert(31);
    s.insert(17);
    s.insert(71);
    s.insert(39);
    s.insert(93);
    s.insert(912);
    s.insert(129);
    s.insert(46);
    s.insert(64);
    s.insert(28);
    s.insert(82);
    s.insert(112);
    s.insert(121);
    s.insert(37);
    s.insert(73);
    return s;
}

// 2개의 숫자를 이어서 하나의 숫자로 만든다.
int integrity_data(int a, int b){
    string data = to_string(a) + to_string(b);
    return stoi(data);
}

// 패턴이 가능한 패턴인지 확인한다.
void process(vector<int> input){
    set<int> answer = getPresetData();
    for(int i=0;i<input.size()-1;i++){
        int a = integrity_data(input[i],input[i+1]);
        // 중복 답변과 일치하는지 Set을 이용하여 확인
        if(answer.count(a) > 0){
            printf("NO");
            return;
        }
    }
    printf("YES");
}

/**
@param N : 비밀번호의 길이
@param password : 
*/
int main(){
    // Input
    int caseSize;
    int x;

    vector<int> password;
    
    // N데이터 삽입
    scanf("%d",&caseSize);
    // 비밀번호 경로 데이터 입력받기
    for(int caseIndex = 0; caseIndex < caseSize; caseIndex++){
        cin >> x;
        password.push_back(x);
    }
    process(password);
    return 0;
}