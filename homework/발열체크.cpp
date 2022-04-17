#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>
#include<vector>

using namespace std;

bool checkMatching(string target, string word, int tp, int wp) {
     // tp: 현재 target의 몇번째 문자를 검사
    // wp: 현재 word의 몇번째 문자를 검사
    while (tp<target.size()&&wp<word.size()&&(target[tp]=='*'||target[tp]==word[wp])) {
        // *일 때
        // 문자가 서로 같을 때
        // 아직 target과 word 둘 다 끝까지 안봤을 때
        tp++; wp++;
    }
    if (tp == target.size())
        return wp == word.size();
    return false;
}


int main(){
    int N,m;
    int count = 0;
    int start,end;
    
    // 이용자 수 N , 이용자 ID인 id 데이터를 입력을 받는다.
    scanf("%d\n",&N);
    string id[N];
    for(int i = 0; i< N;i++){
        cin >> id[i];
    }
    // 제재 대상자 수 m , 제재 대상자 ID인 k 데이터를 입력을 받는다.
    scanf("%d\n",&m);
    vector<string> k;
    for(int i = 0; i< m;i++){
        cin >> k[i];
    }
    // 가능한 모든 경우의 단어를 담은 2차원 벡터
    vector<vector<string>> ret;
    // 각 단어에 매칭되는 여러 단어를 담은 1차원 벡터
    vector<string> ret_vector;

    // 실행시작 시간 측정
    start = clock();

    // M개의 문자열을 하나씩 선택해서
    for(int i=0; i < m ; i++){
        // N개의 문자열중 매칭되는 ID를 검색해서 vector에 담는다.
        for(int j = 0 ; j < N;j++){
            if (checkMatching(k[i], id[j], 0, 0)) // 매칭되면
                ret_vector.push_back(id[j]);
        }
        ret.push_back(ret_vector);
    }

    // 카운트 세기
    int cnt_tmp = 1;

    for(int i=0; i < m-1 ; i++){
        if(ret[i].size() == ret[i+1].size()){
            for(int j = 0 ; j < ret[j].size();j++){
                for(int k = 0 ; k < ret[j].size();k++){
                    if(ret[j][k] == ret[j][k+1]){
                        continue;
                    }
                    else{
                        count++;
                        }
                }
            }
        }
        else{
            cnt_tmp *= count;
            continue;
        }
    }
    printf("%d", count);


    // 실행 종료 시간 측정 
    end = clock();
    // 총 실행시간 계산
    int result = (end-start);
    printf("실행시간 : %d",result);
    return 0;
}