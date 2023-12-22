import java.util.*;

class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0
        var shot = -1
        
        Arrays.sort(targets){ o1, o2 -> o1[1] - o2[1] }
        
        targets.forEach{
            val left = it[0];
            val right = it[1];
            if(left >= shot){
                answer++;
                shot = right
            }
        }
        
        return answer
    }
}