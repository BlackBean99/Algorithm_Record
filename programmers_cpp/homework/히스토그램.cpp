#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>
#include<vector>

using namespace std;



int solve(vector<int> h, int left, int right){
    //  사각형가 하나밖에 없는 경우
    if(left == right) return h[left];

    // [left,mid], [mid+1,right]두 구간으로 나눠서 문제를 분할한다.
    int mid = (left + right) / 2;

    int ret = max(solve(h,left,mid),solve(h, mid+1,right));

// 두 부분문제에 걸친 사각형중 가장 큰 것을 찾는다.
    int lo = mid, hi = mid + 1;
    int height = min(h[lo],h[hi]);
    // [mid,mid+1] 만 포함하는 너비 2인 사각형을 고려한다.
    ret = max(ret,height*2);

    while(left < lo || hi < right){
        // 항상 높이가 더 높은 쪽으로 확장한다.
        if(hi < right && (lo == left || h[lo-1] < h[hi+1])){
            ++hi;
            height = min(height, h[hi]);
        }
        else{
            --lo;
            height = min(height,h[lo]);
        }
        // 확장한 후 사각형의 넓이
        ret = max(ret, height * (hi -lo +1));
    }
    return ret;
}

int process(int caseSize){
    int n;
    int height;
    cin >> n;

    vector<int> histogram; 
    for(int i = 0; i < n; i++){
        cin >> height;
        histogram.push_back(height);
    }
    int ret;
    ret = solve(histogram, 0 , n);
    return ret;
}

int main(){

    int caseSize;
    cin >> caseSize;
    int answer;

    vector<int> answer_list;

    for(int caseIndex = 0; caseIndex < caseSize; caseIndex++){
        answer = process(caseIndex);
        answer_list.push_back(answer);
    }
    for(int caseIndex = 0; caseIndex < caseSize; caseIndex++){
        cout << answer_list[caseIndex] << endl;
    }
    return 0;
}