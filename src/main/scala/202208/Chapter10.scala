package `202208`

object Chapter10 {
  // trait Monoid[A] {
  //   // `op(op(x, y), z) == op(x, op(y, z))`を満たす
  //   def op(a1: A, a2: A): A

  //   // `op(x, zero) == x`および`op(zero, x) == x`を満たす
  //   def zero: A
  // }

  // val stringMonoid = new Monoid[String] {
  //   def op(a1: String, a2: String) = a1 + a2
  //   val zero = ""
  // }
  // def listMonoid[A] = new Monoid[List[A]] {
  //   def op(a1: List[A], a2: List[A]) = a1 ++ a2
  //   val zero = Nil
  // }

  /** EXERCISE 10.1
    *
    * 整数の加算と乗算、および論理演算子に対するMonoidインスタンスを考え出せ。
    *
    * val intAddition: Monoid[Int]
    * val intMultiplication: Monoid[Int]
    * val booleanOr: Monoid[Boolean]
    * val booleanAnd: Monoid[Boolean]
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // val intAddition: Monoid[Int] = new Monoid[Int] {
  //   def op(a1: Int, a2: Int): Int = a1 + a1
  //   val zero = 0
  // }

  // val intMultiplication: Monoid[Int] = new Monoid[Int] {
  //   def op(a1: Int, a2: Int): Int = a1 * a2
  //   val zero = 1
  // }

  // val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
  //   def op(a1: Boolean, a2: Boolean): Boolean = a1 || a2
  //   val zero = false
  // }

  // val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
  //   def op(a1: Boolean, a2: Boolean): Boolean = a1 && a2
  //   val zero = true
  // }
  // 正解

  /** EXERCISE 10.2
    *
    * Option型の値を結合するためのMonoidインスタンスを考え出せ。
    *
    * def optionMonoid[A]: Monoid[Option[A]]
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Option[A]] {
  //   def op(a1: Option[A], a2: Option[A]): Option[A] = a1.orElse(a2)
  //   def zero: Option[A] = None
  // }
  // 正解

  /** EXERCISE 10.3
    *
    * 引数および戻り値の型が同じである関数をendo関数（endofunction）と呼ぶことがある。
    * endo関数のモノイドを記述せよ。
    *
    * def endoMonoid[A]: Monoid[A => A]
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
  //   def op(a1: A => A, a2: A => A): A => A = a1.compose(a2)
  //   def zero: A => A = a => a
  // }
  // 正解

  /** EXERCISE 10.4
    *
    * PartⅡで作成したプロパティベースのテストフレームを使ってモノイド則のプロパティを実装せよ。
    * これまでに記述したモノイドを、このプロパティを使ってテストせよ。
    *
    * def monoidLaws[A](m: Monoid[A], gen: Gen[A]): Prop
    */

  // // 以下はfoldRightとfoldLeftの定義
  // def foldRight[B](z: B)(f: (A, B) => B): B
  // def foldLeft[B](z: B)(f: (B, A) => B): B

  // // AとBが同じ型だと仮定すると、以下になる
  // def foldRight(z: A)(f: (A, A) => A): A
  // def foldLeft(z: A)(f: (A, A) => A): A

  // // よって、AがString型だとすると、stringMonoidのopとzeroを渡せばよい
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // val stringMonoid = new Monoid[String] {
  //   def op(a1: String, a2: String) = a1 + a2
  //   val zero = ""
  // }

  // val words = List("Hic", "Est", "Index")
  // val s = words.foldRight(stringMonoid.zero)(stringMonoid.op)

  /** EXERCISE 10.5
    *
    * foldMapを実装せよ。
    *
    * def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // // EXERCISE 10.5
  // def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B =
  //   as.foldLeft(m.zero)(m.op)

  // // 不正解、正解は以下
  // // def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B =
  // //   as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))

  /** EXERCISE 10.6
    *
    * foldMap関数はfoldLeftまたはfoldRightを使って実装できる。
    * ただし、foldMapを使ってfoldLeftとfoldRightを記述することも可能である。
    * これを試せ。
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B =
  //   as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))

  // def dual[A](m: Monoid[A]): Monoid[A] = new Monoid[A] {
  //   def op(x: A, y: A): A = m.op(y, x)
  //   val zero = m.zero
  // }

  // def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
  //   def op(a1: A => A, a2: A => A) = a1.compose(a2)
  //   val zero = a3 => a3
  // }

  // // EXERCISE 10.6
  // def foldRight[B](z: B)(f: (A, B) => B): B = ???
  // def foldLeft[B](z: B)(f: (B, A) => B): B = ???

  // // 不正解、正解は以下
  // def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B =
  //   foldMap(as, dual(endoMonoid[B]))(a => b => f(b, a))(z)

  // def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B =
  //   foldMap(as, endoMonoid[B])(f.curried)(z)

  /**
    */
}
