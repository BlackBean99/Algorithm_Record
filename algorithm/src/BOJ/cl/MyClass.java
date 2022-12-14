package BOJ.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyClass {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Integer n = Integer.parseInt(s[0]);
        Integer k = Integer.parseInt(s[1]);
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        Integer[][] integers = new Integer[100][100];
        for (int i = 0; i < n; i++) {
            integers[i][0] = 0;
        }
        for (int i = 0; i < k; i++) {
            integers[0][i] = 0;
        }

        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> weights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            weights.add(Integer.parseInt(s1[0]));
            values.add(Integer.parseInt(s1[1]));
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                if(weights.get(i) > j)
                    integers[i][j] = integers[i-1][j];
                else {
                    integers[i][j] = Math.max(integers[i-1][j],integers[i-1][j-weights.get(i)]+values.get(i));
                }
            }
        }
        System.out.println(integers[n][k]);

    }
}
