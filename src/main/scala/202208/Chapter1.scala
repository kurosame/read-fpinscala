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

  /** EXERCISE 2.2
    *
    * 指定された比較関数に従ってArray[A]がソートされているかどうかを調べるisSortedを実装せよ。
    *
    * def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean
    */
  // def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
  //   if (as.length <= 1) return true

  //   @annotation.tailrec
  //   def go(i: Int): Boolean =
  //     if (ordered(as(i), as(i + 1))) false
  //     else if (as.length == i + 2) true
  //     else go(i + 1)
  //   go(0)
  // }

  // def main(args: Array[String]): Unit = {
  //   println(isSorted[Int](Array(1, 2, 3, 4, 5), (x, y) => x > y)) // true
  //   println(isSorted[Int](Array(2, 1, 3, 4, 5), (x, y) => x > y)) // false
  //   println(isSorted[Int](Array(2, 1, 3, 5, 4), (x, y) => x > y)) // false
  //   println(isSorted[Int](Array(1, 2, 2, 4, 5), (x, y) => x > y)) // true
  //   println(isSorted[Int](Array(1), (x, y) => x > y)) // true
  //   println(isSorted[Int](Array(1, 2), (x, y) => x > y)) // true
  //   println(isSorted[Int](Array(2, 1), (x, y) => x > y)) // false
  // }
  // 正解
  // ただし、GitHubの模範の方が良い実装
  // def isSortedAnswer[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
  //   @annotation.tailrec
  //   def go(n: Int): Boolean =
  //     if (n >= as.length - 1) true
  //     else if (gt(as(n), as(n + 1))) false
  //     else go(n + 1)

  //   go(0)
  // }

  /**
    */
}
