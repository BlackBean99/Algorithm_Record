#include <stdio.h>
#include <iostream>
#include <map>

using namespace std;


int main(){
    map<string, int> m;
    // map을 순회하기 위한 Iterator을 선언
    map<string,int>::iterator it;

    int n;
    cin >> n;

    int maxFrequency = 0;

    for(int i = 0 ; i < n; i++){
        string str;
        cin >> str;
        m[str]++;
        int k = m[str];
        if(k>maxFrequency){
            maxFrequency = k;
        }
    }

    for(it=m.begin();it != m.end(); it++){
        if(it->second == maxFrequency)
            cout << it->first.c_str();
    }
    
    return 0;
}