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

  /** EXERCISE 5.12
    *
    * unfoldを使ってfibs、from、constant、onesを記述せよ。
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

  //   def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
  //     case None         => Empty
  //     case Some((a, s)) => Stream.cons(a, unfold(s)(f))
  //   }

  //   // EXERCISE 5.12
  //   def fibs: Stream[Int] = {
  //     def go(x: Int, y: Int): Stream[Int] = ???
  //     go(0, 1)
  //   }

  //   def from(n: Int): Stream[Int] = unfold(n)(x => Some(x, x + 1))

  //   def constant[A](a: A): Stream[A] = unfold(a)(x => Some(x, x))

  //   def ones: Stream[Int] = unfold(1)(x => Some(x, x))
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
  //   println(Empty.from(1).take(5).toList) // List(1, 2, 3, 4, 5)
  //   println(Empty.constant(1).take(5).toList) // List(1, 1, 1, 1, 1)
  //   println(Empty.constant('a').take(5).toList) // List(a, a, a, a, a)
  //   println(Empty.ones.take(5).toList) // List(1, 1, 1, 1, 1)
  // }
  // fibsは不正解、正解は以下
  // def fibs: Stream[Int] = unfold((0, 1))(x => Some(x._1, (x._2, x._1 + x._2)))
  // fromは正解
  // constantは正解だが、以下の方が良い
  // def constant[A](a: A): Stream[A] = unfold(())(_ => Some(a, ()))
  // onesは正解だが、以下の方が良い
  // def ones: Stream[Int] = unfold(())(_ => Some(1, ()))

  /** EXERCISE 5.13
    *
    * unfoldを使って（第3章で示したような）map、take、takeWhile、zipWith、zipAllを実装せよ。
    * zipAll関数では、どちらかのストリームに要素が残っている限り、評価を続ける必要がある。
    * この関数はストリームが完全に評価されたかどうかを示すのにOptionを使用する。
    *
    * def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])]
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
  //     case None         => Empty
  //     case Some((a, s)) => Stream.cons(a, unfold(s)(f))
  //   }

  //   // EXERCISE 5.13
  //   def map[B](f: A => B): Stream[B] = unfold(this)(s =>
  //     s match {
  //       case Empty      => None
  //       case Cons(h, t) => Some(f(h()), t())
  //     }
  //   )

  //   def take(n: Int): Stream[A] = unfold(this)(s =>
  //     s match {
  //       case Cons(h, t) if n != 0 => Some(h(), t().take(n - 1))
  //       case _                    => None
  //     }
  //   )

  //   def takeWhile(f: A => Boolean): Stream[A] = unfold(this)(s =>
  //     s match {
  //       case Cons(h, t) if f(h()) => Some(h(), t())
  //       case _                    => None
  //     }
  //   )

  //   def zipWith[B, C](s2: Stream[B])(f: (A, B) => C): Stream[C] = unfold(this)(s =>
  //     (s, s2) match {
  //       case (Cons(h, t), Cons(h2, t2)) => Some((f(h(), h2()), t()))
  //       case _                          => None
  //     }
  //   )

  //   def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = unfold(this)(s =>
  //     (s, s2) match {
  //       case (Cons(h, t), Cons(h2, t2)) => Some(((Some(h()), Some(h2())), t().zipAll(t2())))
  //       case _                          => None
  //     }
  //   )
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
  //   println(Stream(1, 2, 3).map(x => x * 2).toList) // List(2, 4, 6)
  //   println(Empty.map((x: Int) => x * 2)) // Empty
  //   println(Stream(1, 2, 3).take(2).toList) // List(1, 2)
  //   println(Stream(1, 2, 3).take(0)) // Empty
  //   println(Stream(1, 2, 3).take(4).toList) // List(1, 2, 3)
  //   println(Empty.take(1)) // Empty
  //   println(Stream(2, 4, 5).takeWhile(_ % 2 == 0).toList) // List(2, 4)
  //   println(Stream(1, 2, 3, 4).takeWhile(_ % 2 == 0)) // Empty
  //   println(Stream(1, 2, 3, 4).takeWhile(_ % 5 == 0)) // Empty
  //   println(Empty.takeWhile((x: Int) => x % 2 == 0)) // Empty
  //   println(Stream(1, 2, 3).zipWith(Stream(4, 5, 6))((x, y) => x * y).toList) // List(4, 10, 18)
  //   println(Stream(1, 3).zipWith(Stream(1))(((x, y) => x + y)).toList) // List(2)
  //   println(Stream(1).zipWith(Stream(1, 3))((x, y) => x + y).toList) // List(2)
  //   println(Empty.zipWith(Empty)((x: Int, y: Int) => x + y)) // Empty
  //   println(
  //     Stream(1, 2, 3).zipAll(Stream(4, 5, 6)).toList
  //   ) // List((Some(1),Some(4)), (Some(2),Some(5)), (Some(3),Some(6)))
  //   println(Stream(1, 2).zipAll(Stream(4, 5, 6)).toList) // List((Some(1),Some(4)), (Some(2),Some(5)), (None,Some(6)))
  //   println(Stream(1, 2, 3).zipAll(Stream(4, 5)).toList) // List((Some(1),Some(4)), (Some(2),Some(5)), (Some(3),None))
  //   println(Empty.zipAll(Stream(4, 5, 6)).toList) // List((None,Some(4)), (None,Some(5)), (None,Some(6)))
  //   println(Stream(1, 2, 3).zipAll(Empty).toList) // List((Some(1),None), (Some(2),None), (Some(3),None))
  //   println(Empty.zipAll(Empty)) // Empty
  // }
  // map、take、takeWhileは正解
  // zipWithは不正解、正解は以下
  // def zipWith[B, C](s2: Stream[B])(f: (A, B) => C): Stream[C] = unfold((this, s2))({
  //   case (Cons(h, t), Cons(h2, t2)) => Some(f(h(), h2()), (t(), t2()))
  //   case _                          => None
  // })
  // zipAllは不正解、正解は以下
  // def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = unfold((this, s2)) {
  //   case (Empty, Empty)             => None
  //   case (Cons(h, t), Empty)        => Some(((Some(h()), None), (t(), Empty)))
  //   case (Empty, Cons(h, t))        => Some(((None, Some(h())), (Empty, t())))
  //   case (Cons(h, t), Cons(h2, t2)) => Some(((Some(h()), Some(h2())), (t(), t2())))
  // }

  /** EXERCISE 5.14
    *
    * ここまで記述してきた関数を使ってstartsWithを実装せよ。
    * この関数は、あるStreamが別のStreamのプレフィックス（接頭辞）であるかどうかを調べる。
    * たとえば、`Stream(1,2,3) startsWith Stream(1,2)`の結果はtrueになる。
    *
    * def startsWith[A](s: Stream[A]): Boolean
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
  //     case None         => Empty
  //     case Some((a, s)) => Stream.cons(a, unfold(s)(f))
  //   }

  //   def takeWhile(f: A => Boolean): Stream[A] = unfold(this)(s =>
  //     s match {
  //       case Cons(h, t) if f(h()) => Some(h(), t())
  //       case _                    => None
  //     }
  //   )

  //   def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = unfold((this, s2)) {
  //     case (Empty, Empty)             => None
  //     case (Cons(h, t), Empty)        => Some(((Some(h()), None), (t(), Empty)))
  //     case (Empty, Cons(h, t))        => Some(((None, Some(h())), (Empty, t())))
  //     case (Cons(h, t), Cons(h2, t2)) => Some(((Some(h()), Some(h2())), (t(), t2())))
  //   }

  //   def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
  //     case Cons(h, t) => f(h(), t().foldRight(z)(f))
  //     case _          => z
  //   }

  //   def forAll(p: A => Boolean): Boolean =
  //     foldRight(true)((a, b) => p(a) && b)

  //   // EXERCISE 5.14
  //   def startsWith[A](s: Stream[A]): Boolean = ???
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
  //   println(Stream(1, 2, 3, 4).startsWith(Stream(1, 2))) // true
  //   println(Stream(1, 2, 3, 4).startsWith(Stream(2, 3))) // false
  //   println(Stream(1, 2, 3, 4).startsWith(Stream(1, 3))) // false
  //   println(Stream(1, 2, 3, 4).startsWith(Stream(1))) // true
  //   println(Stream(1).startsWith(Stream(1, 2))) // false
  //   println(Stream(1).startsWith(Stream(1))) // true
  //   println(Empty.startsWith(Stream(1))) // false
  //   println(Stream(1).startsWith(Empty)) // true
  // }
  // 不正解、正解は以下
  // def startsWith[A](s: Stream[A]): Boolean =
  //   this
  //     .zipAll(s)
  //     .takeWhile(!_._2.isEmpty)
  //     .forAll({ case (h, h2) =>
  //       h == h2
  //     })
  // takeWhileでzipAllの結果からタプルの2番目の要素がNone以外を抽出する
  // forAllですべてのタプルの要素が等しければtrueになる

  /**  EXERCISE 5.15
    *
    * unfoldを使ってtailsを実装せよ。
    * 与えられたStreamに対し、tailsは元のStreamから始まる入力シーケンスのサフィックス（接尾辞）であるStreamを返す。
    * たとえば`Stream(1,2,3)`が与えられた場合は、`Stream(Stream(1,2,3),Stream(2,3),Stream(3),Stream())`を返す。
    *
    * def tails: Stream[Stream[A]]
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def toList: List[A] = this match {
  //     case Empty      => Nil
  //     case Cons(h, t) => h() :: t().toList
  //   }

  //   def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
  //     case None         => Empty
  //     case Some((a, s)) => Stream.cons(a, unfold(s)(f))
  //   }

  //   def map[B](f: A => B): Stream[B] = unfold(this)(s =>
  //     s match {
  //       case Empty      => None
  //       case Cons(h, t) => Some(f(h()), t())
  //     }
  //   )

  //   def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
  //     case Cons(h, t) => f(h(), t().foldRight(z)(f))
  //     case _          => z
  //   }

  //   def append[B >: A](s: => Stream[B]): Stream[B] =
  //     foldRight(s)((a, b) => Stream.cons(a, b))

  //   // EXERCISE 5.15
  //   def tails: Stream[Stream[A]] = unfold(this)({
  //     case Cons(h, t) => Some((Stream.cons(h(), t()), t()))
  //     case Empty      => None
  //   })
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
  //   println(Stream(1, 2, 3).tails.map(_.toList).toList) // List(List(1, 2, 3), List(2, 3), List(3), List())
  //   println(Empty.tails.toList) // List(Empty)
  // }
  // 不正解、最後のStream()は単純にappendすれば良かった
  // def tails: Stream[Stream[A]] = unfold(this)({
  //   case Cons(h, t) => Some((Stream.cons(h(), t()), t()))
  //   case Empty      => None
  // }).append(Stream(Empty))

  /** hasSubsequenceは、これまでに記述した関数を使って実装できる
    */
  // case object Empty extends Stream[Nothing]
  // case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  // trait Stream[+A] {
  //   def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
  //     case None         => Empty
  //     case Some((a, s)) => Stream.cons(a, unfold(s)(f))
  //   }

  //   def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
  //     case Cons(h, t) => f(h(), t().foldRight(z)(f))
  //     case _          => z
  //   }

  //   def append[B >: A](s: => Stream[B]): Stream[B] =
  //     foldRight(s)((a, b) => Stream.cons(a, b))

  //   def tails: Stream[Stream[A]] = unfold(this)({
  //     case Cons(h, t) => Some((Stream.cons(h(), t()), t()))
  //     case Empty      => None
  //   }).append(Stream(Empty))

  //   def exists(p: A => Boolean): Boolean =
  //     foldRight(false)((a, b) => p(a) || b)

  //   def takeWhile(f: A => Boolean): Stream[A] = unfold(this)(s =>
  //     s match {
  //       case Cons(h, t) if f(h()) => Some(h(), t())
  //       case _                    => None
  //     }
  //   )

  //   def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = unfold((this, s2)) {
  //     case (Empty, Empty)             => None
  //     case (Cons(h, t), Empty)        => Some(((Some(h()), None), (t(), Empty)))
  //     case (Empty, Cons(h, t))        => Some(((None, Some(h())), (Empty, t())))
  //     case (Cons(h, t), Cons(h2, t2)) => Some(((Some(h()), Some(h2())), (t(), t2())))
  //   }

  //   def forAll(p: A => Boolean): Boolean =
  //     foldRight(true)((a, b) => p(a) && b)

  //   def startsWith[A](s: Stream[A]): Boolean =
  //     this
  //       .zipAll(s)
  //       .takeWhile(!_._2.isEmpty)
  //       .forAll({ case (h, h2) =>
  //         h == h2
  //       })

  //   def hasSubsequence[A](s: Stream[A]): Boolean = tails exists (_ startsWith s)
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
  //   println(Stream(1, 2, 3, 4).hasSubsequence(Stream(1, 2))) // true
  //   println(Stream(1, 2, 3, 4).hasSubsequence(Stream(2, 3))) // true
  //   println(Stream(1, 2, 3, 4).hasSubsequence(Stream(1, 3))) // false
  //   println(Stream(1, 2, 3, 4).hasSubsequence(Stream(2, 4))) // false
  //   println(Stream(1, 2, 3, 4).hasSubsequence(Stream(4))) // true
  //   println(Stream(1).hasSubsequence(Stream(1, 2))) // false
  //   println(Stream(1).hasSubsequence(Stream(1))) // true
  //   println(Empty.hasSubsequence(Stream(1))) // false
  //   println(Stream(1).hasSubsequence(Empty)) // true
  // }

  /** EXERCISE 5.16
    *
    * tailsをscanRight関数として一般化せよ。
    * foldRightと同様に、この関数は中間結果のストリームを返す。
    *
    * Stream(1,2,3).scanRight(0)(_ + _).toList // List(6,5,3,0)
    *
    * この例は式`List(1+2+3+0,2+3+0,3+0,0)`と同じ意味になるはずである。
    * scanRight関数では、中間結果を再利用することで、n個の要素を持つStreamの評価にかかる時間が常にnに対して線型になるようにすべきである。
    * この実装にunfoldを使用することは可能か。
    * その場合はどのようになるか、あるいは、実装できないのであればそれはなぜか。
    * すでに記述した別の関数を使って実装することは可能か。
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

  //   // EXERCISE 5.16
  //   def scanRight[B](z: B)(f: (A, => B) => B): Stream[B] = ???
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
  //   println(Stream(1, 2, 3, 4).scanRight(0)(_ + _).toList) // List(10, 9, 7, 4, 0)
  //   println(Stream(1, 2, 3, 4).scanRight(3)(_ + _).toList) // List(13, 12, 10, 7, 3)
  //   println(Stream(1).scanRight(0)(_ + _).toList) // List(1, 0)
  //   println((Empty: Stream[Int]).scanRight(0)(_ + _).toList) // List(0)
  // }
  // 不正解、正解は以下
  // def scanRight[B](z: B)(f: (A, => B) => B): Stream[B] =
  //   foldRight((z, Stream(z)))((a, b) => {
  //     lazy val b2 = b
  //     val b3 = f(a, b2._1)
  //     (b3, Stream.cons(b3, b2._2))
  //   })._2
  // unfoldはStreamを左から右に生成するため、使えない
}
