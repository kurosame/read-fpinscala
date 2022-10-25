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

  /** EXERCISE 5.2
    *
    * Streamの先頭からn個の要素を取り出す関数take(n)と、Streamの先頭からn個の要素をスキップするdrop(n)関数を記述せよ。
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   // EXERCISE 5.2
  //   def take(n: Int): Stream[A] = ???

  //   def drop(n: Int): Stream[A] = ???
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
  //   println(Stream(1, 2, 3, 4).take(2).toList) // List(1, 2)
  //   println(Stream(1, 2, 3, 4).take(0)) // Empty
  //   println(Stream(1, 2, 3, 4).take(5).toList) // List(1, 2, 3, 4)
  //   println(Empty.take(1)) // Empty
  //   println(Stream(1, 2, 3, 4).drop(2).toList) // List(3, 4)
  //   println(Stream(1, 2, 3, 4).drop(0).toList) // List(1, 2, 3, 4)
  //   println(Stream(1, 2, 3, 4).drop(5)) // Empty
  //   println(Empty.drop(1)) // Empty
  // }
  // 不正解
  // 正解は以下
  // def take(n: Int): Stream[A] = (this, n) match {
  //   case (Empty, _)      => Empty
  //   case (_, 0)          => Empty
  //   case (Cons(h, t), _) => Stream.cons(h(), t().take(n - 1))
  // }

  // def drop(n: Int): Stream[A] = (this, n) match {
  //   case (Empty, _)      => Empty
  //   case (_, 0)          => this
  //   case (Cons(_, t), _) => t().drop(n - 1)
  // }

  /** EXERCISE 5.3
    *
    * Streamの先頭から指定された述語とマッチする要素をすべて取り出すtakeWhile関数を記述せよ。
    *
    * def takeWhile(p: A => Boolean): Stream[A]
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   // EXERCISE 5.3
  //   def takeWhile(p: A => Boolean): Stream[A] = this match {
  //     case Cons(h, t) if (p(h())) => Stream.cons(h(), t().takeWhile(p))
  //     case _                      => Empty
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
  //   println(Stream(2, 4, 5).takeWhile(_ % 2 == 0).toList) // List(2, 4)
  //   println(Stream(1, 2, 3, 4).takeWhile(_ % 2 == 0)) // Empty
  //   println(Stream(1, 2, 3, 4).takeWhile(_ % 5 == 0)) // Empty
  //   println(Empty.takeWhile((x: Int) => x % 2 == 0)) // Empty
  // }
  // 正解

  // fの第2引数が非正格バージョンのfoldRight
  // Bを評価しないという選択が可能になる
  // def foldRight[B](z: => B)(f: (A, => B) => B) = this match {
  //   case Cons(h, t) => f(h(), t().foldRight(z)(f))
  //   case _          => z
  // }

  /** EXERCISE 5.4
    *
    * Streamの要素のうち、指定された述語とマッチするものをすべてチェックするforAllを実装せよ。
    * この実装では、マッチしない値が検出された時点でチェックを終了しなければならない。
    *
    * def forAll(p: A => Boolean): Boolean
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
  //     case Cons(h, t) => f(h(), t().foldRight(z)(f))
  //     case _          => z
  //   }

  //   // EXERCISE 5.4
  //   def forAll(p: A => Boolean): Boolean =
  //     foldRight(true)((a, b) => p(a) && b)
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
  //   println(Stream(1, 2, 3, 4).forAll(_ < 5)) // true
  //   println(Stream(1, 2, 3, 4).forAll(_ < 3)) // false
  // }
  // 正解

  /** EXERCISE 5.5
    *
    * foldRightを使ってtakeWhileを実装せよ。
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
  //     case Cons(h, t) => f(h(), t().foldRight(z)(f))
  //     case _          => z
  //   }

  //   // EXERCISE 5.5
  //   def takeWhile(p: A => Boolean): Stream[A] =
  //     foldRight(Empty: Stream[A])((a, b) => if (p(a)) Stream.cons(a, b) else Empty)
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
  //   println(Stream(2, 4, 5).takeWhile(_ % 2 == 0).toList) // List(2, 4)
  //   println(Stream(1, 2, 3, 4).takeWhile(_ % 2 == 0)) // Empty
  //   println(Stream(1, 2, 3, 4).takeWhile(_ % 5 == 0)) // Empty
  //   println(Empty.takeWhile((x: Int) => x % 2 == 0)) // Empty
  // }
  // 正解

  /**
    */
}
