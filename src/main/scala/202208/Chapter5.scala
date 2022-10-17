package `202208`

object Chapter5 {

  // trait Stream[+A]
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // object Stream {
  //   def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
  //     lazy val head = hd
  //     lazy val tail = tl
  //     Cons(() => head, () => tail)
  //   }

  //   def empty[A]: Stream[A] = Empty

  //   def apply[A](as: A*): Stream[A] =
  //     if (as.isEmpty) empty
  //     else cons(as.head, apply(as.tail: _*))
  // }

  /** EXERCISE 5.1
    *
    * StreamをListに変換し、それによりストリームを強制的に評価する関数を記述せよ。
    * 結果はREPLで確認できる。
    * 標準ライブラリの通常のList型への変換が可能である。
    * この関数と、Streamを操作する他の関数は、Streamトレイトの中に配置できる。
    *
    * def toList: List[A]
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   // EXERCISE 5.1
  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }
  // }

  // object Stream {
  //   def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
  //     lazy val head = hd
  //     lazy val tail = tl
  //     Cons(() => head, () => tail)
  //   }

  //   def empty[A]: Stream[A] = Empty

  //   def apply[A](as: A*): Stream[A] =
  //     if (as.isEmpty) empty
  //     else cons(as.head, apply(as.tail: _*))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(Stream(1, 2, 3, 4).toList) // List(1, 2, 3, 4)
  //   println(Stream().toList) // List()
  //   println(Empty.toList) // List()
  // }
  // 正解

  /**
    */
}
