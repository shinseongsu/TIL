package variable


// 04. Function
// - 함수란
//      -- 어떤 input 을 넣어주면 어떤 output 나오는 것
//      -- y = x + 2

// - 함수를 선언하는 방법
// fun 함수명 (변수명: 타입, 변수명:타입, ...) : 반환형 {
//   함수 내용
//   return 반환값
// }

fun plus(first: Int, second: Int): Int {
    println("first : $first")
    println("second: $second")
    val result: Int = first + second
    return result
}

fun main(araay: Array<String>) {
    val result = plus(5, 10)
    println(result)

    val result2 = plus(first = 20, second = 30)
    println(result2)

    val result3 = plus(second = 100, first = 10)
    println(result3)
}