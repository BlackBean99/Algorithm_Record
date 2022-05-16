// factorials[i] = i!
int factorials[12];

// ㅌrk [0...n-1]의 순열일때 사전순 번호를 반환한다.
int getIndex(const vector<int>& X){
    int ret = 0;
    for(int i =0;i< X.size(); ++i){
        int less = 0;
        // X[i+1] 중 X[i] 보다 작은 수를 센다. 이것이 X앞에 오는 묶음의 수가 된다.
        for(int j=i+1;j<X.size;++j){
            if(X[j] < X[i])
                ++less;
            ret += factorials[X.size() -i -1]*less;
        }
        return ret;
    }
}
