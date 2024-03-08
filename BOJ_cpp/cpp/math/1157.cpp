#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
// 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
/**
Mississipi   -> ?
zZa => Z
*/

string translateUpper(string str){
    for(int i = 0 ; i< str.size();i++){
        if('a' <= str[i] && 'z' >= str[i]){
            str[i] = toupper(str[i]);
        }
    }
    return str;
}

int main(){
    string str;
    cin >> str;
    vector<char> answer;
    str = translateUpper(str);
    map<char, int> frequencyMap;
    map<char,int>::iterator it;


    // 빈도수 기록
    int maxFrequency = 0;
    char maxIndex;
    for(char &ch : str){
        frequencyMap[ch]++;
        // maxFrequency 값 갱신
        if(frequencyMap[ch] > maxFrequency){
            maxFrequency  = frequencyMap[ch];
            // maxIndex = ch
        }
    }
    for(it = frequencyMap.begin(); it != frequencyMap.end(); it++){
        if(it->second == maxFrequency){
            answer.push_back(it->first);
            // cout << it->first.c_str();
        }
    }
    if(answer.size() > 1){
        cout << "?" << endl;
    }
    else{
        cout << answer[0];
    }
    return 0;
}