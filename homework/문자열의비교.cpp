#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

// 중복을 제외한 숫자의 종류의 수를 계산하는 함수
// @param data 
// @param name 원본 배열의 크기
// @return n 숫자의 종류의 수
class MyString{
    private:
        char *characters;
        int length;

    public:
        MyString(const char * str){
            this->length = strnlen(str,MAX_LENGTH);
            this->characters = new char[this->length];
            for(int i=0;i<this->length;i++){
                this->characters[i] = str[i];
            }
        }
        MyString(const string & original){
            this->length = original.length();
            this->characters = new char[this->length];
            for(int i = 0;i<this->length;i++){
                this->characters[i] = original[i];
            }
        }
        ~MyString(){
            delete[] characters;
        }
        /*
        @param o 비교할 문자열 ( 오른쪽 항 )
        @return true : this 가 o 보다 사전순으로 앞선다면 true
        @return false else
        */
        bool operator < (const MyString & o) const{
            int n = min(this->length,o.length);
            // 채워넣어~~
            
        }
        /*
        @param o 비교할 문자열 ( 오른쪽 항 )
        @return true : this 가 o 보다 사전순으로 앞선다면 true
        @return false else
        */
        bool operator > (const MyString & o) const{
            int n = min(this->length,o.length);
            // 채워넣어~~
        }
/*
        @param o 비교할 문자열 ( 오른쪽 항 )
        @return true : this 가 o 보다 사전순으로 앞선다면 true
        @return false else
        */
        bool operator == (const MyString & o) const{
            int n = min(this->length,o.length);
            // 채워넣어~~
        }
}

int main(){
    string s1;
    string s2;
    cin >> s1 >> s2;

    MyString mys1(s1);
    MyString mys2(s2);

    if(mts1 < mys2){
        printf("-1");
    }
    else if(mys1 > mys2){
        printf("1");
    }
    else{
        printf("0");
    }
    return 0;
}