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

  /**
    */
}