#include <stdio.h>
#define MAX_SIZE 7

int sorted[MAX_SIZE];



void merge(int *list,int left, int mid,int right){
    int i = left;
    int j = mid + 1;
    int k = left;
    int l;

    while(i < mid && j < right){
        if(list[i] <= list[j])
            sorted[k++] = list[i++];
        else
            sorted[k++] = list[j++];
    }

  // 남아 있는 값들을 일괄 복사
  if(i > mid){
      while(j <= right){
        sorted[k++] = list[j++];
      }
  }
  // 남아 있는 값들을 일괄 복사
  else{
      while(i <= right){
      sorted[k++] = list[i++];
    }
  }

  for (i = left, k = 0; i <= right; i++, k++) list[i] = sorted[k];
    // sorted -> list
    // for(int i = 0; i <= right; i++)
    //     list[i] = sorted[i];
}



void merge_sort(int list[],int left,int right){
    if(left < right){
        // Split
        int mid = (left + right) / 2;
        // 처음부터 중간까지 스플릿
        merge_sort(list, left, mid);
        //  중간부터 끝까지 스플릿
        merge_sort(list, mid + 1, right);
        // 두개를 병합하면서 정렬
        merge(list, left, mid, right);
    }
}

int main(){
    int n = MAX_SIZE;
    // 홀수인 경우
    int list[n] = { 21, 10, 12, 20, 25, 13, 15};
    // 짝수인 경우
    // int list[n] = { 21, 10, 12, 20 , 25, 13, 15 ,22};
    
    for(int i = 0 ; i < MAX_SIZE; i++){
        printf("%d, ", list[i]);
    }
    printf("\n");

    merge_sort(list,0,n-1);

    for(int i = 0 ; i < MAX_SIZE; i++){
        printf("%d, ", list[i]);
    }
    return 0;
}