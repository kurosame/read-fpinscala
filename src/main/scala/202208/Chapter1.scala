package `202208`

object Chapter1 {

  /** EXERCISE 2.1
    *
    * n番目のフィボナッチ数を取得する再帰関数を記述せよ。
    * 最初の2つのフィボナッチ数は0と1である。
    * n番目の数字は常に前の2つの数字の合計となる。
    * この数列は0、1、1、2、3、5のように始まる。
    * 再帰関数の定義では、ローカルな末尾再帰関数を使用すること。
    *
    * def fib(n: Int): Int
    */
  // def fib(n: Int): Int = {
  //   @annotation.tailrec
  //   def go(x: Int, y: Int, n: Int): Int =
  //     if (n <= 1) x
  //     else go(y, x + y, n - 1)
  //   go(0, 1, n)
  // }

  // def main(args: Array[String]): Unit = {
  //   println(fib(1)) // 0
  //   println(fib(2)) // 1
  //   println(fib(3)) // 1
  //   println(fib(4)) // 2
  //   println(fib(5)) // 3
  //   println(fib(6)) // 5
  //   println(fib(7)) // 8
  // }
  // 正解
}
