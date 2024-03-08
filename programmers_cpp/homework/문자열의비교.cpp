#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;
const int MAX_LENGTH = 100;

class MyString{
    private:
    
        char *characters; // 단어
        int length; // 단어의 길이
    public:
        MyString(const char * str){
            this->length = strlen(str,MAX_LENGTH);
            this->characters = new char[this->length];
            for(int i=0;i<this->length;i++){
                this->characters[i] = str[i];
            }
        }
        MyString(const string & original){
            // 입력받은 개체를 현재 개체에 대입한다. 
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
            for(int i = 0; i< n;i++){
                if(this->characters[i] < o.characters[i]){
                    return true;
                } else if(this->characters[i] > o.characters[i]){
                    return false;
                }
            }
            // algorithm algo 
            if(this->length < o.length){
                return true;
            } else{
                return false;
            }
        }
        /*
        @param o 비교할 문자열 ( 오른쪽 항 )
        @return true : this 가 o 보다 사전순으로 앞선다면 true
        @return false else
        */
        bool operator > (const MyString & o) const{
            int n = min(this->length,o.length);
            // 작은 문자열 만큼만 비교한다.
            for(int i = 0; i< n;i++){
                if(this->characters[i] < o.characters[i]){
                    return false;
                } else if(this->characters[i] > o.characters[i]){
                    return true;
                }
            }
            // algorithm algo 
            if(this->length > o.length){
                return true;
            } else{
                return false;
            }
        }
/*
        @param o 비교할 문자열 ( 오른쪽 항 )
        @return true : this 가 o 보다 사전순으로 앞선다면 true
        @return false else
        */
        bool operator == (const MyString & o) const{
            if(this->characters[i] != o.characters[i]){
                return false;
            for(int i=0;i<this->length;i++){
                if(this->characters[i] != o.characters[i]){
                    return false;
                }
            }
            return true;
        }
};

int main(){
    string s1;
    string s2;
    cin >> s1 >> s2; // scnaf  대신 

    MyString mys1(s1);
    MyString mys2(s2);

    if(mys1 < mys2){
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