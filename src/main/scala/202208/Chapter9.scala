package `202208`

object Chapter9 {

  /** EXERCISE 9.1
    *
    * productを使ってコンビネータmap2を実装し、これを使って、manyをベースとしてmany1を実装せよ。
    * ここまでの章と同様に、map2をプリミティブにし、map2をベースとしてproductを定義することもできる。
    * どちらを選択するかはあなた次第である。
    *
    * def map2[A, B, C](p: Parser[A], p2: Parser[B])(f: (A, B) => C): Parser[C]
    */

  /** EXERCISE 9.2
    *
    * productの振る舞いを定義する法則を考え出せ。
    */

  /** EXERCISE 9.3
    *
    * 先へ進む前に、or、map2、succeedをベースとしてmanyを定義できるか検討せよ。
    */

  /** EXERCISE 9.4
    *
    * map2とsucceedを使って先のlistOfNコンビネータを実装せよ。
    *
    * def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]]
    */

  /** EXERCISE 9.5
    *
    * 第7章で示したように、非正格性に別のコンビネータで対処することもできる。
    * ここでもそれを試して、既存のコンビネータに必要な変更を追加せよ。
    * このアプローチをここで試すことについてどう思うか。
    */

  /** EXERCISE 9.6
    *
    * flatMapと他のコンビネータを使って、先ほど表現できなかった文脈依存パーサーを記述せよ。
    * 数字の解析には、正規表現をParserへ昇格させる新しいプリミティブregexを使用できる。
    * Scalaで文字列sを（マッチング用のメソッドが定義されている）Regexオブジェクトに処理させるには、s.rを"[a-zA-Z_][a-zA-Z0-9_]*".rのように使用すればよい。
    *
    * implicit def regex(r: Regex): Parser[String]
    */

  /** EXERCISE 9.7
    *
    * flatMapをベースとしてproductとmap2を実装せよ。
    */

  /** EXERCISE 9.8
    *
    * mapはもはやプリミティブではない。
    * flatMapや他のコンビネータをベースとして表現せよ。
    */
}
