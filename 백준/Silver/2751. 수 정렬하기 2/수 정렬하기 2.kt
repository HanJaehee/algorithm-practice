import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var token = StringTokenizer(readLine())
    val N = token.nextToken().toInt()

    val list = mutableListOf<Int>()


    for(i in 0 until N){
        token = StringTokenizer(readLine())
        list.add(token.nextToken().toInt())
    }

    val sb = StringBuilder()
    list.sorted().forEach { sb.append(it).append("\n") }

    println(sb)
}
