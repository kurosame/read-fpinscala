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

  /** EXERCISE 3.3
    *
    * EXERCISE 3.2と同じ考え方に基づいて、Listの最初の要素を別の値と置き換えるsetHead関数を実装せよ。
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.3
  //   def setHead[A](l: List[A], x: A) = l match {
  //     case Nil        => Nil
  //     case Cons(h, t) => Cons(x, t)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.setHead(List(1, 2, 3), 4)) // Cons(4,Cons(2,Cons(3,Nil)))
  //   println(List.setHead(Nil, 4)) // Nil
  //   println(List.setHead(List(1), 4)) // Cons(4,Nil)
  // }
  // 正解

  /** EXERCISE 3.4
    *
    * tailを一般化して、リストの先頭からn個の要素を削除するdropという関数に置き換えよ。
    * この関数の実行時間は削除する要素の数にのみ比例することに注意。
    * List全体のコピーを作成する必要はない。
    *
    * def drop[A](l: List[A], n: Int): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.4
  //   def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
  //     case (_, 0)          => l
  //     case (Nil, _)        => Nil
  //     case (Cons(h, t), _) => drop(t, n - 1)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.drop(List(1, 2, 3), 1)) // Cons(2,Cons(3,Nil))
  //   println(List.drop(List(1, 2, 3), 2)) // Cons(3,Nil)
  //   println(List.drop(Nil, 1)) // Nil
  //   println(List.drop(List(1), 1)) // Nil
  // }
  // 正解

  /** EXERCISE 3.5
    *
    * 述語とマッチする場合に限り、Listからその要素までの要素を削除するdropWhileを実装せよ。
    *
    * def dropWhile[A](l: List[A], f: A => Boolean): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.5
  //   def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
  //     case Cons(h, t) if f(h) => dropWhile(t, f)
  //     case _                  => l
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.dropWhile(List(1, 2, 3), (x: Int) => x <= 1)) // Cons(2,Cons(3,Nil))
  //   println(List.dropWhile(List(1, 2, 3), (x: Int) => x <= 2)) // Cons(3,Nil)
  //   println(List.dropWhile(Nil, (x: Int) => x <= 1)) // Nil
  //   println(List.dropWhile(List(1), (x: Int) => x <= 1)) // Nil
  // }
  // 正解
  // ただし、GitHubの模範の方が良い実装
  // def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
  //   case Cons(h, t) if f(h) => dropWhile(t, f)
  //   case _                  => l
  // }

  /**
    */
}
