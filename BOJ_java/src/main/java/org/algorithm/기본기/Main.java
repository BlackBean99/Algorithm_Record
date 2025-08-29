import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 4, 6, 7, 9, 11, 13, 79, 125, 363);
        int d = 2;
        int first = arr.get(0);
        List<Integer> outliers = new ArrayList<>();

        int n = arr.size();
        int expected = first;
        int pos = 0; // 현재 확인할 인덱스

        while (pos < n) {
            // 현재 expected 값이 arr 내에 존재하는지 확인
            int found = Collections.binarySearch(arr, expected);

            if (found >= 0) {
                // 정상 값 → 다음 expected 로 진행
                expected += d;
                pos = found + 1; // 다음 탐색 범위를 줄일 수 있음
            } else {
                // 존재하지 않음 → 이탈
                int insertPoint = -found - 1;
                if (insertPoint < n) {
                    outliers.add(arr.get(insertPoint));
                    pos = insertPoint + 1; // 스킵
                } else {
                    break;
                }
            }
        }

        System.out.println("이탈값들: " + outliers);
    }
}