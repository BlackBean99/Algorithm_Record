import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        // 같은 양의 두 용액          
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        int minSum = Integer.MAX_VALUE;
        int ansLeft = 0;
        int ansRight = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ansLeft = left;
                ansRight = right;
            }

            if (sum > 0) right--;  // 합이 양수 → 오른쪽 감소
            else left++;           // 합이 음수 → 왼쪽 증가
        }

        System.out.println(arr[ansLeft] + " " + arr[ansRight]);
    }
}