package org.algorithm.회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc != 0) {
            String sentence = br.readLine();
            process(sentence);
            tc--;
        }
    }

    private static void process(String sentence) {
        int flag = 2;
        if (isPalindrome(sentence)) {
            flag = 0;
        } else {
            int length = sentence.length();
            for (int i = 0; i < length / 2; i++) {
                if (sentence.charAt(i) != sentence.charAt(length - i - 1)) {
                    if (isPalindrome(sentence.substring(i, length - i - 1))
                            || isPalindrome(sentence.substring(i + 1, length - i))) {
                        flag = 1;
                        break;
                    } else {
                        flag = 2;
                        break;
                    }
                }
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
