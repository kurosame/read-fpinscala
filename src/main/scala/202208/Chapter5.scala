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

  /** EXERCISE 5.6
    *
    * foldRightを使ってheadOptionを実装せよ。
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
  //     case Cons(h, t) => f(h(), t().foldRight(z)(f))
  //     case _          => z
  //   }

  //   // EXERCISE 5.6
  //   def headOption: Option[A] =
  //     foldRight(None: Option[A])((a, _) => Some(a))
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
  //   println(Stream(1, 2, 3, 4).headOption) // Some(1)
  //   println(Stream().headOption) // None
  //   println(Empty.headOption) // None
  // }
  // 正解

  /** EXERCISE 5.7
    *
    * foldRightを使ってmap、filter、append、flatMapを実装せよ。
    * appendメソッドはその引数に関して非正格でなければならない。
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

  //   // EXERCISE 5.7
  //   def map[B](f: A => B): Stream[B] =
  //     foldRight(Empty: Stream[B])((a, b) => Stream.cons(f(a), b))

  //   def filter(f: A => Boolean): Stream[A] =
  //     foldRight(Empty: Stream[A])((a, b) => if (f(a)) Stream.cons(a, b) else b.filter(f))

  //   def append[B >: A](s: => Stream[B]): Stream[B] =
  //     foldRight(s)((a, b) => Stream.cons(a, b))

  //   def flatMap[B](f: A => Stream[B]): Stream[B] =
  //     foldRight(Empty: Stream[B])((a, b) => f(a).append(b))
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
  //   println(Stream(1, 2, 3, 4).map(a => a + 1).toList) // List(2, 3, 4, 5)
  //   println(Empty.map((a: Int) => a + 1)) // Empty
  //   println(Stream(1, 2, 3, 4).filter(x => x > 2).toList) // List(3, 4)
  //   println(Stream(1, 2, 3, 4).filter(x => x > 5)) // Empty
  //   println(Empty.filter((x: Int) => x > 2)) // Empty
  //   println(Stream(1, 2, 3, 4).append(Stream(5, 6)).toList) // List(1, 2, 3, 4, 5, 6)
  //   println(Stream(1, 2, 3, 4).append(Empty).toList) // List(1, 2, 3, 4)
  //   println((Empty: Stream[Int]).append(Stream(5, 6)).toList) // List(5, 6)
  //   println(Stream(1, 2, 3, 4).flatMap((x: Int) => Stream(x + 1)).toList) // List(2, 3, 4, 5)
  //   println(Stream(1, 2, 3, 4).flatMap(_ => Stream.empty)) // Empty
  //   println(Empty.flatMap((x: Int) => Stream(x + 1))) // Empty
  // }
  // 正解
  // filterは答えは合っているが、以下が良い
  // def filter(f: A => Boolean): Stream[A] =
  //   foldRight(Empty: Stream[A])((a, b) => if (f(a)) Stream.cons(a, b) else b)

  /** EXERCISE 5.8
    *
    * onesを少し一般化し、指定された値の無限ストリームを返すconstant関数を記述せよ。
    *
    * def constant[A](a: A): Stream[A]
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def take(n: Int): Stream[A] = (this, n) match {
  //     case (Empty, _)      => Empty
  //     case (_, 0)          => Empty
  //     case (Cons(h, t), _) => Stream.cons(h(), t().take(n - 1))
  //   }

  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   // EXERCISE 5.8
  //   def constant[A](a: A): Stream[A] = Stream.cons(a, constant(a))
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
  //   println(Empty.constant(1).take(5).toList) // List(1, 1, 1, 1, 1)
  //   println(Empty.constant('a').take(5).toList) // List(a, a, a, a, a)
  // }
  // 正解

  /** EXERCISE 5.9
    *
    * nで始まってn + 1、n + 2と続く整数の無限ストリームを生成する関数を記述せよ。
    *
    * def from(n: Int): Stream[Int]
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def take(n: Int): Stream[A] = (this, n) match {
  //     case (Empty, _)      => Empty
  //     case (_, 0)          => Empty
  //     case (Cons(h, t), _) => Stream.cons(h(), t().take(n - 1))
  //   }

  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   // EXERCISE 5.9
  //   def from(n: Int): Stream[Int] = Stream.cons(n, from(n + 1))
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
  //   println(Empty.from(1).take(5).toList) // List(1, 2, 3, 4, 5)
  // }
  // 正解

  /** EXERCISE 5.10
    *
    * フィボナッチ数列（0、1、1、2、3、5、8、...）の無限ストリームを生成するfibs関数を記述せよ。
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def take(n: Int): Stream[A] = (this, n) match {
  //     case (Empty, _)      => Empty
  //     case (_, 0)          => Empty
  //     case (Cons(h, t), _) => Stream.cons(h(), t().take(n - 1))
  //   }

  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   // EXERCISE 5.10
  //   def fibs: Stream[Int] = {
  //     def go(x: Int, y: Int): Stream[Int] = Stream.cons(x, go(y, x + y))
  //     go(0, 1)
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
  //   println(Empty.fibs.take(8).toList) // List(0, 1, 1, 2, 3, 5, 8, 13)
  // }
  // 正解

  /** EXERCISE 5.11
    *
    * より汎用的なストリーム生成関数unfoldを記述せよ。
    * この関数は、初期状態に加えて、以下の状態と、生成されるストリームの次の値を生成する関数を受け取る。
    *
    * def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A]
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def take(n: Int): Stream[A] = (this, n) match {
  //     case (Empty, _)      => Empty
  //     case (_, 0)          => Empty
  //     case (Cons(h, t), _) => Stream.cons(h(), t().take(n - 1))
  //   }

  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   // EXERCISE 5.11
  //   def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
  //     case None         => Empty
  //     case Some((a, s)) => Stream.cons(a, unfold(s)(f))
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
  //   println(Empty.unfold(1)(s => Some(s, s + 1)).take(5).toList) // List(1, 2, 3, 4, 5)
  //   println(Empty.unfold(1)(_ => None).take(5).toList) // List()
  //   println(Empty.unfold(1)(s => if (s > 5) None else Some(s, s + 1)).toList) // List(1, 2, 3, 4, 5)
  // }
  // 正解

  /**
    */
}
