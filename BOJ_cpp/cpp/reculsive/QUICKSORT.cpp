#include <bits/stdc++.h>

using namespace std;

// int n;
int n = 10;
int arr[1000001] = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};

void quickSort(int st, int en){
    // base condition
    if(en <= st+1) return;

    int pivot = arr[st];
    int lidx = st+1;
    int ridx = en-1;

    while(1){
        // 배열의 
        while(lidx <= ridx && arr[lidx] <= pivot) lidx++;
        while(lidx <= ridx && arr[ridx] > pivot) ridx--;
        if(lidx > ridx) break;
        swap(arr[lidx], arr[ridx]);
    }
    swap(arr[st], arr[ridx]);
    quickSort(st,ridx);
    quickSort(ridx+1,en);
}

void quickSort(int st, int en){
    if(en <= st +1) return;

    int pivot = arr[st];
    int lidx = st+1;
    int ridx = en-1;

    while(1){
        while(lidx <= ridx && arr[lidx] <= pivot) lidx++;
        while(lidx <= ridx && arr[ridx] >= pivot) ridx--;
        if(lidx > ridx) break;
        swap(arr[lidx],arr[ridx]);
    }

    swap(arr[st], arr[ridx]);
    quickSort(st, ridx);
    quickSort(ridx+1, en);
}


int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    // cin >> n;
    // for(int i =0;i<n;i++)
    //     cin >> arr[i];
    quickSort(0,n);
    for(int i =0;i<n;i++)
        cout << arr[i] << ' '; 
}