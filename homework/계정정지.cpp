#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>
#include<vector>
#include<algorithm>


using namespace std;

vector<vector<int>> answer;

// 중복이 되는지 확인하는 함수.
bool checkMatching(string target, string word, int tp, int wp) {
     // tp: 현재 target의 몇번째 문자를 검사
    // wp: 현재 word의 몇번째 문자를 검사
    while (tp<target.size() && wp<word.size() && (target[tp]=='*' || target[tp]==word[wp])) {
        // *일 때
        // 문자가 서로 같을 때
        // 아직 target과 word 둘 다 끝까지 안봤을 때
        tp++; wp++;
    }
    if (tp == target.size())
        return wp == word.size();
    return false;
}

//  두 벡터를 비교하는 함수.
bool check_overlap(vector<int> compare_arr){
    for(int i = 0 ; i < answer.size(); i++){
        bool same = true;
        for(int j=0; j < answer[i].size(); j++){
            if(answer[i][j] != compare_arr[j]){
                same = false;
            }
        }
        if(same) {
            return true;
        }
    }
    return false;    
}

// 벡터의 모든 단어와 한 단어를 중복을 확인하는 함수
bool cur_overlap(vector<int> compare_arr, int tmp) {
    for(int k = 0; k < compare_arr.size(); k++) {
        if (compare_arr[k] == tmp) return true;
    }
    return false;
}


int count_answer(vector<vector<int>> ret, vector<int> compare_arr, int start){
    // 기저 사례
    // 1. 기존의 답과 중복되면 안된다.anse
    // 2. 답은 크기가 m일때이다.
    if(compare_arr.size() == ret.size()){
        // 비교할 값을 정렬한다.
        sort(compare_arr.begin(),compare_arr.end());
        if(check_overlap(compare_arr)){
            return 0;
        }
        answer.push_back(compare_arr);
        return 1;
    }
    int result = 0;

    for(int i = start; i < ret.size();i++){
        start += 1;
        for(int j = 0; j < ret[i].size(); j++){
            if(cur_overlap(compare_arr, ret[i][j])) continue;
            compare_arr.push_back(ret[i][j]);
            result += count_answer(ret, compare_arr, start);
            // 경우의 수가 하나 증가했을 경우 그 원소를 빼고 다시 순회한다.
            compare_arr.pop_back();
        }
    }
    return result;
}

int main(){
    int N,m;
    int count = 0;
    int start, end;
    
    // 이용자 수 N , 이용자 ID인 id 데이터를 입력을 받는다.
    scanf("%d\n",&N);
    
    vector<string> id;
    string tmp;
    for(int i = 0; i< N;i++){
        cin >> tmp;
        id.push_back(tmp);
    }
    
   // 제재 대상자 수 m , 제재 대상자 ID인 k 데이터를 입력을 받는다.
    scanf("%d\n",&m);

    vector<string> k;
    for(int i = 0; i< m;i++){
        cin >> tmp;
        k.push_back(tmp);
    }

    // 가능한 모든 경우의 단어를 담은 2차원 벡터
    vector<vector<int>> ret;
    // 각 단어에 매칭되는 여러 단어를 담은 1차원 벡터
    vector<int> ret_vector;

    // 실행시작 시간 측정
    start = clock();

    // M개의 문자열을 하나씩 선택해서
    for(int i=0; i < m ; i++){
        // N개의 문자열중 매칭되는 ID를 검색해서 vector에 담는다.
        for(int j = 0 ; j < N;j++){
            if (checkMatching(k[i], id[j], 0, 0)){ // 매칭되면
                ret_vector.push_back(j);
            }
        }
        ret.push_back(ret_vector);
        ret_vector.clear();
    }    

    vector<int> compare_arr;
    int a = count_answer(ret, compare_arr, 0);
    printf("%d\n", a);
    
    // 실행 종료 시간 측정 
    end = clock();
    // 총 실행시간 계산
    double result = (double)(end-start)/CLOCKS_PER_SEC;
    printf("실행시간 : %lf 초\n",result);

    return 0;
}