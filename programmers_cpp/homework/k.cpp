#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <iostream>


using namespace std;

int k;

int foo(int h){
    if(h == 0){
        return 1;
    }
    else if(h==1){
        return 2;
    }
    k = foo(h-1) + foo(h-2);
    return k;
}

int main(){
    int a = foo(7);
    cout << a;
    return 0;
}