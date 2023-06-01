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

  /** EXERCISE 10.7
    *
    * IndexedSeqのためのfoldMapを実装せよ。
    * シーケンスを半分に分割し、両半分を再帰的に処理した後、モノイドを使ってそれらの結果を結合すること。
    *
    * def foldMapV[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // def foldMapV[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B = {
  //   val vv = v.splitAt(v.length / 2)
  //   m.op(vv._1.foldLeft(m.zero)((b, a) => m.op(b, f(a))), vv._2.foldLeft(m.zero)((b, a) => m.op(b, f(a))))
  // }
  // // 不正解、正解は以下
  // // def foldMapV[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B =
  // //   if (v.length == 0)
  // //     m.zero
  // //   else if (v.length == 1)
  // //     f(v(0))
  // //   else {
  // //     val (l, r) = v.splitAt(v.length / 2)
  // //     m.op(foldMapV(l, m)(f), foldMapV(r, m)(f))
  // //   }

  /** EXERCISE 10.8
    *
    * 第7章で作成したライブラリを使って、並列化バージョンのfoldMapを実装せよ。
    *
    * ヒント：Monoid[A]をMonoid[Par[A]]に昇格させるコンビネータparを実装し、それを使ってparFoldMapを実装する。
    *
    * import fpinscala.parallelism.Nonblocking._
    *
    * def par[A](m: Monoid[A]): Monoid[Par[A]]
    * def parFoldMap[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): Par[B]
    */

  /** EXERCISE 10.9
    *
    * foldMapを使って特定のIndexedSeq[Int]が順序付けされているかどうかを割り出せ。
    * これについては、独創的なMonoidを考え出す必要があるだろう。
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // def foldMapV[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B =
  //   if (v.length == 0)
  //     m.zero
  //   else if (v.length == 1)
  //     f(v(0))
  //   else {
  //     val (l, r) = v.splitAt(v.length / 2)
  //     m.op(foldMapV(l, m)(f), foldMapV(r, m)(f))
  //   }

  // // **EXERCISE 10.9 [公式解]**
  // def ordered(ints: IndexedSeq[Int]): Boolean = {
  //   val mon = new Monoid[Option[(Int, Int, Boolean)]] {
  //     def op(o1: Option[(Int, Int, Boolean)], o2: Option[(Int, Int, Boolean)]) =
  //       (o1, o2) match {
  //         case (Some((x1, y1, p)), Some((x2, y2, q))) =>
  //           Some((x1 min x2, y1 max y2, p && q && y1 <= x2))
  //         case (x, None) => x
  //         case (None, x) => x
  //       }
  //     val zero = None
  //   }
  //   foldMapV(ints, mon)(i => Some((i, i, true))).map(_._3).getOrElse(true)
  // }
  // // **EXERCISE 10.9 [公式解]**

  // def main(args: Array[String]): Unit = {
  //   println(ordered(IndexedSeq(1, 2, 3, 4))) // true
  //   println(ordered(IndexedSeq(2, 1, 3, 4))) // false
  //   println(ordered(IndexedSeq(1, 2, 4, 3))) // false
  //   println(ordered(IndexedSeq(1))) // true
  // }

  // sealed trait WC

  // case class Stub(chars: String) extends WC
  // case class Part(lStub: String, words: Int, rStub: String) extends WC

  /** EXERCISE 10.10
    *
    * WCのモノイドインスタンスを作成し、そのインスタンスがモノイド則を満たすようにせよ。
    *
    * val wcMonoid: Monoid[WC]
    */
  // sealed trait WC

  // case class Stub(chars: String) extends WC
  // case class Part(lStub: String, words: Int, rStub: String) extends WC

  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // val wcMonoid: Monoid[WC] = new Monoid[WC] {
  //   def op(a1: WC, a2: WC): WC = (a1,a2) match {
  //     case
  //   }
  //   def zero: WC = Stub("")
  // }
  // // 正解は以下
  // // val wcMonoid: Monoid[WC] = new Monoid[WC] {
  // //   def op(a1: WC, a2: WC): WC = (a1, a2) match {
  // //     case (Stub(c), Stub(d))       => Stub(c + d)
  // //     case (Stub(c), Part(l, w, r)) => Part(c + l, w, r)
  // //     case (Part(l, w, r), Stub(c)) => Part(l, w, r + c)
  // //     case (Part(l1, w1, r1), Part(l2, w2, r2)) =>
  // //       Part(l1, w1 + (if ((r1 + l2).isEmpty) 0 else 1) + w2, r2)
  // //   }
  // //   def zero: WC = Stub("")
  // // }

  /**
    */
}
