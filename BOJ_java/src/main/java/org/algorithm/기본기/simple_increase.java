import java.util.*;

class Main {
    static List<Integer> index;
    static int[] arr;

    public static void main(String[] args){
        arr = new int[]{1,3,5,7,9,11,14,15,16,18,20,22,24,26,27,29,31,35,38,41};
        index = new LinkedList<>();
        findWrongIncrease(0, arr.length - 1, 2);
        
        for(Integer a: index){
            System.out.println(a);
        }
    }

    static void findWrongIncrease(int start, int end, int add){
        if(start >= end) return;

        // 구간이 등차수열 조건을 만족하는지 검사
        int expectedEnd = arr[start] + add * (end - start);
        if(arr[end] == expectedEnd){
            return; // 문제 없음
        }

        if(start + 1 == end){
            // 인접 원소 차이 확인
            if(arr[end] - arr[start] != add){
                index.add(end); // 깨진 지점 저장
            }
            return;
        }

        int mid = (start + end) / 2;
        findWrongIncrease(start, mid, add);
        findWrongIncrease(mid, end, add);
    }
}
