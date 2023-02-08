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

  /** EXERCISE 7.5
    *
    * このsequenceという関数を記述せよ。
    * 追加のプリミティブは必要ない。
    * runを呼び出さないこと。
    *
    * def sequence[A](ps: List[Par[A]]): Par[List[A]]
    */

  /** EXERCISE 7.6
    *
    * リストの要素を並行してフィルタリングするparFilterを実装せよ。
    *
    * def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]]
    */

  /** EXERCISE 7.7
    *
    * `map(y)(id) == y`であると仮定した場合、それは`map(map(y)(g))(f) == map(y)(f compose g)`が成り立つフリー定理である。
    * これを証明することはできるか。
    */

  /** EXERCISE 7.8
    *
    * ExecutorServiceのさまざまな実装の感触をつかむために、Executorsのさまざまな静的メソッドを調べてみる。
    * その後、forkの実装を見直し、反例を探すか、その実装が法則に違反しないことを確認した上で、次に進むこと。
    */

  /** EXERCISE 7.9
    *
    * このforkの実装を前提とした場合に、固定サイズのスレッドプールがデッドロックに陥る可能性があることを示せ。
    */

  /** EXERCISE 7.10
    *
    * このノンブロッキング実装は、今のところエラーをまったく処理しない。
    * 何らかのタイミングで例外がスローされた場合、run実装のlatchは解放されず、例外は単に飲み込まれてしまう。
    * これを修正することは可能か。
    */
}
