import java.util.*;

public class FactorySimulation {
    static class Job {
        int finishTime;
        int processIndex;
        int count;
        Job(int finishTime, int processIndex, int count) {
            this.finishTime = finishTime;
            this.processIndex = processIndex;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String baseName = "a";
        String targetName = "t";
        int targetCount = 2;

        String[] process = {
            "a 1 b 1",       // a → b
            "b 2 d 1 t 1"    // b, d → t
        };
        int[] takenTime = {1, 3};

        int result = minTimeToProduce(baseName, targetName, targetCount, process, takenTime);
        System.out.println("최소 시간: " + result);
    }

    static int minTimeToProduce(String baseName, String targetName, int targetCount,
                                String[] process, int[] takenTime) {
        // 재료 이름 → 인덱스 매핑
        Map<String, Integer> itemIndex = new HashMap<>();
        int idxCounter = 0;
        itemIndex.put(baseName, idxCounter++);

        List<int[]> inputs = new ArrayList<>();
        List<int[]> outputs = new ArrayList<>();

        for (String p : process) {
            String[] parts = p.split(" ");
            List<Integer> inList = new ArrayList<>();
            List<Integer> outList = new ArrayList<>();

            for (int i = 0; i < parts.length - 2; i += 2) {
                String name = parts[i];
                int count = Integer.parseInt(parts[i+1]);
                if (!itemIndex.containsKey(name)) {
                    itemIndex.put(name, idxCounter++);
                }
                inList.add(itemIndex.get(name));
                inList.add(count);
            }
            // 결과물
            String outName = parts[parts.length - 2];
            int outCount = Integer.parseInt(parts[parts.length - 1]);
            if (!itemIndex.containsKey(outName)) {
                itemIndex.put(outName, idxCounter++);
            }
            outList.add(itemIndex.get(outName));
            outList.add(outCount);

            inputs.add(inList.stream().mapToInt(Integer::intValue).toArray());
            outputs.add(outList.stream().mapToInt(Integer::intValue).toArray());
        }

        int itemCount = idxCounter;
        int targetIndex = itemIndex.getOrDefault(targetName, -1);
        if (targetIndex == -1) return -1;

        // 재고
        int[] stock = new int[itemCount];
        int time = 0;

        // 진행 중 작업
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(j -> j.finishTime));

        while (true) {
            time++;

            // 기본 자원 추가
            stock[itemIndex.get(baseName)]++;

            // 완료된 작업 처리
            while (!pq.isEmpty() && pq.peek().finishTime == time) {
                Job job = pq.poll();
                int[] out = outputs.get(job.processIndex);
                stock[out[0]] += out[1] * job.count;
            }

            // 목표 달성 확인
            if (stock[targetIndex] >= targetCount) {
                return time;
            }

            // 실행 가능한 모든 공정 시작
            for (int i = 0; i < process.length; i++) {
                int[] in = inputs.get(i);
                int minPossible = Integer.MAX_VALUE;
                for (int j = 0; j < in.length; j += 2) {
                    minPossible = Math.min(minPossible, stock[in[j]] / in[j+1]);
                }
                if (minPossible > 0) {
                    // 재료 소모
                    for (int j = 0; j < in.length; j += 2) {
                        stock[in[j]] -= in[j+1] * minPossible;
                    }
                    pq.offer(new Job(time + takenTime[i], i, minPossible));
                }
            }
        }
    }
}
