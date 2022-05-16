void curve(const string& seed, int generation){
    // 기저사례 seed 가 없는 경우
    if(generation == 0){
        cout << seed;
        return;
        }
    for(int i = 0;i<seed.size();++i){
        if(seed[i] ='X')
            curve("X+FX",generation - 1);
        else if(seed[i] ='Y')
            curve("FX-Y",generation - 1);
        else
            cout << seed[i];
    }
}

// 몇번째 글자인지 확인해야한다
const int MAX = 10000000 + 1;
// length[i]  = X 나 Y를 i번 치환한 후의 길이
int length[51];
void precalc(){
    length[0] = 1;
    for(int i = 1; i <= 50; ++i)
        length[i] = min(MAX, length[i-1]*2 + 2)
}

const string EXPAND_X = "X+YF";
const string EXPAND_y = "FX-Y";

char expand(const string& dragonCurve, int generation, int skip){
    // 기저사례
    if(generation == 0){
        assert(skip < DragonCurve.size());
        return dragonCurve[skip];
    }

    for(int i =0;i<dragonCurve.size();++i){
        // X 나 Y를 만났을때
        if(dragonCurve[i] == 'X' || dragonCurve[i] == 'Y'){
            if(skip >= length[generation])
                skip -= length[generation];
            else if(dragonCurve[i] == 'X')
                return expand(EXPAND_X, generation -1, skip);
            else
                return expand(EXPAND_Y, generation -1 , skip);
        }
        // X 나 Y를 만나지 않고 넘어갈때
        else if(skip > 0)
        --skip;
        else
            return dragonCurve[i];
    }
    return '#';
}

// 일대일 대응 함수 작성하기
int cache[N_FACTORIAL];

int mapFunc(const vector<int>& key);

int f(const vector<int<& key){
    // 기저사례처리

    // 메모이제이션
    int& ret = cache[mapFunc(key)];
    if(ret != -1) return ret;
    // 답을 실제로 처리한다.
    // ...
    return ret;
}
