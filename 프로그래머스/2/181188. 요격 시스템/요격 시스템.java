import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int shot = -1;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        for(int[] target: targets){
            int left  = target[0];
            int right = target[1];
            if(left >= shot){
                answer++;
                shot = right;
            }
        }
        
        return answer;
    }
}