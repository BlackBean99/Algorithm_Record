import java.util.*;

class Solution {
    public long solution(String expression) {
        String[] ops = {"+", "-", "*"};
        long answer = 0;



        // BFS로 연산자 우선순위 순열 생성
        Queue<List<String>> q = new LinkedList<>();
        q.add(new ArrayList<>());

        while(!queue.isEmpty()){
            List<String> cur = q.poll();

            if(cur.size() == 3){
                long val = calculate(expression, cur);
                answer = Math.max(answer, val);
                continue;
            }

            for(String op: ops){
                if(!cur.contains(op)){
                    List<String> temp = new ArrayList<>(cur);
                    temp.add(op);
                    q.add(temp)
                }
            }
        }

        while (!q.isEmpty()) {
            List<String> cur = q.poll();

            if (cur.size() == 3) { // 순열 완성
                long val = calculate(expression, cur);
                answer = Math.max(answer, Math.abs(val));
                continue;
            }

            for (String op : ops) {
                if (!cur.contains(op)) {
                    List<String> next = new ArrayList<>(cur);
                    next.add(op);
                    q.add(next);
                }
            }
        }

        return answer;
    }


    // 2+3+4
    private long calculate(String expression, List<String> order) {
        List<String> token = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for(char c: expression.toCharArray()){
            if(c == '+' || c == '*' || c =='-'){
                token.add(num.toString());
                num.setLength(0);
                token.add(String.valueOf(c));
            }
            else {
                num.append(c);
            }
            token.add(num.toString());

            List<String> newTokens = new ArrayList<>();
            for(String op: order) {
                for(int i = 0; i < token.size(); i++){
                    if(token.get(i).equals(op)){
                        long a = Long.parseLong(newTokens.remove(newToken.size()-1));
                        long b = token.get(i++);
                        long value = operate(a,b,op);
                        newTokens.add(value);
                    } else {
                        newTokens.add(token.get(i));
                    }
                }
            }
            token = newTokens;
        }
    }
    private long calculate(Stirng expression, List<String> order) {
        List<String> token = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for(char c: expression.toCharArray()){
            if(c == '+' || c == '-' || c == '*'){
                tokens.add(num.toString());
                num.setLength(0);
                tokens.add(String.valueOf(c));
            } else {
                // 숫자가 나오면?
                num.append(c);
            }
            tokens.add(num.toString());
            // 우선순위 순서대로 연산
            List<String> newTokens = new ArrayList<>();
            for(String op: order){
                for(int i = 0; i < token.size(); i++){
                    if(token.get(i).equals(op)){
                        long a = Long.parseLong(newTokens.remove(newTokens.size() - 1));
                        long b = token.get(++i);
                        long value = operate(a, b, op);
                        newTokens.add(value);
                    } else {
                        newTokens.add(token.get(i));
                    }
                }
            }
            tokens = newTokens;
        }

    }
    private long calculate(String expression, List<String> order) {
        // 수식을 숫자와 연산자 분리
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                tokens.add(num.toString());
                num.setLength(0);
                tokens.add(String.valueOf(c));
            } else {
                num.append(c);
            }
        }
        tokens.add(num.toString());

        // 우선순위대로 연산 수행
        for (String op : order) {
            List<String> newTokens = new ArrayList<>();
            for (int i = 0; i < tokens.size(); i++) {
                String t = tokens.get(i);
                if (t.equals(op)) {
                    long a = Long.parseLong(newTokens.remove(newTokens.size() - 1));
                    long b = Long.parseLong(tokens.get(++i));
                    long res = operate(a, b, op);
                    newTokens.add(String.valueOf(res));
                } else {
                    newTokens.add(t);
                }
            }
            tokens = newTokens;
        }
        return Long.parseLong(tokens.get(0));
    }

    private long operate(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
        }
        throw new IllegalArgumentException("Invalid operator: " + op);
    }
}
