package org.algorithm.집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int num = -1;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            Set<Integer> initSet = getInitSet();
            switch (order) {
                case "add":
                    {
                        set.add(num);
                        break;
                    }
                case "remove":
                    {
                        set.remove(num);
                        break;
                    }
                case "check":
                    {
                        if (set.contains(num)) {
                            sb.append(1);
                            sb.append("\n");
                        } else {
                            sb.append(0);
                            sb.append("\n");
                        }
                        break;
                    }
                case "toggle":
                    {
                        if (set.contains(num)) {
                            set.remove(num);
                        } else {
                            set.add(num);
                        }
                        break;
                    }
                case "all":
                    {
                        set = initSet;
                        break;
                    }
                case "empty":
                    {
                        set = new HashSet<>();
                        break;
                    }
            }
        }
        System.out.println(sb);
    }

    private static Set<Integer> getInitSet() {
        Set<Integer> tempSet = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            tempSet.add(i);
        }
        return tempSet;
    }
}
