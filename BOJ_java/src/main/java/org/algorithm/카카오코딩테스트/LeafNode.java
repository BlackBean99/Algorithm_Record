public class LeafNode {
    public static void main(String[] args){
        int[] dist_limit = new int[]{3,0,3,5};
        int[] split_limit = new int[]{6,10,100,16};
        int[] result = new int[]{6,1,7,9};
        for(int i = 0; i < dist_limit.length; i++){
            validate(solution(dist_limit[i], split_limit[i]), result[i]);
        }        
    }
    private void validate(int expected, int result){
        System.out.println("expected : " + expected + " / result" + result);
        if(expected == result) System.out.println("Pass");
    }
    int[][] map;
    List<List<Integer>> graph;
    int dist_limit, split_limit;
    int answer = Integer.MAX_VALUE;
    private int solution(int dist_limit, int split_limit){
        graph = new LinkedList<>();
        graph.add(0);
        // 2와 3의 개수 합 = dist_count
        int dist_count = 0;
        dfs(graph, 0,0, 1);
    }
    
    private void dfs(List<List<Integer> graph, int dist_count, int maxLeafCount, int depth){
        if(dist_count == dist_limit){
            // 분배도 계산
            answer = Math.min(answer,maxLeafCount);
            return;
        } else {
            // 
            for(Integer leaf: graph.get(depth)){
                // 2,0 으로 채워진 조합
                List<List<Integer>> combination1 = getPermutation(List.valueOf(2,0));                
                for(List<Integer> combination: combination1){
                    graph.add(combination);
                    int temp_dist_count = combination1.stream().filter(a -> a == 2);
                    int temp_leaf_count = combination1.size() - temp_dist_count;    
                    dfs(graph, dist_count, dist_count + temp_dist_count, maxLeafCount + temp_leaf_count, depth + 1);
                    graph.remove(depth+1);
                }
                
                List<Integer> combination2 = getPermutation(List.valueOf(3,0));
                for(List<Integer> combination: combination2){
                    graph.add(combination2);
                    temp_dist_count = combination1.stream().filter(a -> a == 3);
                    temp_leaf_count = combination1.size() - temp_dist_count;
                    // 분배도 갱신 : depth에서 
                    dfs(graph, dist_count, dist_count + temp_dist_count, maxLeafCount + temp_leaf_count, depth + 1);
                    graph.remove(depth+1);
                }
            }
        }
    }
    private List<Integer> getPermutation(List<Integer> kind){
        
    }
}
