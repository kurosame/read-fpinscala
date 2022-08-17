package `202208`

object Chapter3 {

  /** EXERCISE 3.1
    *
    * 以下のマッチ式`x`はどのような結果になるか。
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def sum(ints: List[Int]): Int = ints match {
  //     case Nil         => 0
  //     case Cons(x, xs) => x + sum(xs)
  //   }
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))
  // }

  // val x = List(1, 2, 3, 4, 5) match {
  //   case Cons(x, Cons(2, Cons(4, _)))          => x
  //   case Nil                                   => 42
  //   case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  //   case Cons(h, t)                            => h + List.sum(t)
  //   case _                                     => 101
  // }
  // 3
  // 正解
  // def main(args: Array[String]): Unit = {
  //   println(x) // 3
  // }

  /** EXERCISE 3.2
    *
    * Listの最初の要素を削除する関数tailを実装せよ。
    * この関数の実行時間が一定であることに注意。
    * ListがNilである場合、実装上の選択肢として他に何があるか。
    * この質問については、次章で再び取り上げる。
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.2
  //   def tail[A](l: List[A]) = l match {
  //     case Nil        => Nil
  //     case Cons(h, t) => t
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.tail(List(1, 2, 3))) // Cons(2,Cons(3,Nil))
  //   println(List.tail(Nil)) // Nil
  //   println(List.tail(List(1))) // Nil
  // }
  // 正解

  /**
    */
}
