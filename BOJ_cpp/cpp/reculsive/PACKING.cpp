function getCombination(
    arr : number[],
    r   : number,
    tmp : number[]   = [], // 조합 중 하나를 임시로 저장할 배열
    ans : number[][] = [], // 조합이 저장될 배열
) {
    // 조합 중 하나가 완성된 경우.
    if( tmp.length === r ) {
         ans.push(tmp);
         return ans;
    }
    // 마지막으로 사용한 요소의 다음 것 부터 사용한다.
    const lastIndex = tmp.length === 0 ? -1 : tmp[tmp.length-1]; 
    for(let i=lastIndex+1; i<arr.length; i++) {
        tmp.push(arr[i]);
        getCombination(arr, r, tmp, ans);
        tmp.pop();
    }
    return ans;
}
//
// [1, 2, 3, 4] 에서 3개를 선택.
const combination = getCombination([1, 2, 3, 4], 3); 



// 여행 짐싸기 문제를 해결하는 동적 계획법 알고리즘
int n, capacity;
int volume[100], need[100];
int cache[1001][100];
string name[100];
// 함수 정의하기
// capacity를 더 넣을 수 있을때, 지금까지 고른 아이템이 주어질때, 절박도의 최댓값가지는 item을 필요로한다.
int pack(int capacity, int item){
    // 기저사례 더 담을 수 없을 때, 
    if(item ==n) return 0;
    // 메모이제이션
    int& ret = cache[capacity][item];
    if(ret != -1) return ret;
    // 선택지 나열
    // 1. 담지 않을때
    return pack(capacity,item+1);
    // 2. 담을때
    if(capacity >= volume[item])
        ret = max(ret, pack(capacity - volume[item],item + 1) + need[item])
    return ret;
}

// 답을 역추적 하는 재귀호출 알고리즘
// pack 함수이 ㅏ선택한 물건들의 목록을 picked에 저장한다.
void reconstruct(int capacity, int item, vector<string>& picked){
    // 기저사례 : 모든 물건을 다 고려했음
    if(item == n) return;
    if(pack(capacity,item) == pack(capacity,item + 1)){
        reconstruct(capacity,item + 1, pricked);
    }
    else{
        // 선택
        picked.push_back(name[item]);
        reconstruct(capacity - volume[item], item + 1, picked);
    }


int pack(int capacity, int item){
    // 기저사례
    if(item == n)
    // 메모이제이션
    int& ret = cache[capacity][item];
    if(ret != -1)
        return 0;
    // 선택하지 않을때
    return pack(capacity, item + 1);
    // 선택
    if(capacity >= volume[item])
        ret = max(ret, pack(capacity - volume[item], item + 1) + need[item])
    return ret;
}