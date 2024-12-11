import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val gak1 = readLine().toInt()
    val gak2 = readLine().toInt()
    val gak3 = readLine().toInt()

    if(gak1 + gak2 + gak3 == 180){
        if((gak1 == gak2) && gak3 == 60){
            println("Equilateral")
        }else if((gak1 == gak2) || (gak1 == gak3) || (gak2 == gak3)) {
            println("Isosceles")
        }else{
            println("Scalene")
        }
    }else{
        println("Error")
    }
}

