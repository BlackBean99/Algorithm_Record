#include <stdio.h>
#include <string.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <time.h>


using namespace std;
// :문자 제거
void Eliminate(char *str, char ch);


int main(void)
{
    /**
    param n : 버스 운행 횟수
    param t :  버스 운행 간격
    param m 한 버스에 탈 수 있는 최대 학생 수
    **/
    // parameter 입력받기
    int n, t, m;
    scanf("%d %d %d",&n,&t,&m);

// 각 학생들이 버스 정류장에 도착하는 시각이 공백을 두어 주어진다
    vector<char> str;

    char* tmp;
    int int_input;
    vector<char> char_list;
    vector<int> int_list;
 
//  Enter을 칠때까지 데이터를 받고, " : " 문자열을 제거한 후 정수형으로 변환하여 벡터에 저장한다.
	do {
		cin >> tmp;
        char_list.push_back(tmp);
        
	} while (getc(stdin) == ' ');
    char* transfer;
    for(int i = 0 ; i < int_list.size();i++){
        Eliminate(char_list.pop_back(), ':');
        int_input = atoi(tmp);
        printf("%d\n",int_input);
        int_list.push_back(int_input);
    }

    // 버스 탑승예정 총 인원수
    int number_person = int_list.size();

    printf("%s\n", int_list);
    // // 현재 몇번째 승객을 태우고 있는지 확인한다.
    // int current = 0;
    // 9시를 의미한다.
    int time = 900;

    int start,end;
    // 실행시작 시간 측정
    start = clock();
    
    // 입력 시간 데이터 정렬.
    sort(int_list.begin(),int_list.end());
    // 마지막에 온 사람이 9시 전에 도착했다면 09:00 에 도착하면 된다.
    if(int_list[int_list.size()-1]<=900){
        printf("09:00");
    }

    // 9시전에 태운사람의 index
    int index = 0;
    // 9시전에 온 사람 먼저 태운다.
    for(int i = 0 ; i < n; i++){
        if(time+i*t<=900){
            index++;            
        }
    }
    for(int i = index ; i < m;)
    // 0버스를 먼저 보낸다. n번의 버스를 운행하면서 
    for(int i = 1 ; i < n; i++){
        // 버스가 올때마다 돌면서 인원이 현재 순서보다 빨리 도착했는지 확인한다.
        for(int j = index; j < number_person; j++){
            if(time+(i)*t < int_list[j] <= time + (i+1)*t){
                index = j+1;
                }
            else{
                break;
            }
            // 마지막 버스의 시간에 사용자가 탄다면 그 버스를 타는 마지막 사람이 온 시간에 먼저 와서 새치기를 하면 된다. 이때 시간을 출력한다.
            if((number_person - m<(index+m-1))&&((index+m-1)<number_person)){
                printf("%d",int_list[j]);
            }
        }
    }    
    // 실행 종료 시간 측정 
    end = clock();
    // 총 실행시간 계산
    int result = (end-start);
    printf("실행시간 : %d초",result);

return 0;

}

 

void Eliminate(char *str, char ch){
    for (; *str != '\0'; str++)//종료 문자를 만날 때까지 반복
    {
        if (*str == ch)//ch와 같은 문자일 때
        {
            strcpy(str, str + 1);
            str--;
        }
    }
}