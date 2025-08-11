// 분할정복 알고리즘으로 풀이
vector<int> h;

int solve(int left, int right){
    //  판자가 하나밖에 없는 경우
    if(left == right) return h[left];

    // [left,mid], [mid+1,right]두 구간으로 나눠서 문제를 분할한다.
    int mid = (left + right) / 2;

    int ret = max(solve(left,mid),solve(mid+1,right));

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