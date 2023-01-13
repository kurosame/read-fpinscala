package `202208`

object Chapter7 {

  /** EXERCISE 7.1
    *
    * Par.map2は2つの並列計算の結果を結合する新しい高階関数である。
    * そのシグネチャはどのようなものになるか。
    * Intにのみ対応すると想定せず、できるだけ汎用的なシグネチャを示せ。
    */
  // def map2[A, B, C](pa: Par[A], pb: Par[B])(f: (A, B) => C): Par[C]
  // 正解

  /** EXERCISE 7.2
    *
    * 先へ進む前に、このAPIの関数を実装できるParの表現を考えだせ。
    */

  /** EXERCISE 7.3
    *
    * map2の実装を修正し、Futureのタイムアウトの規約に従うようにせよ。
    */

  /** EXERCISE 7.4
    *
    * このAPIでは、すでにさまざまな演算が可能である。
    * 簡単な例として、lazyUnitを使って関数を記述せよ。
    * この関数は、任意の関数`A => B`から、その結果を非同期で評価する関数へと変換する。
    *
    * def asyncF[A, B](f: A => B): A => Par[B]
    */
}
