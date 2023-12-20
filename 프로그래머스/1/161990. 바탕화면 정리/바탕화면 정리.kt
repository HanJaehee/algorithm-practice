class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var lux = Integer.MAX_VALUE
        var luy = Integer.MAX_VALUE
        var rdx = -1
        var rdy = -1
        
        for(i in wallpaper.indices){
            for(j in wallpaper[i].indices){
                if(wallpaper[i][j] == '#'){
                    lux = lux.coerceAtMost(i)
                    luy = luy.coerceAtMost(j)
                    rdx = rdx.coerceAtLeast(i)
                    rdy = rdy.coerceAtLeast(j)
                }
            }
        }
        return intArrayOf(lux, luy, rdx+1, rdy+1)
    }
}