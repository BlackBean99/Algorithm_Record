#include <bits/stdc++.h>

using namespace std;
int n = 10;
int tmp[10000];
int arr[10000];

// 한 배열을 두개로 쪼개서 한개로 다시 합친다.
void merge(int st, int en){
    int mid = (st + en)/2;
    int lidx = st;
    int ridx = mid;
    for(int i = st; i < en; i++){
        if(ridx == en) tmp[i] = arr[lidx++];
        else if(lidx == mid) tmp[i] = arr[ridx++];
        else if(arr[lidx] <= arr[ridx]) tmp[i] =arr[lidx++];
        else tmp[i] = arr[ridx++];
    }
    for(int i = st; i< en; i++)
        arr[i] = tmp[i];
}


// a[st:en]을 정렬하고 싶다.
    void merge_sort(int st, int en){
    if(en == st+1) return; // 리스트의 길이가 1인 경우
    int mid = (st+en)/2;
    merge_sort(st, mid); // arr[st:mid]을 정렬한다.
    merge_sort(mid+1, en); // arr[mid:en]을 정렬한다.
    merge(st, en); // arr[st:mid]와 arr[mid:en]을 합친다.
    }

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i=0;i<n;i++)
        cin >> arr[i];
    merge_sort(0,n);
    for(int i =0; i < n;i++)
        cout << arr[i] << ' ';
}