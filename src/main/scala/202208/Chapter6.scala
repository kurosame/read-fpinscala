package `202208`

object Chapter6 {

  /** EXERCISE 6.1
    *
    * RNG.nextIntを使って0〜Int.maxValue（0とInt.maxValueを含む）のランダムな整数を生成する関数を記述せよ。
    * なお、nextIntがInt.MinValueを返すときには、対応する自然数がない。
    * この特異なケースにも対処する必要がある。
    *
    * def nonNegativeInt(rng: RNG): (Int, RNG)
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   // EXERCISE 6.1
  //   def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //     val a = rng.nextInt
  //     val b = if (a._1 < 0) -a._1 else a._1
  //     (b, a._2)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(Int.MinValue)
  //   val (n1, rng2) = rng.nonNegativeInt(rng)
  //   println(n1) // 1932951551
  //   println(rng2) // SimpleRNG(154797063798795)
  //   val rng3 = SimpleRNG(Int.MaxValue)
  //   val (n2, rng4) = rng3.nonNegativeInt(rng3)
  //   println(n2) // 1932566803
  //   println(rng4) // SimpleRNG(126652698007966)
  // }
  // 不正解
  // 上記の実装だとnextIntがInt.MinValueを返した場合、Int.MaxValueの値を超えてしまう
  // よって、+1が必要
  // def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //   val (i, r) = rng.nextInt
  //   (if (i < 0) -(i + 1) else i, r)
  // }

  /** EXERCISE 6.2
    *
    * 0〜1（1を含まない）のDouble型の値を生成する関数を記述せよ。
    * Int.MaxValueを使って正の整数の最大値を取得できることと、`x.toDouble`を使って`x: Int`をDoubleに変換できることに注意。
    *
    * def double(rng: RNG): (Double, RNG)
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   // EXERCISE 6.2
  //   def double(rng: RNG): (Double, RNG) = {
  //     val (i, r) = rng.nextInt
  //     ((if (i < 0) -(i + 1) else i).toDouble / Int.MaxValue, r)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1000)
  //   val (n1, rng2) = rng.double(rng)
  //   println(n1) // 0.17916266806423664
  //   println(rng2) // SimpleRNG(25214903917011)
  //   val rng3 = SimpleRNG(-2000)
  //   val (n2, rng4) = rng3.double(rng3)
  //   println(n2) // 0.3583253361284733
  //   println(rng4) // SimpleRNG(231045168876667)
  // }
  // 正解だが以下の方が良い
  // def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //   val (i, r) = rng.nextInt
  //   (if (i < 0) Math.abs(i + 1) else i, r)
  // }

  // def double(rng: RNG): (Double, RNG) = {
  //   val (i, r) = nonNegativeInt(rng)
  //   (i / (Int.MaxValue.toDouble + 1), r)
  // }

  /** EXERCISE 6.3
    *
    * ペア（Int,Double）、ペア（Double,Int）、および3要素のタプル（Double,Double,Double）を生成する関数を記述せよ。
    * すでに作成済みの関数を再利用できるはずだ。
    *
    * def intDouble(rng: RNG): ((Int, Double), RNG)
    * def doubleInt(rng: RNG): ((Double, Int), RNG)
    * def double3(rng: RNG): ((Double, Double, Double), RNG)
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //     val (i, r) = rng.nextInt
  //     (if (i < 0) Math.abs(i + 1) else i, r)
  //   }

  //   def double(rng: RNG): (Double, RNG) = {
  //     val (i, r) = nonNegativeInt(rng)
  //     (i / (Int.MaxValue.toDouble + 1), r)
  //   }

  //   // EXERCISE 6.3
  //   def intDouble(rng: RNG): ((Int, Double), RNG) = {
  //     val (i, r) = nonNegativeInt(rng)
  //     ((i, i.toDouble), r)
  //   }

  //   def doubleInt(rng: RNG): ((Double, Int), RNG) = {
  //     val (i, r) = nonNegativeInt(rng)
  //     ((i.toDouble, i), r)
  //   }

  //   def double3(rng: RNG): ((Double, Double, Double), RNG) = {
  //     val (i1, r1) = nonNegativeInt(rng)
  //     val (i2, r2) = nonNegativeInt(r1)
  //     val (i3, r3) = nonNegativeInt(r2)
  //     ((i1.toDouble, i2.toDouble, i3.toDouble), r3)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1)
  //   val (n1, rng2) = rng.intDouble(rng)
  //   println(n1) // (384748,384748.0)
  //   println(rng2) // SimpleRNG(25214903928)
  //   val rng3 = SimpleRNG(-2)
  //   val (n2, rng4) = rng3.doubleInt(rng3)
  //   println(n2) // (769497.0,769497)
  //   println(rng4) // SimpleRNG(281424546902833)
  //   val rng5 = SimpleRNG(2)
  //   val (n3, rng6) = rng5.double3(rng5)
  //   println(n3) // (769497.0,1.988230381E9,1.277571484E9)
  //   println(rng6) // SimpleRNG(197748051927719)
  // }
  // 正解（模範とは微妙に違うけど）

  /** EXERCISE 6.4
    *
    * ランダムな整数のリストを生成する関数を記述せよ。
    *
    * def ints(count: Int)(rng: RNG): (List[Int], RNG)
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   // EXERCISE 6.4
  //   def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
  //     var l: List[Int] = List()
  //     var cr = rng
  //     for (_ <- 0 until count) {
  //       val (i, r) = cr.nextInt
  //       l = l :+ i
  //       cr = r
  //     }
  //     (l, cr)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1)
  //   val (n1, rng2) = rng.ints(5)(rng)
  //   println(n1) // List(384748, -1151252339, -549383847, 1612966641, -883454042)
  //   println(rng2) // SimpleRNG(223576932655868)
  // }
  // 正解（ただし、公式解は再帰関数だった）

  /** EXERCISE 6.5
    *
    * mapを使ってdoubleをもう少し要領よく実装し直せ。
    * EXERCISE 6.2を参照。
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // type Rand[+A] = RNG => (A, RNG)

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //     val (i, r) = rng.nextInt
  //     (if (i < 0) Math.abs(i + 1) else i, r)
  //   }

  //   def map[A, B](s: Rand[A])(f: A => B): Rand[B] = rng => {
  //     val (a, rng2) = s(rng)
  //     (f(a), rng2)
  //   }

  //   // EXERCISE 6.5
  //   def double: Rand[Double] =
  //     map(nonNegativeInt)(i => i / (Int.MaxValue.toDouble + 1))
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1000)
  //   val (n1, rng2) = rng.double(rng)
  //   println(n1) // 0.17916266806423664
  //   println(rng2) // SimpleRNG(25214903917011)
  //   val rng3 = SimpleRNG(-2000)
  //   val (n2, rng4) = rng3.double(rng3)
  //   println(n2) // 0.3583253361284733
  //   println(rng4) // SimpleRNG(231045168876667)
  // }
  // 正解

  /** EXERCISE 6.6
    *
    * 以下のシグネチャに基づいてmap2を実装せよ。
    * この関数は、raとrbの2つのアクションと、それらの結果を結合する関数fを受け取り、それらを結合する新しいアクションを返す。
    *
    * def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C]
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // type Rand[+A] = RNG => (A, RNG)

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //     val (i, r) = rng.nextInt
  //     (if (i < 0) Math.abs(i + 1) else i, r)
  //   }

  //   def map[A, B](s: Rand[A])(f: A => B): Rand[B] = rng => {
  //     val (a, rng2) = s(rng)
  //     (f(a), rng2)
  //   }

  //   // EXERCISE 6.6
  //   def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = rng => {
  //     val (a, ra2) = ra(rng)
  //     val (b, rb2) = rb(ra2)
  //     (f(a, b), rb2)
  //   }

  //   def intDouble: Rand[(Int, Double)] =
  //     map2(nonNegativeInt, nonNegativeInt)((a, b) => (a, b.toDouble))

  //   def doubleInt: Rand[(Double, Int)] =
  //     map2(nonNegativeInt, nonNegativeInt)((a, b) => (a.toDouble, b))
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1)
  //   val (n1, rng2) = rng.intDouble(rng)
  //   println(n1) // (384748,1.151252338E9)
  //   println(rng2) // SimpleRNG(206026503483683)
  //   val rng3 = SimpleRNG(-2)
  //   val (n2, rng4) = rng3.doubleInt(rng3)
  //   println(n2) // (769497.0,1979765906)
  //   println(rng4) // SimpleRNG(151729038283240)
  // }
  // 正解

  /** EXERCISE 6.7
    *
    * 2つのRNG遷移の組み合わせが可能であるとしたら、それらのリスト全体を結合することも可能であるはずだ。
    * 遷移のListを1つの遷移にまとめるためのsequenceを実装せよ。
    * それを使って、以前に記述したints関数を再実装せよ。
    * その際には、標準ライブラリの`List.fill(n)(x)`関数を使ってxをn回繰り返すリストを作成できる。
    *
    * def sequence[A](fs: List[Rand[A]]): Rand[List[A]]
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // type Rand[+A] = RNG => (A, RNG)

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def unit[A](a: A): Rand[A] = rng => (a, rng)

  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //     val (i, r) = rng.nextInt
  //     (if (i < 0) Math.abs(i + 1) else i, r)
  //   }

  //   def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = rng => {
  //     val (a, ra2) = ra(rng)
  //     val (b, rb2) = rb(ra2)
  //     (f(a, b), rb2)
  //   }

  //   // EXERCISE 6.7
  //   def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = rng => {
  //     var l: List[Int] = List()
  //     var cr = rng
  //     for (i <- fs) {
  //       val (a, r) = cr.nextInt
  //       l = l :+ a
  //     }
  //     (l, cr)
  //   }

  //   def ints(count: Int)(rng: RNG): (List[Int], RNG) =
  //     sequence(List.fill(count)(rng.nextInt))
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1)
  //   val (n1, rng2) = rng.ints(3)(rng)
  //   println(n1) // List(384748, 1151252338, 549383846)
  //   println(rng2) // SimpleRNG(245470556921330)
  //   val rng3 = SimpleRNG(1)
  //   val (n2, rng4) = rng3.ints(0)(rng3)
  //   println(n2) // List()
  //   println(rng4) // SimpleRNG(1)
  // }
  // 不正解、正解は以下
  // def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
  //   fs.foldRight(unit(Nil: List[A]))((r, acc) => map2(r, acc)(_ :: _))

  // def ints(count: Int): Rand[List[Int]] =
  //   sequence(List.fill(count)(nonNegativeInt))

  /** EXERCISE 6.8
    *
    * flatMapを実装し、それを使ってnonNegativeLessThanを実装せよ。
    *
    * def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B]
    * def nonNegativeLessThan(n: Int): Rand[Int]
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // type Rand[+A] = RNG => (A, RNG)

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def unit[A](a: A): Rand[A] = rng => (a, rng)

  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //     val (i, r) = rng.nextInt
  //     (if (i < 0) Math.abs(i + 1) else i, r)
  //   }

  //   // EXERCISE 6.8
  //   def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = rng => {
  //     val (a, rng2) = f(rng)
  //     (g(a)(rng2)._1, rng2)
  //   }

  //   def nonNegativeLessThan(n: Int): Rand[Int] = rng =>
  //     flatMap(nonNegativeInt) { (i) =>
  //       val mod = i % n
  //       if (i + (n - 1) - mod >= 0) {
  //         unit(mod)
  //       } else {
  //         nonNegativeLessThan(n)
  //       }
  //     }(rng)
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1)
  //   val (n1, rng2) = rng.nonNegativeLessThan(10)(rng)
  //   println(n1) // 8
  //   println(rng2) // SimpleRNG(25214903928)
  //   val rng3 = SimpleRNG(13)
  //   val (n2, rng4) = rng3.nonNegativeLessThan(10)(rng3)
  //   println(n2) // 5
  //   println(rng4) // SimpleRNG(327793750932)
  // }
  // 正解？答えは合ってるけど、模範の方が良い
  // def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = rng => {
  //   val (a, rng2) = f(rng)
  //   g(a)(rng2)
  // }

  // def nonNegativeLessThan(n: Int): Rand[Int] =
  //   flatMap(nonNegativeInt) { i =>
  //     val mod = i % n
  //     if (i + (n - 1) - mod >= 0) {
  //       unit(mod)
  //     } else {
  //       nonNegativeLessThan(n)
  //     }
  //   }

  /** EXERCISE 6.9
    *
    * flatMapを使ってmapとmap2を再実装せよ。
    * これが可能であることは、flatMapがmapとmap2よりも強力であると述べていることから明らかである。
    */
  // trait RNG {
  //   def nextInt: (Int, RNG)
  // }

  // type Rand[+A] = RNG => (A, RNG)

  // case class SimpleRNG(seed: Long) extends RNG {
  //   def unit[A](a: A): Rand[A] = rng => (a, rng)

  //   def nextInt: (Int, RNG) = {
  //     val newSeed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL
  //     val nextRNG = SimpleRNG(newSeed)
  //     val n = (newSeed >>> 16).toInt
  //     (n, nextRNG)
  //   }

  //   def nonNegativeInt(rng: RNG): (Int, RNG) = {
  //     val (i, r) = rng.nextInt
  //     (if (i < 0) Math.abs(i + 1) else i, r)
  //   }

  //   def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = rng => {
  //     val (a, rng2) = f(rng)
  //     g(a)(rng2)
  //   }

  //   def intDouble: Rand[(Int, Double)] =
  //     map2(nonNegativeInt, nonNegativeInt)((a, b) => (a, b.toDouble))

  //   def nonNegativeEven: Rand[Int] = map(nonNegativeInt)(i => i - i % 2)

  //   // EXERCISE 6.9
  //   def map[A, B](s: Rand[A])(f: A => B): Rand[B] =
  //     flatMap(s)(a => unit(f(a)))

  //   def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
  //     flatMap(ra)(a => map(rb)(b => f(a, b)))
  // }

  // def main(args: Array[String]): Unit = {
  //   val rng = SimpleRNG(1)
  //   val (n1, rng2) = rng.nonNegativeEven(rng)
  //   println(n1) // 384384
  //   println(rng2) // SimpleRNG(25214903928)
  //   val rng3 = SimpleRNG(1)
  //   val (n2, rng4) = rng3.intDouble(rng3)
  //   println(n2) // (384748,1.151252338E9)
  //   println(rng4) // SimpleRNG(206026503483683)
  // }
  // 正解

  /** EXERCISE 6.10
    *
    * unit、map、map2、flatMap、sequenceの5つの関数を一般化せよ。
    * 可能であれば、それらをStateケースクラスのメソッドとして追加せよ。
    * それが不可能であれば、Stateコンパニオンオブジェクトに配置せよ。
    */
  // trait RNG
  // case class SimpleRNG(seed: Long) extends RNG

  // case class State[S, +A](run: S => (A, S)) {
  //   // EXERCISE 6.10
  //   def map[B](f: A => B): State[S, B] = State { s =>
  //     (f(run(s)._1), s)
  //   }

  //   def map2[B, C](sb: State[S, B])(f: (A, B) => C): State[S, C] = State { s =>
  //     (f(run(s)._1, sb.run(s)._1), s)
  //   }

  //   def flatMap[B](f: A => State[S, B]): State[S, B] = State { s =>
  //     (f(run(s)._1).run(s)._1, s)
  //   }
  // }

  // object State {
  //   // EXERCISE 6.10
  //   def unit[S, A](a: A): State[S, A] = State { s =>
  //     (a, s)
  //   }

  //   def sequence[S, A](sas: List[State[S, A]]): State[S, List[A]] = State { s =>
  //     sas.foldRight((Nil: List[A], s))((r, acc) => map2(r, acc)(_ :: _))
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   val (n1, rng1) = State.unit(10).run(SimpleRNG(100))
  //   println(n1) // 10
  //   println(rng1) // SimpleRNG(100)
  //   val (n2, rng2) = State.unit(10).map(_ * 2).run(SimpleRNG(100))
  //   println(n2) // 20
  //   println(rng2) // SimpleRNG(100)
  //   val (n3, rng3) = State.unit(10).map2(State.unit(20): State[RNG, Int])(_ * _).run(SimpleRNG(100))
  //   println(n3) // 200
  //   println(rng3) // SimpleRNG(100)
  //   val (n4, rng4) = State.unit(10).flatMap(x => State.unit(x).map(_ * 3): State[RNG, Int]).run(SimpleRNG(100))
  //   println(n4) // 30
  //   println(rng4) // SimpleRNG(100)
  //   val (n5, rng5) = State
  //     .sequence(List(State.unit(10): State[RNG, Int], State.unit(11): State[RNG, Int], State.unit(12): State[RNG, Int]))
  //     .run(SimpleRNG(100))
  //   println(n5) // List(10, 11, 12)
  //   println(rng5) // SimpleRNG(100)
  // }
  // unit、map、map2は正解
  // flatMapは正解だが、以下がよい
  // def flatMap[B](f: A => State[S, B]): State[S, B] = State { s =>
  //   f(run(s)._1).run(s)
  // }
  // sequenceは不正解、正解は以下
  // def sequence[S, A](sas: List[State[S, A]]): State[S, List[A]] =
  //   sas.foldRight(unit[S, List[A]](Nil))((sa, acc) => sa.map2(acc)(_ :: _))

  /** EXERCISE 6.11
    *
    * Stateの使用に慣れるために、単純なスナックの自動販売機をモデリングする有限状態オートマトンを実装せよ。
    * この自動販売機では、2種類の入力を使用する。
    * すなわち、硬貨を投入することができ、ハンドルを回してスナックを取り出すことができる。
    * 自動販売機はロックされた状態とロックが解除された状態のどちらかになる。
    * また、残りのスナックの数と自動販売機に投入された硬貨の数も追跡する。
    *
    * sealed trait Input
    * case object Coin extends Input
    * case object Turn extends Input
    * case class Machine(locked: Boolean, candies: Int, coins: Int)
    *
    * 自動販売機のルールは以下のとおり。
    * ・ロックされた状態の自動販売機に硬貨を投入すると、スナックが残っている場合はロックが解除される。
    * ・ロックが解除された状態の自動販売機のハンドルを回すと、スナックが出てきてロックがかかる。
    * ・ロックされた状態でハンドルを回したり、ロックが解除された状態で硬貨を投入したりしても何も起こらない。
    * ・スナックが売り切れた自動販売機は入力をすべて無視する。
    *
    * simulateMachineメソッドは、入力のリストに基づいて自動販売機を操作し、最後に自動販売機の中にある硬貨とスナックの数を返す。
    * たとえば、入力であるMachineに硬貨が10枚、スナックが5個入っていて、合計で4個のスナックが正常に購入された場合、出力は(14, 1)になるはずだ。
    *
    * def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)]
    */
  // 答え見た
  // case class State[S, +A](run: S => (A, S)) {
  //   def unit[S, A](a: A): State[S, A] = State(s => (a, s))
  //   def map[B](f: A => B): State[S, B] =
  //     flatMap(a => unit(f(a)))
  //   def map2[B, C](sb: State[S, B])(f: (A, B) => C): State[S, C] =
  //     flatMap(a => sb.map(b => f(a, b)))
  //   def flatMap[B](f: A => State[S, B]): State[S, B] =
  //     State(s => {
  //       val (a, s1) = run(s)
  //       f(a).run(s1)
  //     })
  // }

  // object State {
  //   def unit[S, A](a: A): State[S, A] = State(s => (a, s))
  //   def sequence[S, A](sas: List[State[S, A]]): State[S, List[A]] =
  //     sas.foldRight(unit[S, List[A]](List()))((f, acc) => f.map2(acc)(_ :: _))
  //   def modify[S](f: S => S): State[S, Unit] =
  //     for {
  //       s <- get
  //       _ <- set(f(s))
  //     } yield ()

  //   def get[S]: State[S, S] = State(s => (s, s))
  //   def set[S](s: S): State[S, Unit] = State(_ => ((), s))
  // }

  // // EXERCISE 6.11
  // sealed trait Input

  // case object Coin extends Input
  // case object Turn extends Input

  // case class Machine(locked: Boolean, candies: Int, coins: Int)

  // object Machine {
  //   def update =
  //     (i: Input) =>
  //       (s: Machine) =>
  //         (i, s) match {
  //           // スナックが売り切れた自動販売機は入力をすべて無視
  //           case (_, Machine(_, 0, _)) => s
  //           // ロック解除状態で硬貨を投入しても何も起こらない
  //           case (Coin, Machine(false, _, _)) => s
  //           // ロック状態でハンドルを回しても何も起こらない
  //           case (Turn, Machine(true, _, _)) => s
  //           // ロック状態の自動販売機に硬貨を投入すると、スナックが残っていればロックが解除される
  //           // （このスナックが残っていればの条件は上の`case (_, Machine(_, 0, _)) => s`で網羅されている）
  //           case (Coin, Machine(true, candy, coin)) =>
  //             Machine(false, candy, coin + 1)
  //           // ロック解除状態の自動販売機のハンドルを回すと、スナックが出てきてロック状態になる
  //           case (Turn, Machine(false, candy, coin)) =>
  //             Machine(true, candy - 1, coin)
  //         }

  //   def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] =
  //     for {
  //       _ <- State.sequence(inputs.map(((i: Machine => Machine) => State.modify(i)).compose(update)))
  //       s <- State.get
  //     } yield (s.coins, s.candies)
  // }

  // def main(args: Array[String]): Unit = {
  //   println(Machine.simulateMachine(List(Turn)).run(Machine(true, 0, 5))) // ((5,0),Machine(true,0,5))
  //   println(Machine.simulateMachine(List(Coin)).run(Machine(true, 0, 5))) // ((5,0),Machine(true,0,5))
  //   println(Machine.simulateMachine(List(Coin)).run(Machine(false, 5, 5))) // ((5,5),Machine(false,5,5))
  //   println(Machine.simulateMachine(List(Turn)).run(Machine(true, 5, 5))) // ((5,5),Machine(true,5,5))
  //   println(Machine.simulateMachine(List(Coin)).run(Machine(true, 5, 5))) // ((6,5),Machine(false,5,6))
  //   println(Machine.simulateMachine(List(Turn)).run(Machine(false, 5, 5))) // ((5,4),Machine(true,4,5))
  //   println(
  //     Machine.simulateMachine(List(Coin, Turn, Coin, Turn, Coin, Turn)).run(Machine(true, 3, 3))
  //   ) // ((6,0),Machine(true,0,6))
  // }
}
