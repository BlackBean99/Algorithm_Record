#include <stdio.h>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
/**
 n : 카드의 수
 m : 검사하려는 당첨번호의 수
 card : 각 카드에 적힌 숫자들
 target : 검사하려는 각 당첨번호 리스트
*/

vector<int> getPossibleTargets(int n, int m, int *cards, int * targets){
    vector<int> possibleTargets;

    sort(cards, cards + n);
    for(int i = 0; i < m;i++){
        int k = targets[i];
        bool possible = false;
        for(int j = 0; j < n ; j++){
            int x = cards[j]; //모든 카드에 대해서
            for(int p = 0;p<=j;p+=1){ // 숫자조합의 중복 없애기
                int y = cards[p]; //카드를 하나 선택
                int z = k-(x+y);  // 이 수식이 되는 z를 찾는다.
                if(binary_search(cards,cards+n,z)==true) //시작위치, 끝위치, 찾을 값
                {
                    possible = true;
                    break;
                }
            }
            if(possible){ //이미 찾은 값일 경우 탈출한다.
                break;
            }
        }
        if(possible){//새 카드의 합으로 k를 만들 수 있다면 추가한다.
            possibleTargets.push_back(k);
        }
    }
    sort(possibleTargets.begin(),possibleTargets.end());
    return possibleTargets;
}

int main(){
    int n;
    int m;
    scanf("%d %d", &n, &m);

    int* cards = new int[n];
    int* targets = new int[m];

    // int tmp;
    // for(int i = 0; i< n;i++){
    //     cin >> tmp;
    //     cards.push_back(tmp);
    // }

    // 각 카드 정보를 입력받는다.
    for(int i = 0; i < n; i++){
        scanf("%d", &cards[i]);
    }
    // for(int i = 0; i< m;i++){
    //     cin >> tmp;
    //     targets.push_back(tmp);
    // }
    // 각 후보 당첨번호를 입력받는다.
    for(int i = 0; i < m; i++){
        scanf("%d", &targets[i]);
    }
    printf("뭐");
    vector<int> answers = getPossibleTargets(n,m, cards, targets);

    if(answers.size()==0){
        printf("NO");
    } else{ //가능한 당첨번호가 존재한다면 그 목록을 출력한다.
        for(int i = 0;i< answers.size();i++){
            if( i > 0){
                printf(" ");
            }
            printf("%d",answers[i]);
        }
    }

    return 0;
}