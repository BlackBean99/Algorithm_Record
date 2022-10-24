//
// Created by ymecc on 2022-10-24.
//

#include "Selection.h"
    void SelectionSort(int[] arr, int left, int right, int k){
        int lidx = left+1;
        int ridx = right;
        int pivot = arr[left];
//         pivot 보다 작으면 왼쪽으로
// pivot 보다 크면 오른쪽으로 이동.
        while(ridx <= lidx){
            if(arr[ridx] > pivot){
                ridx--;
            }
            else if(arr[lidx] < pivot){
                lidx++;
            }
            else if(arr[lidx] >= pivot && arr[ridx] <= pivot){
                swap(arr[lidx], arr[ridx]);
            }
        }
        S = (p-1) - left + 1;
        // 

        if(k <= S) SelectionSort(arr, left, p-1,k);
        //  찾는 값 일때,
        else if(k = S + 1) return A[p];
        else SelectionSort(A , p+1, right, k-S-1);
    }