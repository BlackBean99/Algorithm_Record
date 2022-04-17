// 조합 구현하기 r개를 선택하기
void get_permutation(int[] arr, int[] out, boolean[] visited, int depth, int r){
    // 기저 사례 ( 다 뽑았을 때 ) -> 종료조건
    if(depth==r){
        for(int i = 0 ; i < r; i++){
            printf("%d",out[i]);    
        }
            return;
    }
// depth는 현재 채우고 있는 out 의 인덱스.
    for(int i = 0 ; i < arr.size(); i++){
        // 방문하지 않은 원소라면
        if(!visted[i]){
            visted[i] = treu;
            out[depth] = arr[i];
            get_permutation(arr, out, visted, depth+1, r);
            visted[i]  = false;
        }
    }
}

// 중복 순열 r 개를 뽑는 경우
void get_overlap_permutation(int[] arr, int[] out, int depth, int r){
    // 기저사례
    if(depth==r){
        for(int i = 0 ; i < r; i++){
            printf("%d",out[i]);    
        }
            return;
    }
    for(int i = 0 ; i < arr.size();i++){
        out[depth] = arr[i];
        get_overlap_permutation(arr, out, depth+1,r);

    }
}

void get_combination(int[] arr, boolean[] visted, int start, int depth, int r){
    // 기저사례 종료조건
    if(depth==r){
        for(int i = 0 ; i < r; i++){
            if(visted[i])
                printf("%d", arr[i]);
        }
            return;
    }
    for(i=start;i<arr.size();i++){
        if(!visted[i]){
            visted = true;
            get_combination(arr, visted, i+1, depth+1,r);
            visted = false;
        }
    }
}

//  현재 선택한 원소를 포함해야 중복을 허용하는 것이다.
void get_overlap_combination(int[] arr,int[] out, int start, int depth, int r){
    if(depth==r){
        for(int i = 0 ; i < r; i++){
            printf("%d",out[i]);
        }
            return;
    }
    for(i=start;i<arr.size();i++){
        out[i] = arr[i];
        get_overlap_combination(arr, i, depth+1, r);
    }
}