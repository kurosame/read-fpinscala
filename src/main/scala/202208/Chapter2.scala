package `202208`

object Chapter2 {

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

  /** EXERCISE 2.3
    *
    * カリー化（currying）では、引数2つの関数fが、fを部分的に適用する引数1つの関数に変換される。
    * この場合も、コンパイルできる実装は1つだけである。
    * この実装を記述せよ。
    *
    * def curry[A, B, C](f: (A, B) => C): A => (B => C)
    */
  // def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)
  // 正解

  /** EXERCISE 2.4
    *
    * curryによる変換を逆向きに行うuncurryを実装せよ。
    * `=>`は右結合であるため、`A => (B => C)`は`A => B => C`と記述できる。
    *
    * def uncurry[A, B, C](f: A => B => C): (A, B) => C
    */
  // def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)
  // 正解

  /** EXERCISE 2.5
    *
    * 2つの関数を合成する高階関数を実装せよ。
    *
    * def compose[A, B, C](f: B => C, g: A => B): A => C
    */
  // def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
  // 正解
}
