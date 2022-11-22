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

  /**
    */
}
