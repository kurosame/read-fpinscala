package `202208`

object Chapter4 {

  /** EXERCISE 4.1
    *
    * リスト4-4のすべての関数をOptionで実装せよ。
    * 各関数を実装するときに、その関数の意味と、それを使用するであろう状況について考えること。
    * どの関数をいつ使用するかについては、後ほど考察する。
    * この練習問題を解くためのヒントは以下のとおり。
    *
    * ・パターンマッチングを使用してもかまわないが、mapとgetOrElseを除く関数はすべてパターンマッチングに頼らなくても実装できるはずである。
    * ・mapとflatMapの実装は、型シグネチャの情報に基づいて十分に決定できるはずである。
    * ・getOrElseはOptionのSomeケースの結果を返す。
    *   OptionがNoneの場合は、指定されたデフォルト値を返す。
    * ・orElseは、1つ目のOptionが定義されている場合はそれを返し、そうでない場合は2つ目のOptionを返す。
    */
  // case class Some[+A](get: A) extends Option[A]
  // case object None extends Option[Nothing]

  // sealed trait Option[+A] {
  //   def map[B](f: A => B): Option[B] = this match {
  //     case Some(x) => Some(f(x))
  //     case None    => None
  //   }

  //   def flatMap[B](f: A => Option[B]): Option[B] = this match {
  //     case Some(x) => f(x)
  //     case None    => None
  //   }

  //   def getOrElse[B >: A](default: => B): B = this match {
  //     case Some(x) => x
  //     case None    => default
  //   }

  //   def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
  //     case Some(x) => Some(x)
  //     case None    => ob
  //   }

  //   def filter(f: A => Boolean): Option[A] = this match {
  //     case Some(x) if f(x) => Some(x)
  //     case _               => None
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(Some(123).map((x: Int) => x + 1)) // Some(124)
  //   println(None.map((x: Int) => x + 1)) // None
  //   println(Some(123).flatMap((x: Int) => Some(x + 1))) // Some(124)
  //   println(Some(123).flatMap(_ => None)) // None
  //   println(None.flatMap((x: Int) => Some(x + 1))) // None
  //   println(Some(123).getOrElse("Default")) // 123
  //   println(None.getOrElse("Default")) // Default
  //   println(Some(123).orElse(Some(321))) // Some(123)
  //   println(None.orElse(Some(321))) // Some(321)
  //   println(Some(123).filter(x => x == 123)) // Some(123)
  //   println(Some(123).filter(x => x == 124)) // None
  //   println(None.filter(x => x == 123)) // None
  // }
  // 正解
  // flatMap、orElse、filterのパターンマッチングを使わない実装は以下
  // def flatMap[B](f: A => Option[B]): Option[B] = map(f).getOrElse(None)
  // def orElse[B >: A](ob: => Option[B]): Option[B] = map(Some(_)).getOrElse(ob)
  // def filter(f: A => Boolean): Option[A] = flatMap(x => if (f(x)) Some(x) else None)

  /** EXERCISE 4.2
    *
    * flatMapをベースとしてvariance関数を実装せよ。
    * シーケンスの平均をm、シーケンスの各要素をxとすれば、分散は`math.pow(x - m, 2)`の平均となる。
    */
  // case class Some[+A](get: A) extends Option[A]
  // case object None extends Option[Nothing]

  // sealed trait Option[+A] {
  //   def map[B](f: A => B): Option[B] = this match {
  //     case Some(x) => Some(f(x))
  //     case None    => None
  //   }

  //   def getOrElse[B >: A](default: => B): B = this match {
  //     case Some(x) => x
  //     case None    => default
  //   }

  //   def flatMap[B](f: A => Option[B]): Option[B] = map(f).getOrElse(None)

  //   // EXERCISE 4.2
  //   def variance(xs: Seq[Double]): Option[Double] = {
  //     val m = xs.sum / xs.length
  //     val r = xs.map(x => math.pow(x - m, 2)).sum / xs.length
  //     Some(r)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(Some().variance(Seq(50, 60, 70, 70, 100))) // Some(280.0)
  //   println(Some().variance(Seq())) // Some(0.0)
  //   println(None.variance(Seq())) // None
  // }
  // 不正解（答えは合ってるけど）
  // 正解は以下
  // def mean(xs: Seq[Double]): Option[Double] =
  //   if (xs.isEmpty) None
  //   else Some(xs.sum / xs.length)

  // def variance(xs: Seq[Double]): Option[Double] = this.flatMap(_ =>
  //   xs match {
  //     case Nil => Some(0.0)
  //     case _   => mean(xs).flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))
  //   }
  // )

  /** EXERCISE 4.3
    *
    * 2項関数を使ってOption型の2つの値を結合する総称関数map2を記述せよ。
    * どちらかのOption値がNoneの場合は、戻り値もNoneになる。
    * シグネチャは以下のとおり。
    *
    * def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C]
    */
  // case class Some[+A](get: A) extends Option[A]
  // case object None extends Option[Nothing]

  // sealed trait Option[+A] {
  //   def map[B](f: A => B): Option[B] = this match {
  //     case Some(x) => Some(f(x))
  //     case None    => None
  //   }

  //   def getOrElse[B >: A](default: => B): B = this match {
  //     case Some(x) => x
  //     case None    => default
  //   }

  //   def flatMap[B](f: A => Option[B]): Option[B] = map(f).getOrElse(None)

  //   // EXERCISE 4.3
  //   def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  //     a.flatMap(x => b.map(y => f(x, y)))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(Some().map2(Some(1), Some(2))(((x, y) => x + y))) // Some(3)
  //   println(Some().map2(None, Some(2))((x: Int, y: Int) => x + y)) // None
  //   println(Some().map2(Some(1), None)((x: Int, y: Int) => x + y)) // None
  // }
  // 正解

  /** EXERCISE 4.4
    *
    * Optionのリストを1つのOptionにまとめるsequence関数を記述せよ。
    * 新しいOptionには、元のリストに含まれているすべてのSome値のリストが含まれる。
    * 元のリストにNoneが1つでも含まれていた場合、この関数の結果はNoneになる。
    * それ以外の場合は、すべての値のリストを含んだSomeになる。
    * シグネチャは以下のとおり。
    *
    * def sequence[A](a: List[Option[A]]): Option[List[A]]
    */
  // case class Some[+A](get: A) extends Option[A]
  // case object None extends Option[Nothing]

  // sealed trait Option[+A] {
  //   def map[B](f: A => B): Option[B] = this match {
  //     case Some(x) => Some(f(x))
  //     case None    => None
  //   }

  //   def getOrElse[B >: A](default: => B): B = this match {
  //     case Some(x) => x
  //     case None    => default
  //   }

  //   def flatMap[B](f: A => Option[B]): Option[B] = map(f).getOrElse(None)

  //   def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  //     a.flatMap(x => b.map(y => f(x, y)))
  // }

  // object Option {
  //   def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  //     a.flatMap(x => b.map(y => f(x, y)))

  //   // EXERCISE 4.4
  //   def sequence[A](a: List[Option[A]]): Option[List[A]] = ???
  // }

  // def main(args: Array[String]): Unit = {
  //   println(Option.sequence(List(Some(1), Some(2), Some(3)))) // Some(List(1, 2, 3))
  //   println(Option.sequence(List(Some(1), None, Some(3)))) // None
  // }
  // 不正解
  // 正解は以下
  // def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
  //   case Nil    => Some(Nil)
  //   case h :: t => h.flatMap(hh => sequence(t).map(hh :: _))
  // }
  // もしくは、以下
  // def sequence[A](a: List[Option[A]]): Option[List[A]] =
  //   a.foldRight[Option[List[A]]](Some(Nil))((a, acc) => map2(a, acc)(_ :: _))

  /** EXERCISE 4.5
    *
    * traverse関数を実装せよ。
    * mapとsequenceを使用すれば簡単だが、リストを1回だけ調べる、より効率のよい実装にすること。
    * 要するに、traverseの観点からsequenceを実装すればよい。
    *
    * def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]]
    */
  // case class Some[+A](get: A) extends Option[A]
  // case object None extends Option[Nothing]

  // sealed trait Option[+A] {
  //   def map[B](f: A => B): Option[B] = this match {
  //     case Some(x) => Some(f(x))
  //     case None    => None
  //   }

  //   def getOrElse[B >: A](default: => B): B = this match {
  //     case Some(x) => x
  //     case None    => default
  //   }

  //   def flatMap[B](f: A => Option[B]): Option[B] = map(f).getOrElse(None)
  // }

  // object Option {
  //   def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  //     a.flatMap(x => b.map(y => f(x, y)))

  //   def sequence[A](a: List[Option[A]]): Option[List[A]] =
  //     a.foldRight[Option[List[A]]](Some(Nil))((a, acc) => map2(a, acc)(_ :: _))

  //   // EXERCISE 4.5
  //   def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
  //     sequence(a.map(x => f(x)))
  // }

  // def main(args: Array[String]): Unit = {
  //   def Try[A](a: => A): Option[A] =
  //     try Some(a)
  //     catch { case e: Exception => None }

  //   println(Option.traverse(List("1", "2", "3"))(x => Try(x.toInt))) // Some(List(1, 2, 3))
  //   println(Option.traverse(List("1", "a", "3"))(x => Try(x.toInt))) // None
  //   println(Option.traverse(List())((x: String) => Try(x.toInt))) // Some(List())
  // }
  // 正解

  // sealed trait Either[+E, +A]
  // case class Left[+E](value: E) extends Either[E, Nothing]
  // case class Right[+A](value: A) extends Either[Nothing, A]

  /** EXERCISE 4.6
    *
    * Right値を操作するmap、flatMap、orElse、map2をEitherに追加せよ。
    *
    * trait Either[+E, +A] {
    *   def map[B](f: A => B): Either[E, B]
    *   def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B]
    *   def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B]
    *   def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C]
    * }
    */
  // case class Left[+E](value: E) extends Either[E, Nothing]
  // case class Right[+A](value: A) extends Either[Nothing, A]

  // trait Either[+E, +A] {
  //   def map[B](f: A => B): Either[E, B] = this match {
  //     case Left(x)  => Left(x)
  //     case Right(x) => Right(f(x))
  //   }

  //   def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
  //     case Left(x)  => Left(x)
  //     case Right(x) => f(x)
  //   }

  //   def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
  //     case Left(x)  => b
  //     case Right(x) => Right(x)
  //   }

  //   def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = (this, b) match {
  //     case (Left(x), _)         => Left(x)
  //     case (_, Left(x))         => Left(x)
  //     case (Right(x), Right(y)) => Right(f(x, y))
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(Left("error").map((x: Int) => x + 1)) // Left(error)
  //   println(Right(1).map((x: Int) => x + 1)) // Right(2)
  //   println(Left("error").flatMap((x: Int) => Right(x + 1))) // Left(error)
  //   println(Right(1).flatMap((x: Int) => Right(x + 1))) // Right(2)
  //   println(Right(1).flatMap(_ => Left("err"))) // Left(err)
  //   println(Left("error").orElse(Left("err"))) // Left(err)
  //   println(Right(1).orElse(Left("err"))) // Right(1)
  //   println(Right(1).map2(Right(2))((x: Int, y: Int) => x + y)) // Right(3)
  //   println(Left("error").map2(Right(2))((x: Int, y: Int) => x + y)) // Left(error)
  //   println(Right(1).map2(Left("error"))((x: Int, y: Int) => x + y)) // Left(error)
  // }
  // 正解
  // map2のパターンマッチングを使わない実装は以下
  // def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] =
  //   this.flatMap(x => b.map(y => f(x, y)))

  /** EXERCISE 4.7
    *
    * Eitherでsequenceとtraverseを実装せよ。
    * これらは、エラーが発生した場合に、最初に検出されたエラーを返すものとする。
    *
    * def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]]
    * def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]]
    */
  // case class Left[+E](value: E) extends Either[E, Nothing]
  // case class Right[+A](value: A) extends Either[Nothing, A]

  // trait Either[+E, +A] {
  //   def map[B](f: A => B): Either[E, B] = this match {
  //     case Left(x)  => Left(x)
  //     case Right(x) => Right(f(x))
  //   }

  //   def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
  //     case Left(x)  => Left(x)
  //     case Right(x) => f(x)
  //   }

  //   def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
  //     case Left(x)  => b
  //     case Right(x) => Right(x)
  //   }

  //   def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = (this, b) match {
  //     case (Left(x), _)         => Left(x)
  //     case (_, Left(x))         => Left(x)
  //     case (Right(x), Right(y)) => Right(f(x, y))
  //   }

  //   // EXERCISE 4.7
  //   def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] =
  //     es.foldRight[Either[E, List[A]]](Right(Nil))((x, y) => x.flatMap(xx => y :: x))

  //   def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
  //     sequence(as.map(f(_)))
  // }

  // def main(args: Array[String]): Unit = {
  //   def Try[A](a: => A): Either[Exception, A] =
  //     try Right(a)
  //     catch { case e: Exception => Left(e) }

  //   println(Right(1).sequence(List(Right(1), Right(2), Right(3)))) // Right(List(1, 2, 3))
  //   println(Right(1).sequence(List())) // Right(List())
  //   println(Right(1).sequence(List(Right(1), Left("error"), Right(3)))) // Left(error)
  //   println(Right(1).traverse(List("1", "2", "3"))(x => Try(x.toInt))) // Right(List(1, 2, 3))
  //   println(Right(1).traverse(List())((x: Int) => Try(x.toInt))) // Right(List())
  //   println(Right(1).traverse(List("1", "a", "3"))(x => Try(x.toInt))) // Left(NumberFormatException)  }
  // }
  // sequenceは不正解、traverseは正解
  // sequenceの正解は以下
  // def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = es match {
  //   case Nil    => Right(Nil)
  //   case h :: t => h.map2(sequence(t))(_ :: _)
  // }

  /**
    */
}
