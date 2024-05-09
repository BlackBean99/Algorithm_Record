package org.algorithm.우선순위큐.강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int classCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringTokenizer st;
        Class[] lecture = new Class[classCnt];

        for (int i = 0; i < classCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i] = new Class(start, end);
        }

        Arrays.sort(
                lecture,
                (l1, l2) ->
                        l1.getStart() == l2.getStart()
                                ? l1.getEnd() - l2.getEnd()
                                : l1.getStart() - l2.getStart());
        q.offer(lecture[0].getEnd());

        for (int i = 1; i < classCnt; i++) {
            if (q.peek() <= lecture[i].getStart()) {
                q.poll();
            }
            q.offer(lecture[i].getEnd());
        }
        System.out.println(q.size());
    }
}

class Class implements Comparable<Class> {
    private int start;
    private int end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class c) {
        if (this.end < c.getEnd()) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
