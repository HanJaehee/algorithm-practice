import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())

    val a = token.nextToken().toInt()
    val b = token.nextToken().toInt()

    val gcd = gcd(a, b);
    println(gcd)
    println(a * b / gcd)


}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
