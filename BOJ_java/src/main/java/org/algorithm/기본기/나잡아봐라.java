import java.util.*;

class _05_02_string_compression {
    static String input = "abcabcabcabcdedededededef";
    
    public static int stringCompression(String string) {
        int n = string.length();
        int result = n;
        for (int splitSize = 1; splitSize <= n / 2; splitSize++) {
            List<String> splited = new ArrayList<>();
            for (int i = 0; i < n; i += splitSize) {
                if (i + splitSize <= n) {
                    splited.add(string.substring(i, i + splitSize));
                } else {
                    splited.add(string.substring(i));
                }
            }
            StringBuilder compressed = new StringBuilder();
            
            int count = 1;

            for (int i = 0; i < splited.size() - 1; i++) {
                String cur = splited.get(i);
                String next = splited.get(i + 1);
                
                if (cur.equals(next)) {
                    count += 1;
                } else {
                    if (count == 1) {
                        compressed.append(cur);
                    } else {  // count = 4 cur = "abc" next ="ded"
                        compressed.append(count).append(cur);
                    }
                    count = 1;
                }
            }
            
            if (count == 1) {
                compressed.append(splited.get(splited.size() - 1));
            } else {
                compressed.append(count).append(splited.get(splited.size() - 1));
            }
            result = Math.min(compressed.toString().length(), result);
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {
        System.out.println(stringCompression(input));  // 14 가 출력되어야 합니다!
        
        System.out.println("정답 = 3 / 현재 풀이 값 = " + stringCompression("JAAA"));
        System.out.println("정답 = 9 / 현재 풀이 값 = " + stringCompression("AZAAAZDWAAA"));
        System.out.println("정답 = 12 / 현재 풀이 값 = " + stringCompression("BBAABAAADABBBD"));
    }
}