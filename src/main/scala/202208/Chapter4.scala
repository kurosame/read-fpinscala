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

  /**
    */
}
