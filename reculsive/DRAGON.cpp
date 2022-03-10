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