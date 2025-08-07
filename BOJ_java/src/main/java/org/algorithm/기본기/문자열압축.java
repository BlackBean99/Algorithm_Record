class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int size = 1; size < s.length() / 2 + 1; size++){
            String sentence = "";
            String[] compressed = new String[s.length() / size + 1];
            for(int i = 0; i < compressed.length; i++){
                int firstIndex = i * size;
                int secondIndex = (i+1) * size;
                if(secondIndex >= s.length()) secondIndex = s.length();
                String word = s.substring(firstIndex, secondIndex);
                compressed[i] = word;
            }
            
            
            int count = 1;
            for(int i = 0; i < compressed.length - 1; i++){
                if(compressed[i].equals(compressed[i+1])){
                    count++;
                } else {
                    if(count > 1){
                        sentence += (String.valueOf(count) + compressed[i]);
                    } else {
                        sentence += compressed[i];
                    }
                    count = 1;
                }
            }
            if(count > 1) sentence += ((String.valueOf(count) + compressed[compressed.length - 1]));
            else sentence += compressed[compressed.length - 1];
            answer = Math.min(answer, sentence.length());
        }
        
        return answer;
    }
}